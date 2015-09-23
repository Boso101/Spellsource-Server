package net.demilich.metastone.game.spells;

import java.util.Map;

import net.demilich.metastone.game.GameContext;
import net.demilich.metastone.game.Player;
import net.demilich.metastone.game.cards.CardCatalogue;
import net.demilich.metastone.game.cards.HeroCard;
import net.demilich.metastone.game.entities.Entity;
import net.demilich.metastone.game.entities.heroes.Hero;
import net.demilich.metastone.game.spells.desc.SpellArg;
import net.demilich.metastone.game.spells.desc.SpellDesc;
import net.demilich.metastone.game.targeting.EntityReference;

public class ChangeHeroSpell extends Spell {

	public static SpellDesc create(Hero hero) {
		Map<SpellArg, Object> arguments = SpellDesc.build(ChangeHeroSpell.class);
		arguments.put(SpellArg.ENTITY, hero);
		arguments.put(SpellArg.TARGET, EntityReference.NONE);
		return new SpellDesc(arguments);
	}

	@Override
	protected void onCast(GameContext context, Player player, SpellDesc desc, Entity source, Entity target) {
		String heroCardId = (String) desc.get(SpellArg.CARD);
		HeroCard heroCard = (HeroCard) CardCatalogue.getCardById(heroCardId);
		context.getLogic().changeHero(player, heroCard.createHero());
	}

}