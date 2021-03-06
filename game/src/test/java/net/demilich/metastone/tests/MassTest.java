package net.demilich.metastone.tests;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import co.paralleluniverse.fibers.Suspendable;
import net.demilich.metastone.game.actions.GameAction;
import net.demilich.metastone.game.entities.Entity;
import net.demilich.metastone.game.events.GameEvent;
import net.demilich.metastone.game.spells.trigger.Trigger;
import net.demilich.metastone.game.targeting.Zones;
import net.demilich.metastone.tests.util.TestBase;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import net.demilich.metastone.game.GameContext;
import net.demilich.metastone.game.Player;
import net.demilich.metastone.game.behaviour.PlayRandomBehaviour;
import net.demilich.metastone.game.decks.DeckFactory;
import net.demilich.metastone.game.decks.DeckFormat;
import net.demilich.metastone.game.entities.heroes.HeroClass;
import net.demilich.metastone.game.logic.GameLogic;
import net.demilich.metastone.game.gameconfig.PlayerConfig;

public class MassTest extends TestBase {

	private static HeroClass getRandomClass() {
		HeroClass randomClass = HeroClass.ANY;
		HeroClass[] values = HeroClass.values();
		while (!randomClass.isBaseClass()) {
			randomClass = values[ThreadLocalRandom.current().nextInt(values.length)];
		}
		return randomClass;
	}

	@BeforeTest
	private void loggerSetup() {
		Logger root = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
		root.setLevel(Level.ERROR);
	}

	@Test
	public void testRandomMassPlay() {
		loggerSetup();
		int tests = Boolean.parseBoolean(System.getenv("CI")) ? 1000 : 10000;
		IntStream.range(0, tests).parallel().forEach(i -> oneGame());
	}

	private void oneGame() {
		DeckFormat deckFormat = DeckFormat.CUSTOM;
		HeroClass heroClass1 = getRandomClass();
		PlayerConfig player1Config = new PlayerConfig(DeckFactory.getRandomDeck(heroClass1, deckFormat), new PlayRandomBehaviour());
		player1Config.setName("Player 1");
		player1Config.setHeroCard(HeroClass.getHeroCard(heroClass1));
		Player player1 = new Player(player1Config);

		HeroClass heroClass2 = getRandomClass();
		PlayerConfig player2Config = new PlayerConfig(DeckFactory.getRandomDeck(heroClass2, deckFormat), new PlayRandomBehaviour());
		player2Config.setName("Player 2");
		player2Config.setHeroCard(HeroClass.getHeroCard(heroClass2));
		Player player2 = new Player(player2Config);
		GameLogic logic = new GameLogic();
		GameContext context = new GameContext(player1, player2, logic, deckFormat) {
			protected void assertValidEntities() {
				getEntities().forEach(e -> {
							final boolean isValid = e.getEntityLocation().getIndex() >= 0
									&& e.getEntityLocation().getZone() != Zones.NONE
									&& e.getId() >= 0;
							if (!isValid) {
								final String message =
										"\nEntity:\n"
												+ e.toString()
												+ "\nLocation:\n"
												+ e.getEntityLocation().toString();
								logger.error(message);
								logger.error("Trace:");
								logger.error(getTrace().dump());
								Assert.fail();
							}
						}
				);
				boolean distinctLocations = getEntities().map(Entity::getEntityLocation).distinct().count() == getEntities().count();
				if (!distinctLocations) {
					logger.error("Entities do not have distinct locations.");
					logger.error("Trace:");
					logger.error(getTrace().dump());
					Assert.fail();
				}
			}

			@Override
			public void onDidPerformGameAction(int playerId, GameAction action) {
				// Assert that at the end of every game action, all the entities have valid
				// locations and indices
				super.onDidPerformGameAction(playerId, action);
				assertValidEntities();
			}

			@Override
			@Suspendable
			public void fireGameEvent(GameEvent gameEvent, List<Trigger> otherTriggers) {
				super.fireGameEvent(gameEvent, otherTriggers);
				assertValidEntities();
			}
		};
		context.play();
		context.dispose();
	}

}
