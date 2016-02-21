package com.mowitnow.utils;

public interface Coordinate {

	public int getX();

	public void setX(int x);

	public int getY();

	public void setY(int y);

	public Orientation getOrientation();

	public void setOrientation(Orientation orientation);

	public void rotate90();

	public void rotate270();

}
