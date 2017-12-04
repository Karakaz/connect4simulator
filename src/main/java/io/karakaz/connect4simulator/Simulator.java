package io.karakaz.connect4simulator;

import javax.inject.Inject;

import io.karakaz.connect4simulator.simulation.ConnectFourSimulation;

public class Simulator {

	private final SimulationConfig simulationConfig;
	private final SimulationSaver simulationSaver;

	@Inject
	Simulator(SimulationConfig simulationConfig, SimulationSaver simulationSaver) {
		this.simulationConfig = simulationConfig;
		this.simulationSaver = simulationSaver;
	}

	public void simulate(GameProvider gameProvider) {
		GameSimulator gameSimulator = new GameSimulator(gameProvider, simulationConfig);

		while (!gameSimulator.isDone()) {
			simulationSaver.savetSimulation(gameSimulator.simulateGame());

		}
	}
}
