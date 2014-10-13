package edu.lmu.cmsi.anu.lamegame.gameobjects;

import edu.lmu.cmsi.anu.lamegame.core.Coordinate;
import edu.lmu.cmsi.anu.lamegame.core.Displacement;

// this class will be used to create wall, tree, and rock

public class GameObjects {
	protected Coordinate coords;
	protected char label;

	public GameObjects(int x, int y, char l) {
		this.coords = new Coordinate(x,y);
		this.label = l;
	}

	public char getLabel() {
		return this.label;
	}

	public Coordinate getCoords() {
		return this.coords;
	}
}