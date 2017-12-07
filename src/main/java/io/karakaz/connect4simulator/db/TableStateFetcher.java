package io.karakaz.connect4simulator.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class TableStateFetcher extends DBStatement {

	private static final TableStateFetcher INSTANCE = new TableStateFetcher();

	private final Map<String, Long> cache = new HashMap<>();

	private String state;
	private long id;

	public static long fetchId(String state) {
		return INSTANCE.fetch(state);
	}

	private long fetch(String state) {
		return cache.computeIfAbsent(state, this::getIdFromDB);
	}

	private synchronized long getIdFromDB(String state) {
		this.state = state;
		initiateQuery();
		return id;
	}

	@Override
	protected void queryDatabase(Statement statement) throws SQLException {
		String sql = "SELECT id FROM state "
			 + "WHERE state = '" + state + "'";
		ResultSet resultSet = statement.executeQuery(sql);
		if (resultSet.next()) {
			id = resultSet.getLong("id");
		}
	}
}
