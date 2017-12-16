package io.karakaz.connect4simulator.db.data;

public class StateOutput {

	private long id;
	private final Long stateId;
	private final int output;

	public StateOutput(Long stateId, int output) {
		this.stateId = stateId;
		this.output = output;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public Long getStateId() {
		return stateId;
	}

	public int getOutput() {
		return output;
	}
}
