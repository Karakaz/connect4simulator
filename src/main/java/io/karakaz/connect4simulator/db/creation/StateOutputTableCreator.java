package io.karakaz.connect4simulator.db.creation;

import java.sql.SQLException;
import java.sql.Statement;

import io.karakaz.connect4simulator.db.DBStatement;

public class StateOutputTableCreator extends DBStatement {

	@Override
	protected void queryDatabase(Statement statement) throws SQLException {
		String sql = "CREATE TABLE "
			 + "IF NOT EXISTS state_output ("
			 + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
			 + "state_id INTEGER NOT NULL, "
			 + "output INTEGER NOT NULL)";
		statement.execute(sql);

		sql = "CREATE INDEX "
			 + "IF NOT EXISTS state_id_index "
			 + "ON state_output (state_id)";
		statement.execute(sql);
	}
}
