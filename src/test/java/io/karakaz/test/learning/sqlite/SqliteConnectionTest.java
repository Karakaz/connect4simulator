package io.karakaz.test.learning.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SqliteConnectionTest {

	@Test
	void connect() {
		String url = "jdbc:sqlite:test.db";
		try (Connection conn = DriverManager.getConnection(url)) {
			Assertions.assertFalse(conn.isClosed());
		}
		catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
