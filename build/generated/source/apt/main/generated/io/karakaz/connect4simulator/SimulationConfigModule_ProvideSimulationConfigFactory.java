package io.karakaz.connect4simulator;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SimulationConfigModule_ProvideSimulationConfigFactory
    implements Factory<SimulationConfig> {
  private final SimulationConfigModule module;

  public SimulationConfigModule_ProvideSimulationConfigFactory(SimulationConfigModule module) {
    this.module = module;
  }

  @Override
  public SimulationConfig get() {
    return Preconditions.checkNotNull(
        module.provideSimulationConfig(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<SimulationConfig> create(SimulationConfigModule module) {
    return new SimulationConfigModule_ProvideSimulationConfigFactory(module);
  }

  public static SimulationConfig proxyProvideSimulationConfig(SimulationConfigModule instance) {
    return instance.provideSimulationConfig();
  }
}
