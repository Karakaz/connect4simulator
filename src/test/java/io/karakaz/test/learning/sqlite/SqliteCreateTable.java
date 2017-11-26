package io.karakaz.test.learning.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SqliteCreateTable {

	@Test
	void createNewTable() throws SQLException {
		String url = "jdbc:sqlite:test.db";
		String sql = "CREATE TABLE IF NOT EXISTS user ("
			 + "id integer PRIMARY KEY, "
			 + "name text NOT NULL, "
			 + "sex real"
			 + "created text DEFAULT CURRENT_TIMESTAMP)";

		try (Connection connection = DriverManager.getConnection(url);
			  Statement statement = connection.createStatement()) {
			Assertions.assertFalse(statement.execute(sql));
		}
	}
}
