package io.karakaz.connect4simulator.board.line;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import io.karakaz.connect4simulator.board.slot.Disc;

public class Lines<L extends Line> {

	private List<L> lines;

	public Lines() {
		lines = new ArrayList<>();
	}

	public void addLine(L line) {
		lines.add(line);
	}

	public L get(int index) {
		return lines.get(index);
	}

	public Optional<Disc> gameOver() {
		return lines.stream()
			 .map(Line::fourInARow)
			 .filter(Optional::isPresent)
			 .findAny()
			 .orElse(Optional.empty());
	}

	public List<Integer> getAvailable() {
		return IntStream.range(0, lines.size())
			 .filter(i -> !lines.get(i).isFull())
			 .boxed()
			 .collect(Collectors.toList());
	}

	public Stream<L> stream() {
		return lines.stream();
	}
}
