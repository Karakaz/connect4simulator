package io.karakaz.connect4simulator.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import io.karakaz.connect4simulator.board.slot.Disc;
import io.karakaz.connect4simulator.board.state.StateHistory;

public class SimulationInserter extends DBPreparedStatement {

	private static final String SQL = "INSERT";
	private final int player1_id;
	private final int player2_id;
	private final int winner;
	private final String final_state;
	private final String states_csv;



	public SimulationInserter(StateHistory stateHistory) {
		super(SQL);
		player1_id = 1;
		player2_id = 1;
		winner = stateHistory.getWinner() == Disc.YELLOW ? 1 : 2;
		final_state = stateHistory.getFinalState().flatten();
		states_csv = stateHistory.toCSV();
	}

	@Override
	protected void queryDatabase(PreparedStatement preparedStatement) throws SQLException {
//		preparedStatement.set(1, );
//		preparedStatement.set(2, );
//		preparedStatement.set(3, );
//		preparedStatement.set(4, );
//		preparedStatement.set(5, );
	}

}
