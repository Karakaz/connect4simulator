package io.karakaz.connect4simulator.simulation;

import io.karakaz.connect4simulator.Game;
import io.karakaz.connect4simulator.Player;
import io.karakaz.connect4simulator.board.state.MirroredState;
import io.karakaz.connect4simulator.board.state.State;
import io.karakaz.connect4simulator.board.state.StateHistory;

public class ConnectFourSimulation {

	private final Game game;

	public ConnectFourSimulation(Game game) {
		this.game = game;
	}

	public long getPlayer1Id() {
		return game.getPlayer1().getId();
	}

	public long getPlayer2Id() {
		return game.getPlayer2().getId();
	}
}
