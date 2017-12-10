package io.karakaz.connect4simulator.init;

public class SimulationConfig {

	private int maxSimulations;

	SimulationConfig(int maxSimulations) {
		this.maxSimulations = maxSimulations;
	}

	public int getMaxSimulations() {
		return maxSimulations;
	}
}
