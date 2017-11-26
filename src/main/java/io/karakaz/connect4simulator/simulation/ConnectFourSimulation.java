package io.karakaz.connect4simulator.simulation;

import io.karakaz.connect4simulator.board.state.MirroredState;
import io.karakaz.connect4simulator.board.state.State;
import io.karakaz.connect4simulator.board.state.StateHistory;

public class ConnectFourSimulation {

	private final StateHistory stateHistory;
	private final State finalState;
	private final State finalStateMirrored;

	public ConnectFourSimulation(StateHistory stateHistory) {
		this.stateHistory = stateHistory;
		finalState = stateHistory.getFinalState();
		finalStateMirrored = MirroredState.from(finalState);
	}

}
