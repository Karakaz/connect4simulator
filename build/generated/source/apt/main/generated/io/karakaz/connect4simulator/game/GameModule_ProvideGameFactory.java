package io.karakaz.connect4simulator.game;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import io.karakaz.connect4simulator.board.Board;
import io.karakaz.connect4simulator.player.Player1;
import io.karakaz.connect4simulator.player.Player2;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GameModule_ProvideGameFactory implements Factory<Game> {
  private final GameModule module;

  private final Provider<Board> boardProvider;

  private final Provider<Player1> player1Provider;

  private final Provider<Player2> player2Provider;

  public GameModule_ProvideGameFactory(
      GameModule module,
      Provider<Board> boardProvider,
      Provider<Player1> player1Provider,
      Provider<Player2> player2Provider) {
    this.module = module;
    this.boardProvider = boardProvider;
    this.player1Provider = player1Provider;
    this.player2Provider = player2Provider;
  }

  @Override
  public Game get() {
    return Preconditions.checkNotNull(
        module.provideGame(boardProvider.get(), player1Provider.get(), player2Provider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Game> create(
      GameModule module,
      Provider<Board> boardProvider,
      Provider<Player1> player1Provider,
      Provider<Player2> player2Provider) {
    return new GameModule_ProvideGameFactory(
        module, boardProvider, player1Provider, player2Provider);
  }

  public static Game proxyProvideGame(
      GameModule instance, Board board, Player1 player1, Player2 player2) {
    return instance.provideGame(board, player1, player2);
  }
}
