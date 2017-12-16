package io.karakaz.connect4simulator.db.insertion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.inject.Inject;

import io.karakaz.connect4simulator.db.DBPreparedStatement;

public class StateOutputInserter extends DBPreparedStatement<Long> {

	private static final String SQL = "INSERT INTO state_output (state_id, output) VALUES (?, ?)";
	private long stateId;
	private int output;

	@Inject
	StateOutputInserter() {
		super(SQL);
	}

	long insertStateOutput(long stateId, int output) {
		this.stateId = stateId;
		this.output = output;
		return initiateQuery();
	}

	@Override
	protected Long queryDatabase(PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setLong(1, stateId);
		preparedStatement.setInt(2, output);
		preparedStatement.executeUpdate();
		ResultSet resultSet = preparedStatement.getGeneratedKeys();
		if (resultSet.next()) {
			return resultSet.getLong(1);
		}
		throw new IllegalStateException(String.format(
			 "Unable to insert or retrieve the id. stateId: %d, output: %d",
			 stateId, output));
	}
}
