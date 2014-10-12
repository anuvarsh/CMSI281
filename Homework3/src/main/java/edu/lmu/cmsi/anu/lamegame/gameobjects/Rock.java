package edu.lmu.cmsi.anu.lamegame.gameobjects;

import edu.lmu.cmsi.anu.lamegame.core.Coordinate;
import edu.lmu.cmsi.anu.lamegame.core.Displacement;

import edu.lmu.cmsi.anu.lamegame.gameobjects.Wall;

public class Rock {

  private Coordinate location;
  private Displacement displacement;

  public Rock(int x, int y) {
    this.location = new Coordinate(x, y);
  }

  public int getX() {
    return this.location.getX();
  }

  public int getY() {
    return this.location.getY();
  }

  public char getRenderedCharacter() {
    return 'r';
  }

  public void checkCollision(Wall w) {
    if (this.getX() == w.getX() && this.getY() == w.getY()) {
      displacement.invert();
    }
  }

  public void checkCollision(Player p) {
    if (this.getX() == p.getX() && this.getY() == p.getY()) {
      displacement.invert();
    }
  }

    public void checkCollision(Monster m) {
    if (this.getX() == m.getX() && this.getY() == m.getY()) {
      displacement.invert();
    }
  }

  

  // You need to know about all this if you want to continue down this path
  //public void checkCollision(Player p);
  //public void checkCollision(Boss b);
}