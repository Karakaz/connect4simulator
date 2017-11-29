package io.karakaz.connect4simulator;

import javax.inject.Inject;

import io.karakaz.connect4simulator.board.Board;
import io.karakaz.connect4simulator.board.state.StateHistory;
import io.karakaz.connect4simulator.db.SimulationInserter;
import io.karakaz.connect4simulator.simulation.ConnectFourSimulation;

public class GameSimulator {

	@Inject
	Board board;

	public void simulateGames(SimulationConfig simulationConfig) {
		Player player1 = new Player();
		Player player2 = new Player();
		Game game = new Game(board, player1, player2);

		while (!game.gameOver().isPresent()) {
			game.playTurn();
		}

		ConnectFourSimulation connectFourSimulation = new ConnectFourSimulation(game);

		SimulationInserter simulationInserter = new SimulationInserter(connectFourSimulation);
	}
}
