package io.karakaz.connect4simulator;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PlayerModule_ProvidePlayer2Factory implements Factory<Player2> {
  private final PlayerModule module;

  private final Provider<SimulationConfig> simulationConfigProvider;

  public PlayerModule_ProvidePlayer2Factory(
      PlayerModule module, Provider<SimulationConfig> simulationConfigProvider) {
    this.module = module;
    this.simulationConfigProvider = simulationConfigProvider;
  }

  @Override
  public Player2 get() {
    return Preconditions.checkNotNull(
        module.providePlayer2(simulationConfigProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Player2> create(
      PlayerModule module, Provider<SimulationConfig> simulationConfigProvider) {
    return new PlayerModule_ProvidePlayer2Factory(module, simulationConfigProvider);
  }

  public static Player2 proxyProvidePlayer2(
      PlayerModule instance, SimulationConfig simulationConfig) {
    return instance.providePlayer2(simulationConfig);
  }
}
