package io.karakaz.connect4simulator.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.inject.Inject;

public class StateOutputInserter extends DBPreparedStatement {

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
	protected long queryDatabase(PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setLong(1, stateId);
		preparedStatement.setInt(2, output);
		preparedStatement.executeUpdate();
		ResultSet resultSet = preparedStatement.getGeneratedKeys();
		resultSet.next();
		return resultSet.getInt(1);
	}
}
