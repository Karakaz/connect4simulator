package io.karakaz.connect4simulator;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import io.karakaz.connect4simulator.db.DBPreparedStatement;

public class SimulationStateInserter extends DBPreparedStatement {

	private static final String SQL = "INSERT";

	private long simulation_id;
	private long state_output_id;

	protected SimulationStateInserter() {
		super(SQL);
	}

	public void insert(long simulation_id, List<Long> stateOutputIds) {
		this.simulation_id = simulation_id;
		for (Long stateOutputId : stateOutputIds) {
			this.state_output_id = stateOutputId;
			initiateQuery();
		}
	}

	@Override
	protected long queryDatabase(PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setLong(1, simulation_id);
		preparedStatement.setLong(2, state_output_id);
		preparedStatement.executeQuery();
		return 0;
	}
}
