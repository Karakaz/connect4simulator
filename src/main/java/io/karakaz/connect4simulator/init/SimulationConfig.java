package io.karakaz.connect4simulator.init;

public class SimulationConfig {

	private int maxSimulations;
	private int sqlBatchSize;

	SimulationConfig(int maxSimulations) {
		this.maxSimulations = maxSimulations;
		sqlBatchSize = 1000;
	}

	public int getMaxSimulations() {
		return maxSimulations;
	}

	public int getSqlBatchSize() {
		return sqlBatchSize;
	}
}
