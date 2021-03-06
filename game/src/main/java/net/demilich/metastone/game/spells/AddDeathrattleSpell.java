package net.demilich.metastone.game.spells;

import java.util.Map;

import co.paralleluniverse.fibers.Suspendable;
import net.demilich.metastone.game.GameContext;
import net.demilich.metastone.game.Player;
import net.demilich.metastone.game.cards.Card;
import net.demilich.metastone.game.entities.Actor;
import net.demilich.metastone.game.entities.Entity;
import net.demilich.metastone.game.spells.desc.SpellArg;
import net.demilich.metastone.game.spells.desc.SpellDesc;
import net.demilich.metastone.game.targeting.EntityReference;

public class AddDeathrattleSpell extends Spell {

	public static SpellDesc create(EntityReference target, SpellDesc deathrattle) {
		Map<SpellArg, Object> arguments = new SpellDesc(AddDeathrattleSpell.class);
		arguments.put(SpellArg.SPELL, deathrattle);
		arguments.put(SpellArg.TARGET, target);
		return new SpellDesc(arguments);
	}

	public static SpellDesc create(SpellDesc deathrattle) {
		return create(null, deathrattle);
	}

	@Override
	@Suspendable
	protected void onCast(GameContext context, Player player, SpellDesc desc, Entity source, Entity target) {
		SpellDesc deathrattle = (SpellDesc) desc.get(SpellArg.SPELL);
		if (target instanceof Actor) {
			Actor actor = (Actor) target;
			actor.addDeathrattle(deathrattle.clone());
		} else if (target instanceof Card) {
			Card card = (Card) target;
			card.addDeathrattle(deathrattle.clone());
		}
	}

}
