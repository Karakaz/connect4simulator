package io.karakaz.connect4simulator;

import java.util.List;

import javax.inject.Inject;

import io.karakaz.connect4simulator.db.SimulationInserter;
import io.karakaz.connect4simulator.simulation.ConnectFourSimulation;

public class SimulationSaver {

	private final StateInserter stateInserter;
	private final SimulationInserter simulationInserter;
	private final SimulationStateInserter simulationStateInserter;

	@Inject
	SimulationSaver(StateInserter stateInserter, SimulationInserter simulationInserter, SimulationStateInserter simulationStateInserter) {
		this.simulationInserter = simulationInserter;
		this.stateInserter = stateInserter;
		this.simulationStateInserter = simulationStateInserter;
	}

	public void savetSimulation(ConnectFourSimulation connectFourSimulation) {
		List<Long> stateIds = saveStates(connectFourSimulation);
		long simulation_id = simulationInserter.insertSimulation(connectFourSimulation);
		simulationStateInserter.insert(simulation_id, stateIds);
	}

	private List<Long> saveStates(ConnectFourSimulation simulation) {
		return null;
	}
}
