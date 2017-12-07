package io.karakaz.connect4simulator;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class Simulator_Factory implements Factory<Simulator> {
  private final Provider<SimulationConfig> simulationConfigProvider;

  private final Provider<SimulationSaver> simulationSaverProvider;

  public Simulator_Factory(
      Provider<SimulationConfig> simulationConfigProvider,
      Provider<SimulationSaver> simulationSaverProvider) {
    this.simulationConfigProvider = simulationConfigProvider;
    this.simulationSaverProvider = simulationSaverProvider;
  }

  @Override
  public Simulator get() {
    return new Simulator(simulationConfigProvider.get(), simulationSaverProvider.get());
  }

  public static Factory<Simulator> create(
      Provider<SimulationConfig> simulationConfigProvider,
      Provider<SimulationSaver> simulationSaverProvider) {
    return new Simulator_Factory(simulationConfigProvider, simulationSaverProvider);
  }

  public static Simulator newSimulator(
      SimulationConfig simulationConfig, SimulationSaver simulationSaver) {
    return new Simulator(simulationConfig, simulationSaver);
  }
}
