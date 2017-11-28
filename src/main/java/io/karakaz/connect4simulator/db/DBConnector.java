package io.karakaz.connect4simulator.db;

public abstract class DBConnector {

	protected static final String DB_URL = "jdbc:sqlite:connectfour.db";

	public static void initialize() {
		new PlayerTableCreator().initiateQuery();
		new SimulationTableCreator().initiateQuery();
	}
}
