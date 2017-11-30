package io.karakaz.connect4simulator;

import io.karakaz.connect4simulator.db.DBConnector;

public class Main {

	private Main() {
		DBConnector.initialize();
	}

	private void simulate(Args args) {
		MyComponent myComponent = io.karakaz.connect4simulator.DaggerMyComponent.builder()
			 .simulationConfigModule(new SimulationConfigModule(args))
			 .build();

		Simulator simulator = myComponent.provideSimulator();
		simulator.simulate(myComponent);
	}

	public static void main(String[] args) {
		Main main = new Main();
		Args a = new Args(args);
		main.simulate(a);
	}
}
