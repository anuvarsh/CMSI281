package edu.lmu.cmsi.anu.lamegame.gameobjects;

import edu.lmu.cmsi.anu.lamegame.core.Coordinate;
import edu.lmu.cmsi.anu.lamegame.core.Displacement;

public class BossO extends Boss {

  public BossO(int x, int y) {
    super(x, y);
  }

  @Override
  public char getLabel() {
    return 'o';
  }

}