package io.karakaz.connect4simulator.db.fetchers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.inject.Inject;

import io.karakaz.connect4simulator.db.DBReturnStatement;

public class TableStateFetcher extends DBReturnStatement<Map<String, Long>> {

	private List<String> states;

	@Inject
	TableStateFetcher(){}

	public Map<String, Long> fetchIds(List<String> states) {
		this.states = states;
		return initiateQuery();
	}

	@Override
	protected Map<String, Long> queryDatabase(Statement statement) throws SQLException {
		String sql = "SELECT id, state FROM state WHERE state IN ("
			 + states.stream()
			 .map(s -> '"' + s + '"')
			 .collect(Collectors.joining(","))
			 + ")";
		return getStates(statement.executeQuery(sql));
	}

	private Map<String, Long> getStates(ResultSet resultSet) throws SQLException {
		Map<String, Long> statesMap = new HashMap<>();
		while (resultSet.next()) {
			statesMap.put(resultSet.getString("state"), resultSet.getLong("id"));
		}
		return statesMap;
	}
}
