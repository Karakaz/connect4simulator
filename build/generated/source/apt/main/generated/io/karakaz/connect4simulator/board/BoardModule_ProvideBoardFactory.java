package io.karakaz.connect4simulator.board;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BoardModule_ProvideBoardFactory implements Factory<Board> {
  private final BoardModule module;

  public BoardModule_ProvideBoardFactory(BoardModule module) {
    this.module = module;
  }

  @Override
  public Board get() {
    return Preconditions.checkNotNull(
        module.provideBoard(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Board> create(BoardModule module) {
    return new BoardModule_ProvideBoardFactory(module);
  }

  public static Board proxyProvideBoard(BoardModule instance) {
    return instance.provideBoard();
  }
}
