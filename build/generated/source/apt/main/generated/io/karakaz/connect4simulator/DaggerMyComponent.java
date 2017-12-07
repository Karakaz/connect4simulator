package io.karakaz.connect4simulator;

import dagger.internal.Preconditions;
import io.karakaz.connect4simulator.board.Board;
import io.karakaz.connect4simulator.board.BoardModule;
import io.karakaz.connect4simulator.board.BoardModule_ProvideBoardFactory;
import io.karakaz.connect4simulator.db.SimulationInserter;
import io.karakaz.connect4simulator.db.SimulationStateInserter_Factory;
import io.karakaz.connect4simulator.db.StateInserter;
import io.karakaz.connect4simulator.db.StateInserter_Factory;
import io.karakaz.connect4simulator.db.StateOutputInserter_Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerMyComponent implements MyComponent {
  private SimulationConfigModule simulationConfigModule;

  private BoardModule boardModule;

  private PlayerModule playerModule;

  private GameModule gameModule;

  private DaggerMyComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  private StateInserter getStateInserter() {
    return StateInserter_Factory.newStateInserter(
        StateOutputInserter_Factory.newStateOutputInserter());
  }

  private SimulationSaver getSimulationSaver() {
    return new SimulationSaver(
        getStateInserter(),
        new SimulationInserter(),
        SimulationStateInserter_Factory.newSimulationStateInserter());
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.simulationConfigModule = builder.simulationConfigModule;
    this.boardModule = builder.boardModule;
    this.playerModule = builder.playerModule;
    this.gameModule = builder.gameModule;
  }

  @Override
  public SimulationConfig provideSimulationConfig() {
    return Preconditions.checkNotNull(
        simulationConfigModule.provideSimulationConfig(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  @Override
  public Board provideBoard() {
    return Preconditions.checkNotNull(
        BoardModule_ProvideBoardFactory.proxyProvideBoard(boardModule),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  @Override
  public Player1 providePlayer1() {
    return Preconditions.checkNotNull(
        playerModule.providePlayer1(provideSimulationConfig()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  @Override
  public Player2 providePlayer2() {
    return Preconditions.checkNotNull(
        playerModule.providePlayer2(provideSimulationConfig()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  @Override
  public Game provideGame() {
    return Preconditions.checkNotNull(
        gameModule.provideGame(provideBoard(), providePlayer1(), providePlayer2()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  @Override
  public Simulator provideSimulator() {
    return new Simulator(provideSimulationConfig(), getSimulationSaver());
  }

  public static final class Builder {
    private SimulationConfigModule simulationConfigModule;

    private BoardModule boardModule;

    private PlayerModule playerModule;

    private GameModule gameModule;

    private Builder() {}

    public MyComponent build() {
      if (simulationConfigModule == null) {
        throw new IllegalStateException(
            SimulationConfigModule.class.getCanonicalName() + " must be set");
      }
      if (boardModule == null) {
        this.boardModule = new BoardModule();
      }
      if (playerModule == null) {
        this.playerModule = new PlayerModule();
      }
      if (gameModule == null) {
        this.gameModule = new GameModule();
      }
      return new DaggerMyComponent(this);
    }

    public Builder simulationConfigModule(SimulationConfigModule simulationConfigModule) {
      this.simulationConfigModule = Preconditions.checkNotNull(simulationConfigModule);
      return this;
    }

    public Builder boardModule(BoardModule boardModule) {
      this.boardModule = Preconditions.checkNotNull(boardModule);
      return this;
    }

    public Builder playerModule(PlayerModule playerModule) {
      this.playerModule = Preconditions.checkNotNull(playerModule);
      return this;
    }

    public Builder gameModule(GameModule gameModule) {
      this.gameModule = Preconditions.checkNotNull(gameModule);
      return this;
    }
  }
}
