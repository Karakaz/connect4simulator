package io.karakaz.connect4simulator;

import javax.inject.Inject;

import io.karakaz.connect4simulator.db.DBConnector;
import io.karakaz.connect4simulator.DaggerMyComponent;

public class Main {

	private Main() {
		DBConnector.initialize();
	}

	private void simulate() {
		GameSimulator gameSimulator = new GameSimulator();
		DaggerMyComponent.create().inject(gameSimulator);
		gameSimulator.simulateGames(null);
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.simulate();
	}
}
