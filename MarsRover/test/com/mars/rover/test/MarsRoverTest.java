package com.mars.rover.test;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

import com.mars.rover.app.MarsRover;
import com.mars.rover.model.Direction;
import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * 
 * @author serhat.ozturk
 *
 */
public class MarsRoverTest {

	private static Logger logger = Logger
			.getLogger(MarsRoverTest.class.getName());

	@Test
	void test() {
		try {
			MarsRover rover = new MarsRover(1, 2, Direction.N.order());
			rover.action("LMLMLMLMM");
			assertEquals("1 3 N", rover.getPosition());
			rover.config(3, 3, Direction.E.order());
			rover.action("MMRMMRMRRM");
			assertEquals("5 1 E", rover.getPosition());

		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage());
		}
	}
}
