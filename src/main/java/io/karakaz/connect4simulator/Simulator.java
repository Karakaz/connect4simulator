package io.karakaz.connect4simulator;

import javax.inject.Inject;

import io.karakaz.connect4simulator.db.SimulationInserter;
import io.karakaz.connect4simulator.simulation.ConnectFourSimulation;

public class Simulator {

	private final SimulationConfig simulationConfig;
	private final SimulationInserter simulationInserter;

	@Inject
	Simulator(SimulationConfig simulationConfig, SimulationInserter simulationInserter) {
		this.simulationConfig = simulationConfig;
		this.simulationInserter = simulationInserter;
	}

	public void simulate(GameProvider gameProvider) {
		GameSimulator gameSimulator = new GameSimulator(gameProvider, simulationConfig);

		while (!gameSimulator.isDone()) {
			ConnectFourSimulation connectFourSimulation = gameSimulator.simulateGame();
			simulationInserter.insertSimulation(connectFourSimulation);
		}
	}
}
