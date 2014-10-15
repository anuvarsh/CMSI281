package edu.lmu.cmsi.anu.lamegame.gameobjects;

import edu.lmu.cmsi.anu.lamegame.core.Coordinate;
import edu.lmu.cmsi.anu.lamegame.core.Displacement;

// this class will be used to create wall, tree, and rock

public abstract class GameObjects {
	
	public Coordinate coords;

	public GameObjects(int x, int y) {
		this.coords = new Coordinate(x, y);
	}

	public Coordinate getCoords() {
		return this.coords;
	}

	public abstract char getLabel();

  private Displacement displacement;
  
  public void setDisplacement(int dx, int dy) {
    this.displacement = new Displacement(dx, dy);
  }

  public Displacement getDisplacement() {
    return displacement;
  }

  public void invertDisplacement() {
    this.displacement.invert();
  }

  public void updateCoordinates() {
    this.coords.setX(this.coords.getX() + this.displacement.getXDisplacement());
    this.coords.setY(this.coords.getY() + this.displacement.getYDisplacement());
  }

  private int hitPoints;

  public void updateHitPoints(int hp) {
    this.hitPoints = this.hitPoints + hp;
  }

  public int getHitPoints() {
    return this.hitPoints;
  }

  //rules for all objects:

  public void checkCollision(Wall w) {
    if (this.coords.getX() == w.coords.getX() && this.coords.getY() == w.coords.getY()) {
      this.invertDisplacement();
    }
  }

  public void checkCollision(Rock r) {
    if (this.coords.getX() == r.coords.getX() && this.coords.getY() == r.coords.getY()) {
      this.updateHitPoints(1);
    }
  }

  public void checkCollision(Tree t) {
    if (this.coords.getX() == t.coords.getX() && this.coords.getY() == t.coords.getY()) {
      this.updateHitPoints(1);
    }
  }
}	
