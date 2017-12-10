package io.karakaz.connect4simulator.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;

public class TableStateFetcher extends DBPreparedStatement {

	private static final TableStateFetcher INSTANCE = new TableStateFetcher();

	private static final String SQL = "SELECT id FROM state WHERE state = ?";

	private final LoadingCache<String, Long> loadingCache;

	private volatile String state;

	private TableStateFetcher() {
		super(SQL);
		loadingCache = Caffeine.newBuilder().maximumSize(10_000).build(this::getIdFromDB);
	}

	public static long fetchId(String state) {
		return INSTANCE.fetch(state);
	}

	@SuppressWarnings("ConstantConditions")
	private long fetch(String state) {
		return loadingCache.get(state);
	}

	private synchronized long getIdFromDB(String state) {
		this.state = state;
		return initiateQuery();
	}

	@Override
	protected long queryDatabase(PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setString(1, state);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			return resultSet.getLong("id");
		}
		throw new IllegalStateException("State " + state + " not found in the database");
	}
}
