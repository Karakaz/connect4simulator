package io.karakaz.connect4simulator.db.insertion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.inject.Inject;

import io.karakaz.connect4simulator.board.slot.Disc;
import io.karakaz.connect4simulator.db.DBPreparedStatement;
import io.karakaz.connect4simulator.simulation.ConnectFourSimulation;

public class SimulationInserter extends DBPreparedStatement {

	private static final String SQL =
		 "INSERT INTO simulation "
		 + "(player1_id, player2_id, winner) "
		 + "VALUES (?, ?, ?)";

	private long player1_id;
	private long player2_id;
	private int winner;

	@Inject
	public SimulationInserter() {
		super(SQL);
	}

	public long insertSimulation(ConnectFourSimulation connectFourSimulation) {
		player1_id = connectFourSimulation.getPlayer1Id();
		player2_id = connectFourSimulation.getPlayer2Id();
		winner = connectFourSimulation.getWinner() == Disc.YELLOW ? 1 : 2;
		return initiateQuery();
	}

	@Override
	protected long queryDatabase(PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setLong(1, player1_id);
		preparedStatement.setLong(2, player2_id);
		preparedStatement.setInt(3, winner);
		preparedStatement.executeUpdate();
		ResultSet resultSet = preparedStatement.getGeneratedKeys();
		if (resultSet.next()) {
			return resultSet.getLong(1);
		}
		throw new IllegalStateException(String.format(
			 "Unable to insert or retrieve the id. player1_id: %d, player2_id: %d, winner: %d",
			 player1_id, player2_id, winner));
	}
}
