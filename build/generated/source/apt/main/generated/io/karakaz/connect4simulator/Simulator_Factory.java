package io.karakaz.connect4simulator;

import dagger.internal.Factory;
import io.karakaz.connect4simulator.db.SimulationInserter;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class Simulator_Factory implements Factory<Simulator> {
  private final Provider<SimulationConfig> simulationConfigProvider;

  private final Provider<SimulationInserter> simulationInserterProvider;

  public Simulator_Factory(
      Provider<SimulationConfig> simulationConfigProvider,
      Provider<SimulationInserter> simulationInserterProvider) {
    this.simulationConfigProvider = simulationConfigProvider;
    this.simulationInserterProvider = simulationInserterProvider;
  }

  @Override
  public Simulator get() {
    return new Simulator(simulationConfigProvider.get(), simulationInserterProvider.get());
  }

  public static Factory<Simulator> create(
      Provider<SimulationConfig> simulationConfigProvider,
      Provider<SimulationInserter> simulationInserterProvider) {
    return new Simulator_Factory(simulationConfigProvider, simulationInserterProvider);
  }

  public static Simulator newSimulator(
      SimulationConfig simulationConfig, SimulationInserter simulationInserter) {
    return new Simulator(simulationConfig, simulationInserter);
  }
}
