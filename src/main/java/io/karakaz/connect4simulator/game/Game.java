package io.karakaz.connect4simulator.game;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import io.karakaz.connect4simulator.board.Board;
import io.karakaz.connect4simulator.board.slot.Disc;
import io.karakaz.connect4simulator.board.state.State;
import io.karakaz.connect4simulator.board.state.StateHistory;
import io.karakaz.connect4simulator.player.Player1;
import io.karakaz.connect4simulator.player.Player2;

public class Game {

	private static final Random random = new Random();

	private final Board board;
	private final Player1 player1;
	private final Player2 player2;
	private final StateHistory stateHistory;

	private boolean yellowsTurn;

	Game(Board board, Player1 player1, Player2 player2) {
		this.board = board;
		this.player1 = player1;
		this.player2 = player2;
		stateHistory = new StateHistory(board);
		yellowsTurn = false;
	}

	public void playTurn() {
		List<Integer> availableMoves = board.getAvailableColumns();
		Disc disc = (yellowsTurn = !yellowsTurn) ? Disc.YELLOW : Disc.RED;
		int position = availableMoves.get(random.nextInt(availableMoves.size()));
		board.dropDisc(position, disc);
		stateHistory.getLatestState().registerOutput(position, disc);
		stateHistory.addState(new State(board));
	}

	public Optional<Disc> gameOver() {
		Optional<Disc> winner = board.gameOver();
		winner.ifPresent(stateHistory::setWinner);
		return winner;
	}

	public StateHistory getStateHistory() {
		return stateHistory;
	}

	public Player1 getPlayer1() {
		return player1;
	}

	public Player2 getPlayer2() {
		return player2;
	}

}
