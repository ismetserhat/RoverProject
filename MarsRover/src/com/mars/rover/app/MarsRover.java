package com.mars.rover.app;
import java.util.Objects;
import java.util.logging.Logger;
import com.mars.rover.control.CommandControl;
import com.mars.rover.model.Action;
import com.mars.rover.model.Direction;
/**
 * This class aims to control for Mars Rover.
 * 
 * @author serhat.ozturk
 *
 */

public class MarsRover {

	private static Logger logger = Logger.getLogger(MarsRover.class.getName());

	private int x;
	private int y;
	private Integer direction;

	public MarsRover(int x, int y, Integer direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public void config(int x, int y, Integer direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public String getPosition() {
		char value = Direction.N.value();
		if (null != direction) {
			switch (direction) {
				case 1 :
					value = Direction.N.value();
					break;
				case 2 :
					value = Direction.E.value();
					break;
				case 3 :
					value = Direction.S.value();
					break;
				case 4 :
					value = Direction.W.value();
					break;
				default :
					break;
			}
		}
		StringBuilder result = new StringBuilder();
		result.append(x).append(" ").append(y).append(" ").append(value);
		logger.info(result.toString());
		return result.toString();
	}

	/**
	 * 
	 * @param commands
	 * @throws IllegalArgumentException if the command is not correct.
	 * 
	 */
	public void action(String commands) throws IllegalArgumentException {
		if (!CommandControl.isValid(commands)) {
			throw new IllegalArgumentException(
					new StringBuilder().append("Unknown pattern commands ' ")
							.append(commands).append(" '").toString());
		}

		for (int idx = 0; idx < commands.length(); idx++) {
			action(commands.charAt(idx));
		}
	}

	private void action(Character command) {
		if (Action.LEFT.command().equals(command)) {
			turnLeft();
		} else if (Action.RIGHT.command().equals(command)) {
			turnRight();
		} else if (Action.MOVE.command().equals(command)) {
			move();
		} else {
			throw new IllegalArgumentException(
					new StringBuilder().append("Unknown pattern character ' ")
							.append(command).append(" '").toString());
		}
	}

	private void move() {
		if (Objects.equals(direction, Direction.N.order()) && this.y <= y) {
			y++;
		} else if (Objects.equals(direction, Direction.E.order())
				&& this.x <= x) {
			x++;
		} else if (Objects.equals(direction, Direction.S.order())
				&& this.y <= y) {
			y--;
		} else if (Objects.equals(direction, Direction.W.order())
				&& this.x <= x) {
			x--;
		}
	}

	private void turnLeft() {
		direction = (direction - 1) < Direction.N.order()
				? Direction.W.order()
				: direction - 1;
	}

	private void turnRight() {
		direction = (direction + 1) > Direction.W.order()
				? Direction.N.order()
				: direction + 1;
	}

}