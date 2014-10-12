package edu.lmu.cmsi.anu.lamegame.gameobjects;

import edu.lmu.cmsi.anu.lamegame.core.Coordinate;
import edu.lmu.cmsi.anu.lamegame.core.Displacement;

import edu.lmu.cmsi.anu.lamegame.gameobjects.Wall;

public class Monster {

  private Coordinate location;
  private Displacement displacement;
  private char rendered;

  public Monster(int x, int y, int dx, int dy, char rendered) {
    this.location = new Coordinate(x, y);
    this.displacement = new Displacement(dx, dy);
    this.rendered = rendered;
  }

  public int getX() {
    return this.location.getX();
  }

  public int getY() {
    return this.location.getY();
  }

  public char getRenderedCharacter() {
    return rendered;
  }

  public void update() {
    this.location.setX(this.location.getX() + this.displacement.getXDisplacement());
    this.location.setY(this.location.getY() + this.displacement.getYDisplacement());
  }

  public void checkCollision(Wall w) {
    if (this.getX() == w.getX() && this.getY() == w.getY()) {
      displacement.invert();
    }
  }
  
  public void checkCollision(Rock r) {
    if (this.getX() == r.getX() && this.getY() == r.getY()) {
      displacement.invert();
    }
  }

  public void checkCollision(Tree t) {
    if (this.getX() == t.getX() && this.getY() == t.getY()) {
      displacement.invert();
    }
  } 

  public void checkCollision(Player p) {
    if (this.getX() == p.getX() && this.getY() == p.getY()) {
      displacement.invert();
    }
  }

  public void checkCollision(Boss b) {
    if (this.getX() == b.getX() && this.getY() == b.getY()) {
      displacement.invert();
    }
  }  

  // You need to know about all this if you want to continue down this path
  //public void checkCollision(Player p);
  //public void checkCollision(Boss b);
}