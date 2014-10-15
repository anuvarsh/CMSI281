package edu.lmu.cmsi.anu.lamegame.gameobjects;

import edu.lmu.cmsi.anu.lamegame.core.Coordinate;
import edu.lmu.cmsi.anu.lamegame.core.Displacement;

public abstract class Boss extends GameObjects {

  public Boss(int x, int y) {
    super(x, y);
  }

  public char getLabel();

  // boss rules

  public void checkCollision(Player p) {
    if (this.coords.getX() == p.coords.getX() && this.coords.getY() == p.coords.getY()) {
    	if (Math.random() > 0.7) {
    		this.updateHitPoints(1);
    	}
    }
  }
}