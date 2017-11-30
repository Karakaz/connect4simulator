package io.karakaz.connect4simulator;

import dagger.MembersInjector;
import io.karakaz.connect4simulator.board.Board;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GameSimulator_MembersInjector implements MembersInjector<GameSimulator> {
  private final Provider<Board> boardProvider;

  public GameSimulator_MembersInjector(Provider<Board> boardProvider) {
    this.boardProvider = boardProvider;
  }

  public static MembersInjector<GameSimulator> create(Provider<Board> boardProvider) {
    return new GameSimulator_MembersInjector(boardProvider);
  }

  @Override
  public void injectMembers(GameSimulator instance) {
    injectBoard(instance, boardProvider.get());
  }

  public static void injectBoard(GameSimulator instance, Board board) {
    instance.board = board;
  }
}
