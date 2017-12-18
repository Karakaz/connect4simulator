package io.karakaz.connect4simulator.simulation;

import java.util.function.Function;
import java.util.stream.Collectors;

import io.karakaz.connect4simulator.board.Board;
import io.karakaz.connect4simulator.board.slot.Disc;
import io.karakaz.connect4simulator.board.state.State;
import io.karakaz.connect4simulator.board.state.StateHistory;
import io.karakaz.connect4simulator.game.Game;

public class ConnectFourSimulation {

	private final Game game;

	public ConnectFourSimulation(Game game) {
		this.game = game;
	}

	public long getPlayer1Id() {
		return game.getPlayer1().getId();
	}

	public long getPlayer2Id() {
		return game.getPlayer2().getId();
	}

	public StateHistory getStateHistory() {
		return game.getStateHistory();
	}

	public Disc getWinner() {
		return getStateHistory().getWinner();
	}

	public String getTurns() {
		return getTurns(State::getOutput);
	}

	public String getTurnsMirrored() {
		return getTurns(s -> Board.WIDTH - s.getOutput() - 1);
	}

	private String getTurns(Function<State, Integer> outputFunction) {
		return getStateHistory().getStates().stream()
			 .filter(s -> s.getOutputDisc() != Disc.NONE)
			 .map(outputFunction)
			 .map(o -> Integer.toString(o))
			 .collect(Collectors.joining());
	}
}
