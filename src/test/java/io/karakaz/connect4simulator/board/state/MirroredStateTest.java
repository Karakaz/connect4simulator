package io.karakaz.connect4simulator.board.state;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.karakaz.connect4simulator.board.Board;
import io.karakaz.connect4simulator.board.slot.Disc;
import io.karakaz.connect4simulator.init.DaggerMainComponent;
import io.karakaz.connect4simulator.init.MainComponent;
import io.karakaz.connect4simulator.init.SimulationConfigModule;

class MirroredStateTest {

	private MainComponent mainComponent;

	@BeforeEach
	void setup() {
		mainComponent = DaggerMainComponent.builder()
			 .simulationConfigModule(new SimulationConfigModule(null))
			 .build();
	}

	@Test
	void fromTestOutput() {
		Board board = mainComponent.provideBoard();
		State state = new State(board);
		state.registerOutput(1, Disc.RED);
		State mirrored = MirroredState.from(state);
		assertEquals(mirrored.getOutput(), 5);
		assertEquals(mirrored.getOutputDisc(), Disc.RED);
	}

	@Test
	void fromTestState() {
		Board board = mainComponent.provideBoard();
		board.dropDisc(2, Disc.YELLOW);
		State state = new State(board);
		State mirrored = MirroredState.from(state);
		assertEquals(Disc.YELLOW, mirrored.getState()[4][Board.HEIGHT - 1]);
	}
}