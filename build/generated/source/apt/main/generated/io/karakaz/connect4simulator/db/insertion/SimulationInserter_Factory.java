package io.karakaz.connect4simulator.db.insertion;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SimulationInserter_Factory implements Factory<SimulationInserter> {
  private static final SimulationInserter_Factory INSTANCE = new SimulationInserter_Factory();

  @Override
  public SimulationInserter get() {
    return new SimulationInserter();
  }

  public static Factory<SimulationInserter> create() {
    return INSTANCE;
  }
}
