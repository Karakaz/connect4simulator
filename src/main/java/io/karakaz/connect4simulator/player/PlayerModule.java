package io.karakaz.connect4simulator.player;

import dagger.Module;
import dagger.Provides;
import io.karakaz.connect4simulator.init.SimulationConfig;

@Module
public class PlayerModule {

	@Provides
	Player1 providePlayer1(SimulationConfig simulationConfig) {
		return new Player1(1);
	}

	@Provides
	Player2 providePlayer2(SimulationConfig simulationConfig) {
		return new Player2(1);
	}

}
