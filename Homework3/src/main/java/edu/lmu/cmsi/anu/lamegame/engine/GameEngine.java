package edu.lmu.cmsi.anu.lamegame.engine;

import edu.lmu.cmsi.anu.lamegame.gameobjects.ActiveGameObjects;
import edu.lmu.cmsi.anu.lamegame.gameobjects.GameObjects;
import java.util.*;

public class GameEngine {

  private int frame;
  private int size;

  // Game Objects
  private ActiveGameObjects[] active;
  private GameObjects[] stationary;
  private GameObjects[] walls;

  public GameEngine(int size) {
    if (size < 20) {
      throw new IllegalArgumentException("This game recommends a size of at least 20.");
    }

    this.frame = 0;
    this.size = size;
  }

  public void initiate() {
    this.createWalls();

    active = new ActiveGameObjects[7]; 
    // player
    active[0] = new ActiveGameObjects(3, 4, 'p');
    active[0].setDisplacement(0, 1);
    // monsters
    active[1] = new ActiveGameObjects(4, 3, 'z');
    active[1].setDisplacement(1, 0);
    active[2] = new ActiveGameObjects(10, 12, 'x');
    active[2].setDisplacement(1, 1);
    active[3] = new ActiveGameObjects(8, 17, 'a');
    active[3].setDisplacement(-1, 0);
    active[4] = new ActiveGameObjects(5, 6, 's');
    active[4].setDisplacement(0, -1);
    // bosses
    active[5] = new ActiveGameObjects(9, 4, 'o');
    active[5].setDisplacement(1,-1);
    active[6] = new ActiveGameObjects(11, 7, 'k');
    active[6].setDisplacement(0, 1);

    stationary = new GameObjects[2]; 
    // rock
    stationary[0] = new GameObjects(5, 5, 'r');
    // tree 
    stationary[1] = new GameObjects(8, 2, 't');
  }

  private void createWalls() {
    // Let's create walls
    //for now, we only care about putting walls on the edges

    int wallCount = 0;
    // calculate the amount of walls we'll need
    walls = new GameObjects[this.size * 4 - 4];

    for (int x = 0; x < this.size; x++) {
      GameObjects x1 = new GameObjects(x, 0, 'w');
      walls[wallCount++] = x1;
      GameObjects x2 = new GameObjects(x, this.size - 1, 'w');
      walls[wallCount++] = x2;
    }

    for (int y = 1; y < size - 1; y++) {
      GameObjects y1 = new GameObjects(0, y, 'w');
      walls[wallCount++] = y1;
      GameObjects y2 = new GameObjects(this.size - 1, y, 'w');
      walls[wallCount++] = y2;
    }
  }

  // the main upadte loop
  public void update() {
    this.frame++;
    this.render();
    this.updateObjects();
    this.checkCollisions();
  }

  private void render() {
    // Strings are a bit overkill here but easier to represent a String as a null than a character
    String[][] renderedWorld = new String[this.size][this.size];

    //walls
    for (int i = 0; i < this.walls.length; i++) {
      GameObjects w = this.walls[i];
      renderedWorld[w.getCoords().getY()][w.getCoords().getX()] = Character.toString(w.getLabel());
    }

    // stationary objects (rock, tree)
    for (int i = 0; i < this.stationary.length; i++) {
      GameObjects s = this.stationary[i];
      renderedWorld[s.getCoords().getY()][s.getCoords().getX()] = Character.toString(s.getLabel());
    }

    // active objects (player, monsters, bosses)
    for (int i = 0; i < this.active.length; i++) {
      ActiveGameObjects a = this.active[i];
      renderedWorld[a.getCoords().getY()][a.getCoords().getX()] = Character.toString(a.getLabel());
    }


    System.out.println("=========================");
    System.out.println("Frame: " + this.frame);  // book keeping

    for (int row = 0; row < renderedWorld.length; row++) {
      String[] rowOfWorld = renderedWorld[row];
      for (int col = 0; col < rowOfWorld.length; col++) {
        String w = rowOfWorld[col];
        // If our string is null
        if (w == null) {
          w = ".";
        }
        System.out.print(w + " ");
      }
      System.out.println(""); // print a new line between each scene
    }

    for (int i = 0; i < active.length; i++) {
      System.out.print(active[i].getLabel() + ":" + active[i].getHitPoints() + " ");
    }
    System.out.println("");

    System.out.println("=========================");
  }

  private void updateObjects() {
    // everytime we add a new game object, we've got to go back through
    // every other place and add in more code - such duplication
    for (int i = 0; i < this.active.length; i++) {
      this.active[i].updateCoordinates();
    }
  }

  private void checkCollisions() {
    for (int i = 0; i < this.active.length; i++) {
      int ax = active[i].getCoords().getX();
      int ay = active[i].getCoords().getY();
      for (int j = 0; j < this.walls.length; j++) {
        int wx = walls[j].getCoords().getX();
        int wy = walls[j].getCoords().getY();
        if (ax == wx && ay == wy) {
          this.handleCollision(active[i], walls[j]);
        }
      }
      for (int x = 0; x < this.stationary.length; x++) {
        int sx = stationary[x].getCoords().getX();
        int sy = stationary[x].getCoords().getY();
        if (ax == sx && ay == sy) {
          this.handleCollision(active[i], stationary[x]);
        }
      }
    }
    for (int z = 0; z < this.active.length; z++) {
      int ax = active[z].getCoords().getX();
      int ay = active[z].getCoords().getY();
      for (int y = z+1; y < this.active.length; y++) {
        int a2x = active[y].getCoords().getX();
        int a2y = active[y].getCoords().getY();
        if (ax == a2x && ay == a2y) {
          this.handleCollision(active[y], active[z]);
        }
      }
    }
  }

  private void handleCollision(GameObjects o1, GameObjects o2) {
    this.pEncounterAorS(o1, o2);
    this.pEncounterZorX(o1, o2);
    this.pEncounterOorK(o1, o2);
    this.encounterWall(o1, o2);
    this.encounterTorR(o1, o2);
  }

  private void pEncounterAorS(GameObjects o1, GameObjects o2) {
    char o1L = o1.getLabel();
    char o2L = o2.getLabel();

    boolean rule2 = false;
    if (o1L == 'p' && o2L == 'a') {
      rule2 = true;
    }
    if (o1L == 'a' && o2L == 'p') {
      rule2 = true;
      GameObjects t = o1;
      o1 = o2;
      o2 = t;
    }
    if (o1L == 'p' && o2L == 's') {
      rule2 = true;
    }
    if (o1L == 's' && o2L == 'p') {
      rule2 = true;
      GameObjects t = o1;
      o1 = o2;
      o2 = t;
    }
    if (rule2) {
      if (Math.random() > 0.4) {
        ((ActiveGameObjects)o1).updateHitPoints(1);
      }
      if (Math.random() > 0.5) {
        ((ActiveGameObjects)o2).updateHitPoints(1);
      }
    }
  }

  private void pEncounterZorX(GameObjects o1, GameObjects o2) {
    char o1L = o1.getLabel();
    char o2L = o2.getLabel();

    boolean rule3 = false;
    if (o1L == 'p' && o2L == 'z') {
      rule3 = true;
    }
    if (o1L == 'z' && o2L == 'p') {
      rule3 = true;
      GameObjects t = o1;
      o1 = o2;
      o2 = t;
    }
    if (o1L == 'p' && o2L == 'x') {
      rule3 = true;
    }
    if (o1L == 'x' && o2L == 'p') {
      rule3 = true;
      GameObjects t = o1;
      o1 = o2;
      o2 = t;
    }
    if (rule3) {
      if (Math.random() > 0.5) {
        ((ActiveGameObjects)o1).updateHitPoints(1);
      }
      if (Math.random() > 0.5) {
        ((ActiveGameObjects)o2).updateHitPoints(1);
      }
    }
  }

  private void pEncounterOorK(GameObjects o1, GameObjects o2) {
    char o1L = o1.getLabel();
    char o2L = o2.getLabel();

    boolean rule4 = false;
    if (o1L == 'p' && o2L == 'o') {
      rule4 = true;
    }
    if (o1L == 'o' && o2L == 'p') {
      rule4 = true;
      GameObjects t = o1;
      o1 = o2;
      o2 = t;
    }
    if (o1L == 'p' && o2L == 'k') {
      rule4 = true;
    }
    if (o1L == 'k' && o2L == 'p') {
      rule4 = true;
      GameObjects t = o1;
      o1 = o2;
      o2 = t;
    }
    if (rule4) {
      if (Math.random() > 0.3) {
        ((ActiveGameObjects)o1).updateHitPoints(1);
      }
      if (Math.random() > 0.7) {
        ((ActiveGameObjects)o2).updateHitPoints(1);
      }
    }
  }

  private void encounterWall(GameObjects o1, GameObjects o2) {
    char o1L = o1.getLabel();
    char o2L = o2.getLabel();

    if (o1L == 'w') {
      if (o2 instanceof ActiveGameObjects) {
        ((ActiveGameObjects)o2).invertDisplacement();
      }
    }
    if (o2L == 'w') {
      if (o1 instanceof ActiveGameObjects) {
        ((ActiveGameObjects)o1).invertDisplacement();
      }
    }
  }

  private void encounterTorR(GameObjects o1, GameObjects o2) {
    char o1L = o1.getLabel();
    char o2L = o2.getLabel();

    if (o2L == 'r') {
      if (o1 instanceof ActiveGameObjects) {
        ((ActiveGameObjects)o1).updateHitPoints(1);
      }
    }
    if (o1L == 'r') {
      if (o2 instanceof ActiveGameObjects) {
        ((ActiveGameObjects)o2).updateHitPoints(1);
      }
    }
    if (o2L == 't') {
      if (o1 instanceof ActiveGameObjects) {
        ((ActiveGameObjects)o1).updateHitPoints(1);
      }
    }
    if (o1L == 't') {
      if (o2 instanceof ActiveGameObjects) {
        ((ActiveGameObjects)o2).updateHitPoints(1);
      }
    }
  }
}