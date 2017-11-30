package io.karakaz.connect4simulator;

import dagger.Component;
import io.karakaz.connect4simulator.board.Board;
import io.karakaz.connect4simulator.board.BoardModule;

@Component(modules = {SimulationConfigModule.class, BoardModule.class, PlayerModule.class, GameModule.class})
public interface MyComponent extends GameProvider {

	SimulationConfig provideSimulationConfig();

	Board provideBoard();

	Player1 providePlayer1();

	Player2 providePlayer2();

	Game provideGame();

	Simulator provideSimulator();

}
