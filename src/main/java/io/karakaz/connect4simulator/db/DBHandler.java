package io.karakaz.connect4simulator.db;

public class DBHandler {

	public static void initialize() {
		new PlayerTableCreator().initiateQuery();
		new SimulationTableCreator().initiateQuery();
	}
}
