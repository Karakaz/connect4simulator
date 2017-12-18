package io.karakaz.connect4simulator.db.insertion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.inject.Inject;

import io.karakaz.connect4simulator.board.slot.Disc;
import io.karakaz.connect4simulator.board.state.State;
import io.karakaz.connect4simulator.db.DBPreparedStatement;
import io.karakaz.connect4simulator.simulation.ConnectFourSimulation;

public class SimulationInserter extends DBPreparedStatement<Optional<Long>> {

	private static final String SQL =
		 "INSERT OR IGNORE INTO simulation "
		 + "(player1_id, player2_id, turns, winner) "
		 + "VALUES (?, ?, ?, ?)";

	private long player1_id;
	private long player2_id;
	private String turns;
	private int winner;

	@Inject
	public SimulationInserter() {
		super(SQL);
	}

	public Optional<Long> insertSimulation(ConnectFourSimulation simulation) {
		return insertSimulation(simulation, ConnectFourSimulation::getTurns);
	}

	public Long insertMirroredSimulation(ConnectFourSimulation simulation) {
		return insertSimulation(simulation, ConnectFourSimulation::getTurnsMirrored).get();
	}

	private Optional<Long> insertSimulation(ConnectFourSimulation simulation, Function<ConnectFourSimulation, String> turnsFunction) {
		player1_id = simulation.getPlayer1Id();
		player2_id = simulation.getPlayer2Id();
		turns = turnsFunction.apply(simulation);
		winner = simulation.getWinner() == Disc.YELLOW ? 1 : 2;
		return initiateQuery();
	}

	@Override
	protected Optional<Long> queryDatabase(PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setLong(1, player1_id);
		preparedStatement.setLong(2, player2_id);
		preparedStatement.setString(3, turns);
		preparedStatement.setInt(4, winner);
		preparedStatement.executeUpdate();
		ResultSet resultSet = preparedStatement.getGeneratedKeys();
		if (resultSet.next()) {
			long id = resultSet.getLong(1);
			if (id > 0) {
				return Optional.of(id);
			}
		}
		return Optional.empty();
	}
}
