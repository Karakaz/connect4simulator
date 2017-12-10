package io.karakaz.connect4simulator.init;

import com.beust.jcommander.Parameter;

class Args {

	@Parameter(names = "-max", description = "Maximum number of simulations to create (required)", required = true)
	private Integer maxSimulations;

	public int getMaxSimulations() {
		return maxSimulations;
	}
}
