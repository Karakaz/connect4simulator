package io.karakaz.connect4simulator.db;

import java.sql.SQLException;
import java.sql.Statement;

public abstract class DBReturnStatement<T> extends DBConnector{

	protected abstract T queryDatabase(Statement statement) throws SQLException;

	public T initiateQuery() {
		try (Statement statement = getConnection().createStatement()) {
			return queryDatabase(statement);
		}
		catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
