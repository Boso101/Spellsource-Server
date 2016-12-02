package com.hiddenswitch.proto3.server;

import co.paralleluniverse.fibers.Suspendable;
import com.hiddenswitch.proto3.net.common.*;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import net.demilich.metastone.game.Player;
import net.demilich.metastone.game.actions.GameAction;
import net.demilich.metastone.game.behaviour.human.HumanBehaviour;
import net.demilich.metastone.game.cards.Card;
import net.demilich.metastone.game.cards.CardSet;
import net.demilich.metastone.game.decks.DeckFormat;
import net.demilich.metastone.game.gameconfig.PlayerConfig;
import net.demilich.metastone.game.targeting.IdFactory;

import java.util.List;

public class ServerGameSession extends GameSession implements ServerCommunicationSend, ServerListener {
	private String host;
	private int port;
	private SocketClientReceiver c1;
	private SocketClientReceiver c2;
	private PregamePlayerConfiguration pregamePlayerConfiguration1;
	private PregamePlayerConfiguration pregamePlayerConfiguration2;
	private ServerGameContext gameContext;
	private Player player1;
	private Player player2;
	private final String gameId;
	private Logger logger = LoggerFactory.getLogger(ServerGameSession.class);

	private ClientConnectionConfiguration getConfigurationFor(PregamePlayerConfiguration player, int id) {
		// TODO: It's obviously insecure to allow the client to specify things like their player object
		Player tempPlayer = player.getPlayer();
		if (tempPlayer == null) {
			PlayerConfig playerConfig = new PlayerConfig(player.getDeck(), new HumanBehaviour());
			tempPlayer = new Player(playerConfig);
		}
		tempPlayer.setId(id);
		return new ClientConnectionConfiguration(getHost(), getPort(),
				new ClientToServerMessage(tempPlayer, getGameId()));
	}

	@Override
	@Suspendable
	public void onPlayerConnected(Player player) {
		logger.debug("Receive connections from {}", player.toString());
		if (player.getId() == IdFactory.PLAYER_1) {
			if (getPlayer1() != null) {
				throw new RuntimeException("Two players tried to connect to the same player slot.");
			}
			setPlayer1(player);
		} else if (player.getId() == IdFactory.PLAYER_2) {
			if (getPlayer2() != null) {
				throw new RuntimeException("Two players tried to connect to the same player slot.");
			}
			setPlayer2(player);
		} else {
			throw new RuntimeException("A player without an ID set has attempted to connect.");
		}

		if (areBothPlayersConnected()) {
			startGame();
		}
	}

	protected boolean areBothPlayersConnected() {
		return player1 != null
				&& player2 != null;
	}

	protected void startGame() {
		logger.debug("Starting game...");
		DeckFormat simpleFormat = new DeckFormat().withCardSets(CardSet.values());
		// Configure the network behaviours on the players
		getPlayer1().setBehaviour(new NetworkBehaviour(getPlayer1().getBehaviour()));
		getPlayer2().setBehaviour(new NetworkBehaviour(getPlayer2().getBehaviour()));
		this.gameContext = new ServerGameContext(getPlayer1(), getPlayer2(), simpleFormat, getGameId());
		getGameContext().setUpdateListener(getPlayer1(), getPlayerListener(IdFactory.PLAYER_1));
		getGameContext().setUpdateListener(getPlayer2(), getPlayerListener(IdFactory.PLAYER_2));
		getGameContext().networkPlay();
	}

	@Override
	@Suspendable
	public void onActionReceived(String id, Player callingPlayer, GameAction action) {
		checkContext();
		getGameContext().onActionReceived(id, callingPlayer, action);
	}

	@Override
	public void onMulliganReceived(String id, Player player, List<Card> ReceivedCards) {
		checkContext();
		getGameContext().onMulliganReceived(id, player, ReceivedCards);
	}

	@Override
	public ClientConnectionConfiguration getConfigurationForPlayer1() {
		return getConfigurationFor(pregamePlayerConfiguration1, IdFactory.PLAYER_1);
	}

	@Override
	public ClientConnectionConfiguration getConfigurationForPlayer2() {
		return getConfigurationFor(pregamePlayerConfiguration2, IdFactory.PLAYER_2);
	}

	public ServerGameSession(String host, int port, PregamePlayerConfiguration p1, PregamePlayerConfiguration p2, String gameId) {
		super();
		setHost(host);
		setPort(port);
		this.pregamePlayerConfiguration1 = p1;
		this.pregamePlayerConfiguration2 = p2;
		this.gameId = gameId;
	}

	@Override
	public RemoteUpdateListener getPlayerListener(int player) {
		if (player == 0) {
			return getClient1();
		} else {
			return getClient2();
		}
	}

	@Suspendable
	public void kill() {

	}

	private void checkContext() {
		if (getGameContext() == null) {
			throw new NullPointerException(String.format("The game context for this game session is null. gameId: %s", getGameId()));
		}
	}

	public String getHost() {
		return host;
	}

	private void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	private void setPort(int port) {
		this.port = port;
	}

	public SocketClientReceiver getClient1() {
		return c1;
	}

	public void setClient1(SocketClientReceiver c1) {
		this.c1 = c1;
	}

	public SocketClientReceiver getClient2() {
		return c2;
	}

	public void setClient2(SocketClientReceiver c2) {
		this.c2 = c2;
	}

	public ServerGameContext getGameContext() {
		return gameContext;
	}

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public String getGameId() {
		return gameId;
	}
}