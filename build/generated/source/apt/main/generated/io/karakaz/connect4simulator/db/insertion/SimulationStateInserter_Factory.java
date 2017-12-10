package io.karakaz.connect4simulator.db.insertion;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SimulationStateInserter_Factory implements Factory<SimulationStateInserter> {
  private static final SimulationStateInserter_Factory INSTANCE =
      new SimulationStateInserter_Factory();

  @Override
  public SimulationStateInserter get() {
    return new SimulationStateInserter();
  }

  public static Factory<SimulationStateInserter> create() {
    return INSTANCE;
  }

  public static SimulationStateInserter newSimulationStateInserter() {
    return new SimulationStateInserter();
  }
}
