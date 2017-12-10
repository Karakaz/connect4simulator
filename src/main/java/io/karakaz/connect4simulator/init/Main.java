package io.karakaz.connect4simulator.init;

import java.util.Optional;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

import io.karakaz.connect4simulator.Simulator;
import io.karakaz.connect4simulator.db.DBConnector;

public class Main {

	private Main() {
		DBConnector.initialize();
	}

	private void simulate(Args args) {
		MainComponent mainComponent = io.karakaz.connect4simulator.init.DaggerMainComponent.builder()
			 .simulationConfigModule(new SimulationConfigModule(args))
			 .build();

		Simulator simulator = mainComponent.provideSimulator();
		simulator.simulate(mainComponent);
	}

	public static void main(String[] arguments) {
		parseArguments(arguments)
			 .ifPresent(args -> new Main().simulate(args));
	}

	private static Optional<Args> parseArguments(String[] arguments) {
		Args args = new Args();
		try {
			JCommander.newBuilder()
				 .addObject(args)
				 .build()
				 .parse(arguments);
		} catch (ParameterException e) {
			e.usage();
			return Optional.empty();
		}
		return Optional.of(args);
	}
}
