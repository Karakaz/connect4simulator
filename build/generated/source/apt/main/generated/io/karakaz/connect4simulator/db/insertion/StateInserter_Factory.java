package io.karakaz.connect4simulator.db.insertion;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class StateInserter_Factory implements Factory<StateInserter> {
  private final Provider<StateOutputInserter> stateOutputInserterProvider;

  public StateInserter_Factory(Provider<StateOutputInserter> stateOutputInserterProvider) {
    this.stateOutputInserterProvider = stateOutputInserterProvider;
  }

  @Override
  public StateInserter get() {
    return new StateInserter(stateOutputInserterProvider.get());
  }

  public static Factory<StateInserter> create(
      Provider<StateOutputInserter> stateOutputInserterProvider) {
    return new StateInserter_Factory(stateOutputInserterProvider);
  }

  public static StateInserter newStateInserter(StateOutputInserter stateOutputInserter) {
    return new StateInserter(stateOutputInserter);
  }
}
