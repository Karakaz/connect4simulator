package io.karakaz.connect4simulator.db.insertion;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.inject.Inject;

import io.karakaz.connect4simulator.board.state.State;
import io.karakaz.connect4simulator.db.DBPreparedStatement;
import io.karakaz.connect4simulator.db.data.StateOutput;
import io.karakaz.connect4simulator.db.fetchers.TableStateFetcher;

public class StateInserter extends DBPreparedStatement<Map<String, Long>> {

	private static final String SQL = "INSERT OR IGNORE INTO state (state) VALUES (?)";

	private final TableStateFetcher stateFetcher;
	private final StateOutputInserter stateOutputInserter;

	private List<String> statesAsString;

	@Inject
	StateInserter(TableStateFetcher stateFetcher, StateOutputInserter stateOutputInserter) {
		super(SQL);
		this.stateFetcher = stateFetcher;
		this.stateOutputInserter = stateOutputInserter;
	}

	public List<Long> saveWinnerStates(List<State> winnerStates) {
		statesAsString = winnerStates.stream()
			 .map(State::flatten)
			 .collect(Collectors.toList());
		Map<String, Long> stateIds = initiateQuery();

		return winnerStates.stream()
			 .map(s -> insertStateOutput(s, stateIds))
			 .collect(Collectors.toList());
	}

	private long insertStateOutput(State state, Map<String, Long> stateIds) {
		return stateOutputInserter.insertStateOutput(stateIds.get(state.flatten()), state.getOutput());
	}

	@Override
	protected Map<String, Long> queryDatabase(PreparedStatement preparedStatement) throws SQLException {
		for (String state : statesAsString) {
			preparedStatement.setString(1, state);
			preparedStatement.addBatch();
		}
		preparedStatement.executeBatch();
		return stateFetcher.fetchIds(statesAsString);
	}
}
