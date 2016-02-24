package com.mowitnow.model.impl;

import com.mowitnow.model.Movable;
import com.mowitnow.utils.Coordinate;

public class Mower implements Movable {

	private Coordinate coordinate;

	private String instructions;

	public Mower(Coordinate coordinate, String instructions) {
		this.coordinate = coordinate;
		this.instructions = instructions;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	@Override
	public String toString() {
		return "Mower (" + coordinate.getX() + " " + coordinate.getY() + " " + coordinate.getOrientation() + ")";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mowitnow.model.Movable#rotate90()
	 */
	public void rotate90() {
		coordinate.rotate90();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mowitnow.model.Movable#rotate270()
	 */
	public void rotate270() {
		coordinate.rotate270();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mowitnow.model.Movable#move()
	 */
	public void move() {
		switch (coordinate.getOrientation()) {
		case N:
			coordinate.setY(coordinate.getY() + 1);
			break;
		case E:
			coordinate.setX(coordinate.getX() + 1);
			break;
		case S:
			coordinate.setY(coordinate.getY() - 1);
			break;
		case W:
			coordinate.setX(coordinate.getX() - 1);
			break;
		default:
			break;
		}
	}

}
