package net.demilich.metastone.game.spells;

import co.paralleluniverse.fibers.Suspendable;
import net.demilich.metastone.game.GameContext;
import net.demilich.metastone.game.Player;
import net.demilich.metastone.game.cards.Card;
import net.demilich.metastone.game.cards.CardArrayList;
import net.demilich.metastone.game.cards.CardList;
import net.demilich.metastone.game.entities.Entity;
import net.demilich.metastone.game.entities.EntityLocation;
import net.demilich.metastone.game.spells.desc.SpellArg;
import net.demilich.metastone.game.spells.desc.SpellDesc;
import net.demilich.metastone.game.spells.desc.filter.EntityFilter;
import net.demilich.metastone.game.spells.desc.source.CardSource;
import net.demilich.metastone.game.spells.desc.source.CardSourceDesc;
import net.demilich.metastone.game.spells.desc.source.DeckSource;
import net.demilich.metastone.game.spells.trigger.secrets.Secret;
import net.demilich.metastone.game.targeting.Zones;

public class PutRandomSecretIntoPlaySpell extends Spell {

	private CardList findSecretCards(CardList cardList) {
		CardList secretCards = new CardArrayList();
		for (Card card : cardList) {
			if (card.isSecret()) {
				secretCards.addCard(card);
			}
		}
		return secretCards;
	}

	@Override
	@Suspendable
	protected void onCast(GameContext context, Player player, SpellDesc desc, Entity source, Entity target) {
		CardSource cardSource = (CardSource) desc.get(SpellArg.CARD_SOURCE);
		if (cardSource == null) {
			cardSource = new CardSourceDesc(DeckSource.class).create();
		}
		EntityFilter filter = (EntityFilter) desc.get(SpellArg.CARD_FILTER);
		int howMany = desc.getValue(SpellArg.HOW_MANY, context, player, target, source, 1);
		for (int i = 0; i < howMany; i++) {
			CardList secretCards = findSecretCards(cardSource.getCards(context, source, player));

			if (secretCards.isEmpty()) {
				return;
			}

			secretCards.shuffle(context.getLogic().getRandom());

			Card secretCard = secretCards.removeFirst();

			while (!secretCards.isEmpty()) {
				if (!context.getLogic().canPlaySecret(player, secretCard)
						&& (filter == null || filter.matches(context, player, secretCard, source))) {
					secretCard = secretCards.removeFirst();
				} else {
					break;
				}
			}
			if (secretCards.isEmpty() && !context.getLogic().canPlaySecret(player, secretCard)) {
				return;
			}

			if (secretCard.getEntityLocation().equals(EntityLocation.UNASSIGNED)) {
				secretCard.setId(context.getLogic().generateId());
				secretCard.setOwner(player.getId());
				secretCard.moveOrAddTo(context, Zones.SET_ASIDE_ZONE);
			}

			SpellDesc secretSpellDesc = secretCard.getSpell();
			Secret secret = (Secret) secretSpellDesc.get(SpellArg.SECRET);
			context.getLogic().playSecret(player, secret, false);
			if (secretCard.getZone() == Zones.DECK) {
				context.getLogic().removeCard(secretCard);
			} else {
				secretCard.moveOrAddTo(context, Zones.REMOVED_FROM_PLAY);
				context.getLogic().removeCard(secretCard);
			}


		}
	}

}