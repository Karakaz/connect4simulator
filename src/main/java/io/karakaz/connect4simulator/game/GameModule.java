package io.karakaz.connect4simulator.game;

import dagger.Module;
import dagger.Provides;
import io.karakaz.connect4simulator.board.Board;
import io.karakaz.connect4simulator.player.Player1;
import io.karakaz.connect4simulator.player.Player2;

@Module
public class GameModule {

	@Provides
	Game provideGame(Board board, Player1 player1, Player2 player2) {
		return new Game(board, player1, player2);
	}

}
