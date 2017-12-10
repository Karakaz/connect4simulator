package io.karakaz.connect4simulator.db.creation;

import java.sql.SQLException;
import java.sql.Statement;

import io.karakaz.connect4simulator.db.DBStatement;

public class SimulationStateTableCreator extends DBStatement {

	@Override
	protected void queryDatabase(Statement statement) throws SQLException {
		String sql = "CREATE TABLE "
			 + "IF NOT EXISTS simulation_state ("
			 + "simulation_id INTEGER, "
			 + "state_output_id INTEGER, "
			 + "PRIMARY KEY (simulation_id, state_output_id))";
		statement.execute(sql);
	}
}
