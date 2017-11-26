package io.karakaz.connect4simulator.board.slot;

public enum Disc {
	NONE(" ", " "),
	YELLOW("*", "•"),
	RED("O", "Ø");

	private final String token;
	private final String winningToken;

	Disc(String token, String winningToken) {
		this.token = token;
		this.winningToken = winningToken;
	}

	@Override
	public String toString() {
		return token;
	}

	public String getWinningToken() {
		return winningToken;
	}
}
