package io.karakaz.connect4simulator.db.insertion;

import dagger.internal.Factory;
import io.karakaz.connect4simulator.db.fetchers.TableStateFetcher;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class StateInserter_Factory implements Factory<StateInserter> {
  private final Provider<TableStateFetcher> stateFetcherProvider;

  private final Provider<StateOutputInserter> stateOutputInserterProvider;

  public StateInserter_Factory(
      Provider<TableStateFetcher> stateFetcherProvider,
      Provider<StateOutputInserter> stateOutputInserterProvider) {
    this.stateFetcherProvider = stateFetcherProvider;
    this.stateOutputInserterProvider = stateOutputInserterProvider;
  }

  @Override
  public StateInserter get() {
    return new StateInserter(stateFetcherProvider.get(), stateOutputInserterProvider.get());
  }

  public static Factory<StateInserter> create(
      Provider<TableStateFetcher> stateFetcherProvider,
      Provider<StateOutputInserter> stateOutputInserterProvider) {
    return new StateInserter_Factory(stateFetcherProvider, stateOutputInserterProvider);
  }

  public static StateInserter newStateInserter(
      TableStateFetcher stateFetcher, StateOutputInserter stateOutputInserter) {
    return new StateInserter(stateFetcher, stateOutputInserter);
  }
}
