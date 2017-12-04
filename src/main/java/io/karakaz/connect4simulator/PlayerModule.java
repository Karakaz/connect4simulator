package io.karakaz.connect4simulator;

import dagger.Module;
import dagger.Provides;

@Module
public class PlayerModule {

	@Provides
	Player1 providePlayer1(SimulationConfig simulationConfig) {
		return new Player1(1000);
	}

	@Provides
	Player2 providePlayer2(SimulationConfig simulationConfig) {
		return new Player2(1000);
	}

}
