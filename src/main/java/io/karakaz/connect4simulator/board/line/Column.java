package io.karakaz.connect4simulator.board.line;

import io.karakaz.connect4simulator.board.slot.Disc;

public class Column extends Line{

	private int level = 0;

	public void insertDisc(Disc disc) {
		slots.get(level++).setDisc(disc);
	}
}
