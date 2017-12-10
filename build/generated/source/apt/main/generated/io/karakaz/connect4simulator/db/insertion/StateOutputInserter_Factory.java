package io.karakaz.connect4simulator.db.insertion;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class StateOutputInserter_Factory implements Factory<StateOutputInserter> {
  private static final StateOutputInserter_Factory INSTANCE = new StateOutputInserter_Factory();

  @Override
  public StateOutputInserter get() {
    return new StateOutputInserter();
  }

  public static Factory<StateOutputInserter> create() {
    return INSTANCE;
  }

  public static StateOutputInserter newStateOutputInserter() {
    return new StateOutputInserter();
  }
}
