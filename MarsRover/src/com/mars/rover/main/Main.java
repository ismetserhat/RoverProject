package com.mars.rover.main;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.mars.rover.app.MarsRover;
import com.mars.rover.model.Direction;
/**
 * 
 * @author serhat.ozturk
 *
 */
public class Main {

	private static Logger logger = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) {
		try {
			MarsRover rover = new MarsRover(1, 2, Direction.N.order());
			rover.action("LMLMLMLMM");
			rover.getPosition();
			rover.config(3, 3, Direction.E.order());
			rover.action("MMRMMRMRRM");
			rover.getPosition();

		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage());
		}
	}
}
