package io.karakaz.connect4simulator.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DBStatement extends DBConnector{

	protected abstract void queryDatabase(Statement statement) throws SQLException;

	public void initiateQuery() {
		try (Connection connection = DriverManager.getConnection(DB_URL);
			  Statement statement = connection.createStatement()) {
			queryDatabase(statement);
		}
		catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
