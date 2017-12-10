package io.karakaz.connect4simulator.init;

import dagger.Component;
import io.karakaz.connect4simulator.game.Game;
import io.karakaz.connect4simulator.game.GameModule;
import io.karakaz.connect4simulator.Simulator;
import io.karakaz.connect4simulator.board.Board;
import io.karakaz.connect4simulator.board.BoardModule;
import io.karakaz.connect4simulator.player.Player1;
import io.karakaz.connect4simulator.player.Player2;
import io.karakaz.connect4simulator.player.PlayerModule;

@Component(modules = {SimulationConfigModule.class, BoardModule.class, PlayerModule.class, GameModule.class})
public interface MainComponent extends GameProvider {

	SimulationConfig provideSimulationConfig();

	Board provideBoard();

	Player1 providePlayer1();

	Player2 providePlayer2();

	Game provideGame();

	Simulator provideSimulator();

}
