package io.karakaz.connect4simulator.simulation;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.inject.Inject;

import io.karakaz.connect4simulator.board.state.State;
import io.karakaz.connect4simulator.db.data.StateOutput;
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

	public void saveSimulations(List<ConnectFourSimulation> simulations) {
		Map<ConnectFourSimulation, List<State>> winnerStatesBySimulation = simulations.stream()
			 .collect(Collectors.toMap(Function.identity(), this::getWinnerStates));

		winnerStatesBySimulation.forEach((simulation, states) -> {
			List<StateOutput> stateOutputs = stateInserter.saveWinnerStates(states);
			saveSimulation(simulation, stateOutputs);
		});
	}

	private List<State> getWinnerStates(ConnectFourSimulation simulation) {
		return simulation.getStateHistory().getStates().stream()
			 .filter(s -> s.getOutputDisc() == simulation.getWinner())
			 .collect(Collectors.toList());
	}

	public void saveSimulation(ConnectFourSimulation connectFourSimulation, List<StateOutput> stateOutputs) {
		List<Long> stateOutputIds = stateOutputs.stream().map(StateOutput::getId).collect(Collectors.toList());
		long simulation_id = simulationInserter.insertSimulation(connectFourSimulation);
		simulationStateInserter.insert(simulation_id, stateOutputIds);
	}

}
