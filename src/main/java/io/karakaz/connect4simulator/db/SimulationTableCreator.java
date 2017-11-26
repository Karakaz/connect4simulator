package io.karakaz.connect4simulator.db;

import java.sql.SQLException;
import java.sql.Statement;

public class SimulationTableCreator extends DBStatement {

	@Override
	protected void queryDatabase(Statement statement) throws SQLException {
		String sql = "CREATE TABLE "
			 + "IF NOT EXISTS simulation ("
			 + "id INTEGER PRIMARY KEY, "
			 + "player1_id INTEGER NOT NULL, "
			 + "player2_id INTEGER NOT NULL, "
			 + "winner INTEGER NOT NULL, "
			 + "states_csv TEXT NOT NULL, "
			 + "created TEXT NOT NULL DEFAULT CURRENT_TIMESTAMP)";
		statement.execute(sql);
	}
}
