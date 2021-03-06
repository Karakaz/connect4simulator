package io.karakaz.connect4simulator.db;

import java.sql.SQLException;
import java.sql.Statement;

public abstract class DBStatement extends DBConnector{

	protected abstract void queryDatabase(Statement statement) throws SQLException;

	public void initiateQuery() {
		try (Statement statement = getConnection().createStatement()) {
			queryDatabase(statement);
		}
		catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
