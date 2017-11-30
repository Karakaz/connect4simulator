package io.karakaz.connect4simulator;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GameSimulator_Factory implements Factory<GameSimulator> {
  private final Provider<Game> gameProvider;

  public GameSimulator_Factory(Provider<Game> gameProvider) {
    this.gameProvider = gameProvider;
  }

  @Override
  public GameSimulator get() {
    return new GameSimulator(gameProvider.get());
  }

  public static Factory<GameSimulator> create(Provider<Game> gameProvider) {
    return new GameSimulator_Factory(gameProvider);
  }

  public static GameSimulator newGameSimulator(Game game) {
    return new GameSimulator(game);
  }
}
