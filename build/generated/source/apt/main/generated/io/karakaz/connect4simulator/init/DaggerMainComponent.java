package io.karakaz.connect4simulator.init;

import dagger.internal.Preconditions;
import io.karakaz.connect4simulator.Simulator;
import io.karakaz.connect4simulator.board.Board;
import io.karakaz.connect4simulator.board.BoardModule;
import io.karakaz.connect4simulator.board.BoardModule_ProvideBoardFactory;
import io.karakaz.connect4simulator.db.fetchers.TableStateFetcher_Factory;
import io.karakaz.connect4simulator.db.insertion.SimulationInserter;
import io.karakaz.connect4simulator.db.insertion.SimulationStateInserter_Factory;
import io.karakaz.connect4simulator.db.insertion.StateInserter;
import io.karakaz.connect4simulator.db.insertion.StateInserter_Factory;
import io.karakaz.connect4simulator.db.insertion.StateOutputInserter_Factory;
import io.karakaz.connect4simulator.game.Game;
import io.karakaz.connect4simulator.game.GameModule;
import io.karakaz.connect4simulator.game.GameModule_ProvideGameFactory;
import io.karakaz.connect4simulator.player.Player1;
import io.karakaz.connect4simulator.player.Player2;
import io.karakaz.connect4simulator.player.PlayerModule;
import io.karakaz.connect4simulator.player.PlayerModule_ProvidePlayer1Factory;
import io.karakaz.connect4simulator.player.PlayerModule_ProvidePlayer2Factory;
import io.karakaz.connect4simulator.simulation.SimulationSaver;
import io.karakaz.connect4simulator.simulation.SimulationSaver_Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerMainComponent implements MainComponent {
  private SimulationConfigModule simulationConfigModule;

  private BoardModule boardModule;

  private PlayerModule playerModule;

  private GameModule gameModule;

  private DaggerMainComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  private StateInserter getStateInserter() {
    return StateInserter_Factory.newStateInserter(
        TableStateFetcher_Factory.newTableStateFetcher(),
        StateOutputInserter_Factory.newStateOutputInserter());
  }

  private SimulationSaver getSimulationSaver() {
    return SimulationSaver_Factory.newSimulationSaver(
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
        PlayerModule_ProvidePlayer1Factory.proxyProvidePlayer1(
            playerModule, provideSimulationConfig()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  @Override
  public Player2 providePlayer2() {
    return Preconditions.checkNotNull(
        PlayerModule_ProvidePlayer2Factory.proxyProvidePlayer2(
            playerModule, provideSimulationConfig()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  @Override
  public Game provideGame() {
    return Preconditions.checkNotNull(
        GameModule_ProvideGameFactory.proxyProvideGame(
            gameModule, provideBoard(), providePlayer1(), providePlayer2()),
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

    public MainComponent build() {
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
      return new DaggerMainComponent(this);
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
