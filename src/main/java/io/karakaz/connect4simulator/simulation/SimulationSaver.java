package io.karakaz.connect4simulator.simulation;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.inject.Inject;

import io.karakaz.connect4simulator.board.state.MirroredState;
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
		for (ConnectFourSimulation simulation : simulations) {
			Optional<Long> simulationId = simulationInserter.insertSimulation(simulation);
			simulationId.ifPresent(id -> saveSimulation(id, simulation));
		}
	}

	private void saveSimulation(Long simulationId, ConnectFourSimulation simulation) {
		List<State> winnerStates = getWinnerStates(simulation);
		saveStates(simulationId, winnerStates);

		Long mirroredId = simulationInserter.insertMirroredSimulation(simulation);
		List<State> winnerStatesMirrored = getWinnerStatesMirrored(winnerStates);
		saveStates(mirroredId, winnerStatesMirrored);
	}

	private List<State> getWinnerStates(ConnectFourSimulation simulation) {
		return simulation.getStateHistory().getStates().stream()
			 .filter(s -> s.getOutputDisc() == simulation.getWinner())
			 .collect(Collectors.toList());
	}

	private List<State> getWinnerStatesMirrored(List<State> winnerStates) {
		return winnerStates.stream()
			 .map(MirroredState::from)
			 .collect(Collectors.toList());
	}

	private void saveStates(Long simulationId, List<State> states) {
		List<Long> stateOutputIds = stateInserter.saveWinnerStates(states);
		simulationStateInserter.insert(simulationId, stateOutputIds);
	}

}
