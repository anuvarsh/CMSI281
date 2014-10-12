package edu.lmu.cmsi.anu.lamegame.gameobjects;

import edu.lmu.cmsi.anu.lamegame.core.Coordinate;

public class Wall {

  private Coordinate location;

  public Wall(int x, int y) {
    this.location = new Coordinate(x, y);
  }

  public int getX() {
    return this.location.getX();
  }

  public int getY() {
    return this.location.getY();
  }

  public char getRenderedCharacter() {
    return 'w';
  }
}