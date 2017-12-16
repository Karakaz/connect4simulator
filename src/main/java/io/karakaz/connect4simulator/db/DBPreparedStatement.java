package io.karakaz.connect4simulator.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DBPreparedStatement<T> extends DBConnector {

	private final String preparedSql;

	protected DBPreparedStatement(String preparedSql) {
		this.preparedSql = preparedSql;
	}

	protected abstract T queryDatabase(PreparedStatement preparedStatement) throws SQLException;

	public T initiateQuery() {
		try (PreparedStatement preparedStatement = getConnection()
			 .prepareStatement(preparedSql, Statement.RETURN_GENERATED_KEYS)) {
			return queryDatabase(preparedStatement);
		}
		catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
