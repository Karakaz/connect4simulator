package io.karakaz.connect4simulator.db.creation;

import java.sql.SQLException;
import java.sql.Statement;

import io.karakaz.connect4simulator.db.DBStatement;

public class SimulationTableCreator extends DBStatement {

	@Override
	protected void queryDatabase(Statement statement) throws SQLException {
		String sql = "CREATE TABLE "
			 + "IF NOT EXISTS simulation ("
			 + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
			 + "player1_id INTEGER NOT NULL, "
			 + "player2_id INTEGER NOT NULL, "
			 + "turns TEXT NOT NULL UNIQUE, "
			 + "winner INTEGER NOT NULL, "
			 + "created TEXT NOT NULL DEFAULT CURRENT_TIMESTAMP)";
		statement.execute(sql);
	}
}
