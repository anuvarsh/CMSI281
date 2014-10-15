package edu.lmu.cmsi.anu.lamegame.gameobjects;

import edu.lmu.cmsi.anu.lamegame.core.Coordinate;
import edu.lmu.cmsi.anu.lamegame.core.Displacement;

public abstract class Monster extends GameObjects {

  public Monster(int x, int y) {
    super(x, y);
  }

  public abstract char getLabel();

  // monster rules

  public void checkCollision(Player p) {
    if (this.coords.getX() == p.coords.getX() && this.coords.getY() == p.coords.getY()) {
    	if (Math.random() > 0.5) {
    		this.updateHitPoints(1);
    	}
    }
  }
}