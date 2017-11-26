package io.karakaz.connect4simulator;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import io.karakaz.connect4simulator.board.Board;
import io.karakaz.connect4simulator.board.BoardCreator;
import io.karakaz.connect4simulator.board.slot.Disc;
import io.karakaz.connect4simulator.board.state.State;
import io.karakaz.connect4simulator.board.state.StateHistory;

public class Game {

	private static final Random random = new Random();

	private final Board board;
	private final StateHistory stateHistory;

	private boolean yellowsTurn;

	public Game() {
		board = BoardCreator.createBoard();
		stateHistory = new StateHistory();
		yellowsTurn = false;
	}

	public void playTurn() {
		List<Integer> availableMoves = board.getAvailableColumns();
		Disc disc = (yellowsTurn = !yellowsTurn) ? Disc.YELLOW : Disc.RED;
		int position = availableMoves.get(random.nextInt(availableMoves.size()));
		board.dropDisc(position, disc);
		stateHistory.addState(new State(board, position, disc));
	}

	public Optional<Disc> gameOver() {
		Optional<Disc> winner = board.gameOver();
		winner.ifPresent(stateHistory::setWinner);
		return winner;
	}

	public StateHistory getStateHistory() {
		return stateHistory;
	}
}
