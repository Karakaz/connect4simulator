package io.karakaz.connect4simulator.board.state;

import io.karakaz.connect4simulator.board.Board;
import io.karakaz.connect4simulator.board.slot.Disc;

public class State {

	private final Disc[][] state;
	private final int latestPosition;
	private final Disc latestDisc;
	private final String boardAsString;

	protected State(Disc[][] state, int latestPosition, Disc latestDisc) {
		this.state = state;
		this.latestPosition = latestPosition;
		this.latestDisc = latestDisc;
		boardAsString = "";
	}

	public State(Board board, int latestPosition, Disc latestDisc) {
		this.state = board.getState();
		this.latestPosition = latestPosition;
		this.latestDisc = latestDisc;
		this.boardAsString = board.toString();
	}

	public Disc[][] getState() {
		return state;
	}

	public int getLatestPosition() {
		return latestPosition;
	}

	public Disc getLatestDisc() {
		return latestDisc;
	}

	public String flatten() {
		return null;
	}

	@Override
	public String toString() {
		return String.format("%s%n%s: latestPosition %d, latestDisc %s%n",
			 boardAsString, getClass().getSimpleName(), latestPosition, latestDisc.name());
	}
}
