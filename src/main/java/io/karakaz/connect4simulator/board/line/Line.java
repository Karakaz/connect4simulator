package io.karakaz.connect4simulator.board.line;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import io.karakaz.connect4simulator.board.slot.Disc;
import io.karakaz.connect4simulator.board.slot.Slot;

public class Line {

	protected final List<Slot> slots;

	public Line() {
		slots = new ArrayList<>();
	}

	public void addSlot(Slot slot) {
		slots.add(slot);
		slot.addLine(this);
	}

	public Optional<Disc> fourInARow() {
		Disc current = Disc.NONE;
		int count = 0;
		for (Slot slot : slots) {
			if (slot.getDisc() == current) {
				count++;
				if (count == 4 && slot.getDisc() != Disc.NONE) {
					return Optional.of(current);
				}
			}
			else {
				current = slot.getDisc();
				count = 1;
			}
		}
		return Optional.empty();
	}

	public boolean isFull() {
		return slots.stream().noneMatch(s -> s.getDisc() == Disc.NONE);
	}

	public Slot getSlot(int index) {
		return slots.get(index);
	}

	public Stream<Slot> stream() {
		return slots.stream();
	}

}
