package io.karakaz.connect4simulator.board.state;

import io.karakaz.connect4simulator.board.Board;
import io.karakaz.connect4simulator.board.slot.Disc;

public class State {

	private final Disc[][] state;
	private final String boardAsString;

	private int output;
	private Disc outputDisc;

	protected State(Disc[][] state, int output, Disc outputDisc) {
		this.state = state;
		this.output = output;
		this.outputDisc = outputDisc;
		boardAsString = "";
	}

	public State(Board board) {
		state = board.getState();
		boardAsString = board.toString();
		outputDisc = Disc.NONE;
	}

	public void registerOutput(int output, Disc outputDisc) {
		this.output = output;
		this.outputDisc = outputDisc;
	}

	public Disc[][] getState() {
		return state;
	}

	public int getOutput() {
		return output;
	}

	public Disc getOutputDisc() {
		return outputDisc;
	}

	public String flatten() {
		StringBuilder sb = new StringBuilder();
		for (int y = 0; y < Board.HEIGHT; y++) {
			for (int x = 0; x < Board.WIDTH; x++) {
				sb.append(state[x][y].ordinal());
			}
		}
		return sb.toString();
	}

	@Override
	public String toString() {
		return String.format("%s%n%s: output %d, outputDisc %s%n",
			 boardAsString, getClass().getSimpleName(), output, outputDisc.name());
	}
}
