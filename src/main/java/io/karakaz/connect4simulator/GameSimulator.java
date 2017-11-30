package io.karakaz.connect4simulator;

import javax.inject.Inject;

import io.karakaz.connect4simulator.board.Board;
import io.karakaz.connect4simulator.board.state.StateHistory;
import io.karakaz.connect4simulator.db.SimulationInserter;
import io.karakaz.connect4simulator.simulation.ConnectFourSimulation;

public class GameSimulator {

	private final GameProvider gameProvider;
	private final SimulationConfig simulationConfig;

	GameSimulator(GameProvider gameProvider, SimulationConfig simulationConfig) {
		this.gameProvider = gameProvider;
		this.simulationConfig = simulationConfig;
	}

	ConnectFourSimulation simulateGame() {
		Game game = gameProvider.provideGame();
		while (!game.gameOver().isPresent()) {
			game.playTurn();
		}
		System.out.println(game.getStateHistory());
		return new ConnectFourSimulation(game);
	}

	public boolean isDone() {
		return false;
	}
}
