package io.karakaz.connect4simulator;

import javax.inject.Singleton;

import dagger.Component;
import io.karakaz.connect4simulator.board.Board;
import io.karakaz.connect4simulator.board.BoardModule;

@Singleton
@Component(modules = BoardModule.class)
public interface MyComponent {

	Board provideBoard();

}
