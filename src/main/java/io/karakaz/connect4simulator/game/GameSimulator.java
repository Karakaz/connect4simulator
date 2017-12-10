package io.karakaz.connect4simulator.game;

import io.karakaz.connect4simulator.init.GameProvider;
import io.karakaz.connect4simulator.init.SimulationConfig;
import io.karakaz.connect4simulator.simulation.ConnectFourSimulation;

public class GameSimulator {

	private final GameProvider gameProvider;
	private final SimulationConfig simulationConfig;

	private int simulationNr;

	public GameSimulator(GameProvider gameProvider, SimulationConfig simulationConfig) {
		this.gameProvider = gameProvider;
		this.simulationConfig = simulationConfig;
	}

	public ConnectFourSimulation simulateGame() {
		Game game = gameProvider.provideGame();
		while (!game.gameOver().isPresent()) {
			game.playTurn();
		}
//		System.out.println(game.getStateHistory().getFinalState());
//		System.out.println(game.getStateHistory());
		return new ConnectFourSimulation(game);
	}

	public boolean isDone() {
		if (simulationNr++ < simulationConfig.getMaxSimulations()) {
			return false;
		}
		return true;
	}
}
