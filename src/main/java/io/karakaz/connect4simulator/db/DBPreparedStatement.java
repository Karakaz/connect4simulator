package io.karakaz.connect4simulator.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DBPreparedStatement extends DBConnector {

	private final String preparedSql;

	protected DBPreparedStatement(String preparedSql) {
		this.preparedSql = preparedSql;
	}

	protected abstract long queryDatabase(PreparedStatement preparedStatement) throws SQLException;

	public long initiateQuery() {
		try (Connection connection = DriverManager.getConnection(DB_URL);
			  PreparedStatement preparedStatement = connection.prepareStatement(preparedSql, Statement.RETURN_GENERATED_KEYS)) {
			return queryDatabase(preparedStatement);
		}
		catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
