package io.karakaz.connect4simulator.player;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import io.karakaz.connect4simulator.init.SimulationConfig;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PlayerModule_ProvidePlayer1Factory implements Factory<Player1> {
  private final PlayerModule module;

  private final Provider<SimulationConfig> simulationConfigProvider;

  public PlayerModule_ProvidePlayer1Factory(
      PlayerModule module, Provider<SimulationConfig> simulationConfigProvider) {
    this.module = module;
    this.simulationConfigProvider = simulationConfigProvider;
  }

  @Override
  public Player1 get() {
    return Preconditions.checkNotNull(
        module.providePlayer1(simulationConfigProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Player1> create(
      PlayerModule module, Provider<SimulationConfig> simulationConfigProvider) {
    return new PlayerModule_ProvidePlayer1Factory(module, simulationConfigProvider);
  }

  public static Player1 proxyProvidePlayer1(
      PlayerModule instance, SimulationConfig simulationConfig) {
    return instance.providePlayer1(simulationConfig);
  }
}
