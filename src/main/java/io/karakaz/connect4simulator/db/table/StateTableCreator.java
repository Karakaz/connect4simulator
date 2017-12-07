package io.karakaz.connect4simulator.db.table;

import java.sql.SQLException;
import java.sql.Statement;

import io.karakaz.connect4simulator.db.DBStatement;

public class StateTableCreator extends DBStatement {

	@Override
	protected void queryDatabase(Statement statement) throws SQLException {
		String sql = "CREATE TABLE "
			 + "IF NOT EXISTS state ("
			 + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
			 + "state TEXT NOT NULL UNIQUE)";
		statement.execute(sql);

		sql = "CREATE INDEX "
			 + "IF NOT EXISTS state_index "
			 + "ON state (state)";
		statement.execute(sql);
	}
}
