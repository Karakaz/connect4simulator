package io.karakaz.connect4simulator.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import io.karakaz.connect4simulator.Game;
import io.karakaz.connect4simulator.board.slot.Disc;
import io.karakaz.connect4simulator.board.state.StateHistory;
import io.karakaz.connect4simulator.simulation.ConnectFourSimulation;

public class SimulationInserter extends DBPreparedStatement {

	private static final String SQL = "INSERT";
	private long player1_id;
	private long player2_id;
//	private int winner;
//	private String final_state;
//	private String states_csv;



	public SimulationInserter() {
		super(SQL);
	}

	public void insertSimulation(ConnectFourSimulation connectFourSimulation) {
		player1_id = connectFourSimulation.getPlayer1Id();
		player2_id = connectFourSimulation.getPlayer2Id();
		//		winner = stateHistory.getWinner() == Disc.YELLOW ? 1 : 2;
		//		final_state = stateHistory.getFinalState().flatten();
		//		states_csv = stateHistory.toCSV();
		initiateQuery();
	}

	@Override
	protected void queryDatabase(PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setLong(1, player1_id);
		preparedStatement.setLong(2, player2_id);
//		preparedStatement.set(3, );
//		preparedStatement.set(4, );
//		preparedStatement.set(5, );
	}
}
