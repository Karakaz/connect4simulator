package io.karakaz.connect4simulator.board;

import io.karakaz.connect4simulator.board.line.Column;
import io.karakaz.connect4simulator.board.line.Line;
import io.karakaz.connect4simulator.board.line.Lines;
import io.karakaz.connect4simulator.board.slot.Slot;

public class BoardCreator {

	private final Slot[][] slots;

	public static Board createBoard() {
		return new BoardCreator().create();
	}

	private BoardCreator() {
		slots = new Slot[Board.WIDTH][Board.HEIGHT];
		for (int x = 0; x < slots.length; x++) {
			for (int y = 0; y < slots[x].length; y++) {
				slots[x][y] = new Slot();
			}
		}
	}

	private Board create() {
		return new Board(
			 createRows(),
			 createColumns(),
			 createForwardDiagonals(),
			 createBackWardDiagonals());
	}

	private Lines<Line> createRows() {
		Lines<Line> rows = new Lines<>();
		for (int y = Board.HEIGHT - 1; y >= 0; y--) {
			Line row = new Line();
			for (int x = 0; x < Board.WIDTH; x++) {
				row.addSlot(slots[x][y]);
			}
			rows.addLine(row);
		}
		return rows;
	}

	private Lines<Column> createColumns() {
		Lines<Column> columns = new Lines<>();
		for (int x = 0; x < Board.WIDTH; x++) {
			Column column = new Column();
			for (int y = 0; y < Board.HEIGHT; y++) {
				column.addSlot(slots[x][y]);
			}
			columns.addLine(column);
		}
		return columns;
	}

	private Lines<Line> createForwardDiagonals() {
		Lines<Line> forwardDiagonals = new Lines<>();

		for (int offset = 2; offset >= -3; offset--) {
			Line forwardDiagonal = new Line();

			int x = Math.max(0 - offset, 0);
			int y = Math.max(offset, 0);

			while (y < Math.min(Board.HEIGHT + offset + 1, Board.HEIGHT)) {
				forwardDiagonal.addSlot(slots[x++][y++]);
			}
			forwardDiagonals.addLine(forwardDiagonal);
		}
		return forwardDiagonals;
	}

	private Lines<Line> createBackWardDiagonals() {
		Lines<Line> backwardDiagonals = new Lines<>();
		for (int offset = 2; offset >= -3; offset--) {
			Line backwardDiagonal = new Line();

			int x = Math.max(0 - offset, 0);
			int y = Math.min(Board.HEIGHT - offset - 1, Board.HEIGHT - 1);

			while (y >= Math.max(-1 - offset, 0)) {
				backwardDiagonal.addSlot(slots[x++][y--]);
			}
			backwardDiagonals.addLine(backwardDiagonal);
		}
		return backwardDiagonals;
	}

}
