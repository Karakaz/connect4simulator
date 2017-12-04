package io.karakaz.connect4simulator.db;

import io.karakaz.connect4simulator.db.table.PlayerTableCreator;
import io.karakaz.connect4simulator.db.table.SimulationStateTableCreator;
import io.karakaz.connect4simulator.db.table.SimulationTableCreator;
import io.karakaz.connect4simulator.db.table.StateOutputTableCreator;
import io.karakaz.connect4simulator.db.table.StateTableCreator;

public abstract class DBConnector {

	protected static final String DB_URL = "jdbc:sqlite:connectfour.db";

	public static void initialize() {
		new StateTableCreator().initiateQuery();
		new StateOutputTableCreator().initiateQuery();
		new SimulationTableCreator().initiateQuery();
		new SimulationStateTableCreator().initiateQuery();
		new PlayerTableCreator().initiateQuery();
	}
}
