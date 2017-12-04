package io.karakaz.connect4simulator.db.table;

import java.sql.SQLException;
import java.sql.Statement;

import io.karakaz.connect4simulator.db.DBStatement;

public class PlayerTableCreator extends DBStatement {

	@Override
	protected void queryDatabase(Statement statement) throws SQLException {
		String sql = "CREATE TABLE "
			 + "IF NOT EXISTS player ("
			 + "id INTEGER PRIMARY KEY, "
			 + "type TEXT NOT NULL, "
			 + "name TEXT NOT NULL, "
			 + "created TEXT NOT NULL DEFAULT CURRENT_TIMESTAMP)";
		statement.execute(sql);
	}
}
