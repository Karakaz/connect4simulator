package io.karakaz.connect4simulator;

import io.karakaz.connect4simulator.board.state.StateHistory;
import io.karakaz.connect4simulator.db.DBHandler;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		DBHandler.initialize();

		Game connectFour = new Game();

		while (!connectFour.gameOver().isPresent()) {
			connectFour.playTurn();
		}

		StateHistory stateHistory = connectFour.getStateHistory();
		System.out.println(stateHistory);
	}

}
