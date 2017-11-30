package io.karakaz.connect4simulator;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SimulationConfigModule_ProvideBoardFactory implements Factory<SimulationConfig> {
  private final SimulationConfigModule module;

  public SimulationConfigModule_ProvideBoardFactory(SimulationConfigModule module) {
    this.module = module;
  }

  @Override
  public SimulationConfig get() {
    return Preconditions.checkNotNull(
        module.provideBoard(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<SimulationConfig> create(SimulationConfigModule module) {
    return new SimulationConfigModule_ProvideBoardFactory(module);
  }

  public static SimulationConfig proxyProvideBoard(SimulationConfigModule instance) {
    return instance.provideBoard();
  }
}
