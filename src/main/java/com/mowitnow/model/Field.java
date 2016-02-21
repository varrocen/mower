package com.mowitnow.model;

import com.mowitnow.utils.Coordinate;

public interface Field {

	/**
	 * Test if the next position are not out of the field limits
	 * 
	 * @param coordinate
	 * @return true if next position are valid, false otherwise
	 */
	public boolean isValidNextPosition(Coordinate coordinate);

}
