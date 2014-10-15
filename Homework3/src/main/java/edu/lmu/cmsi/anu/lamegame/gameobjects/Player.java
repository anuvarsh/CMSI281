package edu.lmu.cmsi.anu.lamegame.gameobjects;

import edu.lmu.cmsi.anu.lamegame.core.Coordinate;
import edu.lmu.cmsi.anu.lamegame.core.Displacement;

public class Player extends GameObjects {

  public Player(int x, int y) {
    super(x, y);
  }

  @Override
  public char getLabel(){
    return 'p';
  }

  //player rules:

  public void checkCollision(MonsterA a) {
    if (this.coords.getX() == a.coords.getX() && this.coords.getY() == a.coords.getY()) {
      if (Math.random() > 0.4) {
        this.updateHitPoints(1);
      }
    }
  }

  public void checkCollision(MonsterS s) {
    if (this.coords.getX() == s.coords.getX() && this.coords.getY() == s.coords.getY()) {
      if (Math.random() > 0.4) {
        this.updateHitPoints(1);
      }
    }
  }

  public void checkCollision(MonsterZ z) {
    if (this.coords.getX() == z.coords.getX() && this.coords.getY() == z.coords.getY()) {
      if (Math.random() > 0.5) {
        this.updateHitPoints(1);
      }
    }
  }

  public void checkCollision(MonsterX x) {
    if (this.getX() == x.getX() && this.getY() == x.getY()) {
      if (Math.random() > 0.5) {
        this.updateHitPoints(1);
      }
    }
  }

  public void checkCollision(BossO o) {
    if (this.getX() == o.getX() && this.getY() == o.getY()) {
      if (Math.random() > 0.3) {
        this.updateHitPoints(1);
      }
    }
  }

  public void checkCollision(BossK k) {
    if (this.getX() == k.getX() && this.getY() == k.getY()) {
      if (Math.random() > 0.3) {
        this.updateHitPoints(1);
      }
    }
  }
}