package io.karakaz.connect4simulator.board;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import io.karakaz.connect4simulator.board.line.Column;
import io.karakaz.connect4simulator.board.line.Line;
import io.karakaz.connect4simulator.board.line.Lines;
import io.karakaz.connect4simulator.board.slot.Disc;
import io.karakaz.connect4simulator.board.slot.Slot;

public class Board {
	public static final int WIDTH = 7;
	public static final int HEIGHT = 6;
	private static final String COLUMN_TOKEN = "|";

	private final List<Lines<? extends Line>> allLines;
	private final Lines<Line> rows;
	private final Lines<Column> columns;

	Board(Lines<Line> rows, Lines<Column> columns, Lines<Line> forwardDiagonals, Lines<Line> backwardDiagonals) {
		allLines = new ArrayList<>(Arrays.asList(rows, columns, forwardDiagonals, backwardDiagonals));
		this.rows = rows;
		this.columns = columns;
	}

	public List<Integer> getAvailableColumns() {
		return columns.getAvailable();
	}

	public void dropDisc(int x, Disc disc) {
		columns.get(x).insertDisc(disc);
	}

	public Optional<Disc> gameOver() {
		return allLines.stream()
			 .map(Lines::gameOver)
			 .filter(Optional::isPresent)
			 .findAny()
		    .orElse(getAvailableColumns().isEmpty() ? Optional.of(Disc.NONE) : Optional.empty());
	}

	public Disc[][] getState(){
		Disc[][] state = new Disc[WIDTH][HEIGHT];
			for (int y = 0; y < HEIGHT; y++) {
				for (int x = 0; x < WIDTH; x++) {
				state[x][y] = rows.get(y).getSlot(x).getDisc();
			}
		}
		return state;
	}

	/** Example: winning moves are marked with: • and Ø
	|*| |*|•| | | |
	|*| |O|*|•| | |
	|O|*|O|O|O|•| |
	|O|O|*|*|*|O|•|
	|*|O|*|O|O|*|O|
	|O|*|O|O|*|O|O|
	 */
	@Override
	public String toString() {
		return "Board:" + System.lineSeparator() +
			 rows.stream().map(r -> r.stream()
						.map(Slot::toString)
						.collect(Collectors.joining(COLUMN_TOKEN)))
				  .map(r -> COLUMN_TOKEN + r + COLUMN_TOKEN)
				  .collect(Collectors.joining(System.lineSeparator()));
	}
}
