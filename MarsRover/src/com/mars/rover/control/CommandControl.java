package com.mars.rover.control;

import java.util.regex.Pattern;
/**
 * This class checks the suitability of the commands.
 * 
 * @author serhat.ozturk
 *
 */
public class CommandControl {

	private static final String REGEX = "[LMR]+(?![\\w,])";

	public static boolean isValid(final String value) {
		return Pattern.compile(REGEX).matcher(value).matches();
	}
}
