package io.karakaz.connect4simulator.db.insertion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.inject.Inject;

import io.karakaz.connect4simulator.board.state.State;
import io.karakaz.connect4simulator.db.DBPreparedStatement;
import io.karakaz.connect4simulator.db.TableStateFetcher;

public class StateInserter extends DBPreparedStatement {

	private static final String SQL = "INSERT OR IGNORE INTO state (state) VALUES (?)";

	private StateOutputInserter stateOutputInserter;

	private State state;

	@Inject
	StateInserter(StateOutputInserter stateOutputInserter) {
		super(SQL);
		this.stateOutputInserter = stateOutputInserter;
	}

	public long insertState(State state) {
		this.state = state;
		long stateId = initiateQuery();
		return stateOutputInserter.insertStateOutput(stateId, state.getLatestPosition());
	}

	@Override
	protected long queryDatabase(PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setString(1, state.flatten());
		preparedStatement.executeUpdate();
		ResultSet resultSet = preparedStatement.getGeneratedKeys();
		if (resultSet.next()) {
			return resultSet.getLong(1);
		}
		return TableStateFetcher.fetchId(state.flatten());
	}
}
