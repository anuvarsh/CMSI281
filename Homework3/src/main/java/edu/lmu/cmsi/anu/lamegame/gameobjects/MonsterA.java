package edu.lmu.cmsi.anu.lamegame.gameobjects;

import edu.lmu.cmsi.anu.lamegame.core.Coordinate;
import edu.lmu.cmsi.anu.lamegame.core.Displacement;

public class MonsterA extends Monster {

  public MonsterA(int x, int y) {
    super(x, y);
  }

  @Override
  public char getLabel() {
    return 'a';
  }

}