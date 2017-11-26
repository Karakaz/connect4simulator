package io.karakaz.connect4simulator.board.slot;

import java.util.ArrayList;
import java.util.List;

import io.karakaz.connect4simulator.board.line.Line;

public class Slot {

	private List<Line> lines;
	private Disc disc;

	public Slot() {
		lines = new ArrayList<>();
		disc = Disc.NONE;
	}

	public void addLine(Line line) {
		lines.add(line);
	}

	public void setDisc(Disc disc) {
		this.disc = disc;
	}

	public Disc getDisc() {
		return disc;
	}

	@Override
	public String toString() {
		boolean fourInARow = lines.stream()
			 .anyMatch(l -> l.fourInARow().isPresent());
		return fourInARow ? disc.getWinningToken() : disc.toString();
	}
}
