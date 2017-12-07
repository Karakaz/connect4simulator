package io.karakaz.connect4simulator.board.state;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import io.karakaz.connect4simulator.board.slot.Disc;

public class StateHistory {

	private final List<State> states;
	private Disc winner;

	public StateHistory() {
		states = new ArrayList<>();
	}

	public void addState(State state) {
		states.add(state);
	}

	public void setWinner(Disc winner) {
		this.winner = winner;
	}

	public State getFinalState() {
		return states.get(states.size() - 1);
	}

	@Override
	public String toString() {
		return states.stream()
			 .map(State::toString)
			 .collect(Collectors.joining(System.lineSeparator()));
	}

	public Disc getWinner() {
		return winner;
	}

	public String toCSV() {
//		states.stream()
//			 .map(State::flatten)
//			 .collect(Collectors.)
		return null;
	}

	public List<State> getStates() {
		return states;
	}
}
