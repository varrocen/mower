package com.mowitnow.model;

import com.mowitnow.utils.Coordinate;

public interface Movable {

	public Coordinate getCoordinate();

	public String getInstructions();

	/**
	 * Rotate 90° clockwise
	 */
	public void rotate90();

	/**
	 * Rotate 270° clockwise (or 90° counterclockwise)
	 */
	public void rotate270();

	/**
	 * Move ahead the movable
	 */
	public void move();

}
