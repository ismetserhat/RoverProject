package com.mars.rover.model;

/**
 * This enum defined Mars Rover movements.
 * 
 * @author serhat.ozturk
 *
 */
public enum Action {
	LEFT('L'), RIGHT('R'), MOVE('M');

	private Character command;

	private Action(Character command) {
		this.command = command;
	}

	public Character command() {
		return command;
	}

}
