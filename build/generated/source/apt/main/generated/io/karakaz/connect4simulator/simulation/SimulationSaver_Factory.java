package io.karakaz.connect4simulator.simulation;

import dagger.internal.Factory;
import io.karakaz.connect4simulator.db.insertion.SimulationInserter;
import io.karakaz.connect4simulator.db.insertion.SimulationStateInserter;
import io.karakaz.connect4simulator.db.insertion.StateInserter;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SimulationSaver_Factory implements Factory<SimulationSaver> {
  private final Provider<StateInserter> stateInserterProvider;

  private final Provider<SimulationInserter> simulationInserterProvider;

  private final Provider<SimulationStateInserter> simulationStateInserterProvider;

  public SimulationSaver_Factory(
      Provider<StateInserter> stateInserterProvider,
      Provider<SimulationInserter> simulationInserterProvider,
      Provider<SimulationStateInserter> simulationStateInserterProvider) {
    this.stateInserterProvider = stateInserterProvider;
    this.simulationInserterProvider = simulationInserterProvider;
    this.simulationStateInserterProvider = simulationStateInserterProvider;
  }

  @Override
  public SimulationSaver get() {
    return new SimulationSaver(
        stateInserterProvider.get(),
        simulationInserterProvider.get(),
        simulationStateInserterProvider.get());
  }

  public static Factory<SimulationSaver> create(
      Provider<StateInserter> stateInserterProvider,
      Provider<SimulationInserter> simulationInserterProvider,
      Provider<SimulationStateInserter> simulationStateInserterProvider) {
    return new SimulationSaver_Factory(
        stateInserterProvider, simulationInserterProvider, simulationStateInserterProvider);
  }

  public static SimulationSaver newSimulationSaver(
      StateInserter stateInserter,
      SimulationInserter simulationInserter,
      SimulationStateInserter simulationStateInserter) {
    return new SimulationSaver(stateInserter, simulationInserter, simulationStateInserter);
  }
}
