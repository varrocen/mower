package com.mowitnow.utils;

public enum Orientation {

	/**
	 * NORTH (N) EAST (E) SOUTH (S) WEST (W)
	 */
	N, E, S, W;

	/**
	 * Rotate 90° clockwise
	 * 
	 * @return new orientation
	 */
	public Orientation rotate90() {
		return values()[(ordinal() + 1) % 4];
	}

	/**
	 * Rotate 270° clockwise (or 90° counterclockwise)
	 * 
	 * @return new orientation
	 */
	public Orientation rotate270() {
		return values()[(ordinal() + 3) % 4];
	}

}
