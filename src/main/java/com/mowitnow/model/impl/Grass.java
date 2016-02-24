package com.mowitnow.model.impl;

import com.mowitnow.model.Field;
import com.mowitnow.utils.Coordinate;

public class Grass implements Field {

	private int width;
	private int height;

	public Grass(int width, int height) {
		if (width < 0 || height < 0) {
			throw new IllegalArgumentException("Width and height can not be negative");
		}

		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	@Override
	public String toString() {
		return "Grass (" + width + " " + height + ")";
	}

	/**
	 * Test if the coordinates are not out of the field limits
	 * 
	 * @param coordinate
	 * @return true if coordinates are valid, false otherwise
	 */
	private boolean isValidCoordinate(Coordinate coordinate) {
		boolean isValideCoordinate = false;

		if (coordinate != null) {
			if (coordinate.getX() >= 0 && coordinate.getX() <= width && coordinate.getY() >= 0
					&& coordinate.getY() <= height) {
				isValideCoordinate = true;
			}
		}
		return isValideCoordinate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mowitnow.model.Field#isValidNextPosition(com.mowitnow.utils.
	 * Coordinate)
	 */
	public boolean isValidNextPosition(Coordinate coordinate) {
		boolean isValidNextPosition = false;

		if (isValidCoordinate(coordinate)) {
			switch (coordinate.getOrientation()) {
			case N:
				if (coordinate.getY() + 1 <= height) {
					isValidNextPosition = true;
				}
				break;
			case E:
				if (coordinate.getX() + 1 <= width) {
					isValidNextPosition = true;
				}
				break;
			case S:
				if (coordinate.getY() - 1 >= 0) {
					isValidNextPosition = true;
				}
				break;
			case W:
				if (coordinate.getX() - 1 >= 0) {
					isValidNextPosition = true;
				}
				break;
			default:
				break;
			}
		}
		return isValidNextPosition;
	}

}
