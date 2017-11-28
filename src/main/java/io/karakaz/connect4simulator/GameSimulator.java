package io.karakaz.connect4simulator;

import javax.inject.Inject;
import javax.inject.Named;

import io.karakaz.connect4simulator.board.Board;
import io.karakaz.connect4simulator.board.state.StateHistory;

public class GameSimulator {

	@Inject
	Board board;

	public void simulateGames(SimulationConfig simulationConfig) {
		Player player1 = new Player();
		Player player2 = new Player();
		GameSimulation connectFour = new GameSimulation(board, player1, player2);

		while (!connectFour.gameOver().isPresent()) {
			connectFour.playTurn();
		}

		StateHistory stateHistory = connectFour.getStateHistory();
		System.out.println(stateHistory);
	}
}
