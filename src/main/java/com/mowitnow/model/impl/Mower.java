package com.mowitnow.model.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mowitnow.model.Movable;
import com.mowitnow.utils.Coordinate;

public class Mower implements Movable {

	private static final Logger log = LoggerFactory.getLogger(Mower.class);

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
		log.debug("Rotate 90° " + this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mowitnow.model.Movable#rotate270()
	 */
	public void rotate270() {
		coordinate.rotate270();
		log.debug("Rotate 270° " + this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mowitnow.model.Movable#move()
	 */
	public void move() {
		switch (coordinate.getOrientation()) {
		case NORTH:
			coordinate.setY(coordinate.getY() + 1);
			break;
		case EAST:
			coordinate.setX(coordinate.getX() + 1);
			break;
		case SOUTH:
			coordinate.setY(coordinate.getY() - 1);
			break;
		case WEST:
			coordinate.setX(coordinate.getX() - 1);
			break;
		default:
			break;
		}
		log.debug("Move " + this);
	}

}
