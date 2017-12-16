package io.karakaz.connect4simulator.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import io.karakaz.connect4simulator.db.creation.PlayerTableCreator;
import io.karakaz.connect4simulator.db.creation.SimulationStateTableCreator;
import io.karakaz.connect4simulator.db.creation.SimulationTableCreator;
import io.karakaz.connect4simulator.db.creation.StateOutputTableCreator;
import io.karakaz.connect4simulator.db.creation.StateTableCreator;

public abstract class DBConnector {

	private static final String DB_URL = "jdbc:sqlite:connectfour.db";

	private static final Connection connection;

	static {
		try {
			connection = DriverManager.getConnection(DB_URL);
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static void initialize() {
		new StateTableCreator().initiateQuery();
		new StateOutputTableCreator().initiateQuery();
		new SimulationTableCreator().initiateQuery();
		new SimulationStateTableCreator().initiateQuery();
		new PlayerTableCreator().initiateQuery();
	}

	protected static Connection getConnection() {
		return connection;
	}
}
