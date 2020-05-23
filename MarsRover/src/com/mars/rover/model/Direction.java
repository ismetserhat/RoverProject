package com.mars.rover.model;

/**
 * This enum defined directions such as north east west south.
 * 
 * @author serhat.ozturk
 *
 */
public enum Direction {

	N(1, 'N'), E(2, 'E'), S(3, 'S'), W(4, 'W');

	private int order;

	private Character value;

	private Direction(int order, Character value) {
		this.order = order;
		this.value = value;
	}

	public int order() {
		return order;
	}

	public Character value() {
		return value;
	}
}
