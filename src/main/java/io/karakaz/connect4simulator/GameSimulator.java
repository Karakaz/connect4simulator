package io.karakaz.connect4simulator;

import io.karakaz.connect4simulator.simulation.ConnectFourSimulation;

public class GameSimulator {

	private final GameProvider gameProvider;
	private final SimulationConfig simulationConfig;

	private int simulationNr;

	GameSimulator(GameProvider gameProvider, SimulationConfig simulationConfig) {
		this.gameProvider = gameProvider;
		this.simulationConfig = simulationConfig;
	}

	ConnectFourSimulation simulateGame() {
		Game game = gameProvider.provideGame();
		while (!game.gameOver().isPresent()) {
			game.playTurn();
		}
//		System.out.println(game.getStateHistory());
		return new ConnectFourSimulation(game);
	}

	public boolean isDone() {
		if (simulationNr++ < simulationConfig.getMaxSimulationNumber()) {
			return false;
		}
		return true;
	}
}
