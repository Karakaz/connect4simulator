package io.karakaz.connect4simulator.simulation;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import io.karakaz.connect4simulator.board.state.State;
import io.karakaz.connect4simulator.db.insertion.SimulationInserter;
import io.karakaz.connect4simulator.db.insertion.SimulationStateInserter;
import io.karakaz.connect4simulator.db.insertion.StateInserter;

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
		List<Long> stateOutputIds = saveWinnerStates(connectFourSimulation);
		long simulation_id = simulationInserter.insertSimulation(connectFourSimulation);
		simulationStateInserter.insert(simulation_id, stateOutputIds);
	}

	private List<Long> saveWinnerStates(ConnectFourSimulation simulation) {
		List<State> states = simulation.getStateHistory().getStates();
		return states.stream()
			 .filter(s -> s.getLatestDisc() == simulation.getWinner())
			 .map(stateInserter::insertState)
			 .collect(Collectors.toList());
	}
}
