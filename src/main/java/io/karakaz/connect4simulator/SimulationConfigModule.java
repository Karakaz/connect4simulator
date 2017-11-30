package io.karakaz.connect4simulator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Singleton
@Module
public class SimulationConfigModule {

	private final Args args;

	SimulationConfigModule(Args args) {
		this.args = args;
	}

	@Provides
	SimulationConfig provideSimulationConfig() {
		return new SimulationConfig();
	}

}
