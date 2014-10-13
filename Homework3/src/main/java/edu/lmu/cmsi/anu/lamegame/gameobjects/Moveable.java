package edu.lmu.cmsi.anu.lamegame.gameobjects;

public interface Moveable {
	public void setDisplacement(int dx, int dy);
	public void invertDisplacement();
	public void updateCoordinates();
}