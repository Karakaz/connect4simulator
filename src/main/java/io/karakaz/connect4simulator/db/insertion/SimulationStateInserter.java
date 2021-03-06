package io.karakaz.connect4simulator.db.insertion;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import io.karakaz.connect4simulator.db.DBPreparedStatement;

public class SimulationStateInserter extends DBPreparedStatement<Void> {

	private static final String SQL =
		 "INSERT INTO simulation_state "
		 + "(simulation_id, state_output_id) "
		 + "VALUES (?, ?)";

	private long simulation_id;
	private long state_output_id;

	@Inject
	SimulationStateInserter() {
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
	protected Void queryDatabase(PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setLong(1, simulation_id);
		preparedStatement.setLong(2, state_output_id);
		preparedStatement.executeUpdate();
		return null;
	}
}
