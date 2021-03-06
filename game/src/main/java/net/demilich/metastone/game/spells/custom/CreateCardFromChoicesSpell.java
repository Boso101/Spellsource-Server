package net.demilich.metastone.game.spells.custom;

import co.paralleluniverse.fibers.Suspendable;
import net.demilich.metastone.game.cards.*;
import net.demilich.metastone.game.utils.Attribute;
import net.demilich.metastone.game.GameContext;
import net.demilich.metastone.game.Player;
import net.demilich.metastone.game.actions.DiscoverAction;
import net.demilich.metastone.game.entities.Entity;
import net.demilich.metastone.game.entities.heroes.HeroClass;
import net.demilich.metastone.game.entities.minions.Race;
import net.demilich.metastone.game.spells.NullSpell;
import net.demilich.metastone.game.spells.Spell;
import net.demilich.metastone.game.spells.SpellUtils;
import net.demilich.metastone.game.spells.desc.SpellArg;
import net.demilich.metastone.game.spells.desc.SpellDesc;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class CreateCardFromChoicesSpell extends Spell {
	public static SpellDesc create() {
		Map<SpellArg, Object> arguments = new SpellDesc(CreateCardFromChoicesSpell.class);
		return new SpellDesc(arguments);
	}

	@Override
	@Suspendable
	protected void onCast(GameContext context, Player player, SpellDesc desc, Entity source, Entity target) {
		Map<Integer, List<Card>> sourceCards = CardCatalogue.stream()
				.filter(Card::isCollectible)
				.filter(c -> c.getRace() == Race.BEAST)
				.filter(c -> c.getCardType() == CardType.MINION)
				.filter(c -> c.getHeroClass() == HeroClass.ANY || c.getHeroClass() == HeroClass.GREEN)
				.filter(c -> c.getBaseManaCost() <= 5)
				.filter(c -> context.getDeckFormat().isInFormat(c))
				.collect(groupingBy(c -> {
					if (c.hasAura()
							|| c.hasBattlecry()
							|| c.hasCardCostModifier()
							|| c.hasDeathrattle()
							|| c.hasTrigger()) {
						return 0;
					} else {
						return 1;
					}
				}));

		CardArrayList[] options = new CardArrayList[]{
				new CardArrayList(), new CardArrayList()
		};
		for (int i = 0; i < 2; i++) {
			List<Card> cards = sourceCards.get(i);
			cards.stream().filter(new RandomSubsetSelector(cards.size(), 3, context.getLogic().getRandom()))
					.forEach(options[i]::addCard);
		}

		SpellDesc nullSpell = NullSpell.create();
		// Eyeroll emoji.
		nullSpell.put(SpellArg.SPELL, NullSpell.create());

		DiscoverAction[] chosen = new DiscoverAction[2];
		for (int i = 0; i < 2; i++) {
			chosen[i] = SpellUtils.discoverCard(context, player, nullSpell, options[i]);
		}

		// According to https://us.battle.net/forums/en/hearthstone/topic/20759196602
		// Retrieve the first beast chosen, then apply the stats from the second beast as a buff
		// Except for the attack and health, that seems to just be baked in.
		Card card = chosen[0].getCard().getCopy();
		Card other = chosen[1].getCard().getCopy();
		card.getAttributes().put(Attribute.NAME, desc.getString(SpellArg.NAME));
		card.getAttributes().put(Attribute.DESCRIPTION, card.getDescription() + "\n" + other.getDescription());
		card.getAttributes().put(Attribute.ATTACK, card.getAttack() + other.getAttack());
		card.getAttributes().put(Attribute.BASE_ATTACK, card.getBaseAttack() + other.getBaseAttack());
		card.getAttributes().put(Attribute.HP, card.getHp() + other.getHp());
		card.getAttributes().put(Attribute.BASE_HP, card.getBaseHp() + other.getBaseHp());
		card.getAttributes().put(Attribute.BASE_MANA_COST, card.getBaseManaCost() + other.getBaseManaCost());
		for (Attribute attribute : other.getAttributes().keySet()) {
			if (attribute == Attribute.ATTACK
					|| attribute == Attribute.HP
					|| attribute == Attribute.BASE_ATTACK
					|| attribute == Attribute.BASE_HP
					|| attribute == Attribute.BASE_MANA_COST) {
				continue;
			}

			card.getAttributes().put(attribute, other.getAttributes().get(attribute));
		}

		// Then receive the card
		context.getLogic().receiveCard(player.getId(), card);
	}

}
