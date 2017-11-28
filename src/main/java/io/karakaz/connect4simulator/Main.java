package io.karakaz.connect4simulator;

import javax.inject.Inject;

import io.karakaz.connect4simulator.board.Board;
import io.karakaz.connect4simulator.db.DBConnector;
import io.karakaz.connect4simulator.DaggerMyComponent;

public class Main {

	private Main() {
		DBConnector.initialize();
	}

	private void simulate() {
		GameSimulator gameSimulator = new GameSimulator();
		gameSimulator.simulateGames();
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.simulate();
	}
}
