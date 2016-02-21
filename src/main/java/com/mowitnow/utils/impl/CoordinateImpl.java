package com.mowitnow.utils.impl;

import com.mowitnow.utils.Coordinate;
import com.mowitnow.utils.Orientation;

public class CoordinateImpl implements Coordinate {

	private int x;
	private int y;
	private Orientation orientation;

	public CoordinateImpl(int x, int y, Orientation orientation) {
		this.x = x;
		this.y = y;
		this.orientation = orientation;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	public void rotate90() {
		orientation = orientation.rotate90();
	}

	public void rotate270() {
		orientation = orientation.rotate270();
	}

}
