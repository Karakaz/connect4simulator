package io.karakaz.connect4simulator;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.karakaz.connect4simulator.game.GameSimulator;
import io.karakaz.connect4simulator.init.GameProvider;
import io.karakaz.connect4simulator.init.SimulationConfig;
import io.karakaz.connect4simulator.simulation.ConnectFourSimulation;
import io.karakaz.connect4simulator.simulation.SimulationSaver;

public class Simulator {

	private final SimulationConfig simulationConfig;
	private final SimulationSaver simulationSaver;

	@Inject
	public Simulator(SimulationConfig simulationConfig, SimulationSaver simulationSaver) {
		this.simulationConfig = simulationConfig;
		this.simulationSaver = simulationSaver;
	}

	public void simulate(GameProvider gameProvider) {
		GameSimulator gameSimulator = new GameSimulator(gameProvider, simulationConfig);

		List<ConnectFourSimulation> simulations = new ArrayList<>();

		while (!gameSimulator.isDone()) {
			simulations.add(gameSimulator.simulateGame());

			if (simulations.size() >= simulationConfig.getSqlBatchSize()) {
				System.out.println("Saving simulations, progress " + gameSimulator.getProgress());
				simulationSaver.saveSimulations(simulations);
				simulations.clear();
			}
		}
		if (!simulations.isEmpty()) {
			simulationSaver.saveSimulations(simulations);
		}
	}
}
