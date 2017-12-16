package io.karakaz.connect4simulator.board.state;

import io.karakaz.connect4simulator.board.Board;
import io.karakaz.connect4simulator.board.slot.Disc;

public class MirroredState extends State {

	public static MirroredState from(State state) {
		Disc[][] mirroredState = new Disc[Board.WIDTH][Board.HEIGHT];
		for (int x = 0; x < mirroredState.length; x++) {
				mirroredState[x] = state.getState()[Board.WIDTH - x - 1];
		}
		return new MirroredState(mirroredState, Board.WIDTH - state.getOutput() - 1, state.getOutputDisc());
	}

	private MirroredState(Disc[][] state, int output, Disc outputDisc) {
		super(state, output, outputDisc);
	}

}
