package io.karakaz.connect4simulator;

import dagger.Module;
import dagger.Provides;
import io.karakaz.connect4simulator.board.Board;

@Module
public class GameModule {

	@Provides
	Game provideGame(Board board, Player1 player1, Player2 player2) {
		return new Game(board, player1, player2);
	}

}
