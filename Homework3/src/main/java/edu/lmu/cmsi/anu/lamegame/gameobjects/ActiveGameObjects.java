package edu.lmu.cmsi.anu.lamegame.gameobjects;

import edu.lmu.cmsi.anu.lamegame.core.Coordinate;
import edu.lmu.cmsi.anu.lamegame.core.Displacement;

// this class will be used to create player, monsters, and bosses

public class ActiveGameObjects extends GameObjects implements Moveable, Hittable {

  public ActiveGameObjects(int x, int y, char l) {
    super(x, y, l);
  }

// code for implementing Moveable Interface

  private Displacement displacement;
  private int hitPoints;
  
  public void setDisplacement(int dx, int dy) {
    this.displacement = new Displacement(dx, dy);
  }

  public void invertDisplacement() {
    this.displacement.invert();
  }

  public void updateCoordinates() {
    this.coords.setX(this.coords.getX() + this.displacement.getXDisplacement());
    this.coords.setY(this.coords.getY() + this.displacement.getYDisplacement());
  }

// code for implementing Hittable Interface

  public void updateHitPoints(int hp) {
    this.hitPoints = this.hitPoints + hp;
  }

  public int getHitPoints() {
    return this.hitPoints;
  }



}