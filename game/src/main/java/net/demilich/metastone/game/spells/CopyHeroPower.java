package net.demilich.metastone.game.spells;

import co.paralleluniverse.fibers.Suspendable;
import net.demilich.metastone.game.GameContext;
import net.demilich.metastone.game.Player;
import net.demilich.metastone.game.entities.Entity;
import net.demilich.metastone.game.spells.desc.SpellDesc;

public class CopyHeroPower extends ChangeHeroPowerSpell {

	@Override
	@Suspendable
	protected void onCast(GameContext context, Player player, SpellDesc desc, Entity source, Entity target) {
		Player opponent = context.getOpponent(player);
		String opponentHeroPowerId = opponent.getHero().getHeroPower().getCardId();
		changeHeroPower(context, opponentHeroPowerId, player.getHero(), player, desc);
	}

}
