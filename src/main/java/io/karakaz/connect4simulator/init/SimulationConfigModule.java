package io.karakaz.connect4simulator.init;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Singleton
@Module
public class SimulationConfigModule {

	private final Args args;

	public SimulationConfigModule(Args args) {
		this.args = args;
	}

	@Provides
	SimulationConfig provideSimulationConfig() {
		return new SimulationConfig(args.getMaxSimulations());
	}

}
