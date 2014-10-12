package edu.lmu.cmsi.anu.lamegame.engine;

import edu.lmu.cmsi.anu.lamegame.gameobjects.Wall;
import edu.lmu.cmsi.anu.lamegame.gameobjects.Player;
import edu.lmu.cmsi.anu.lamegame.gameobjects.Monster;

public class GameEngine {

  private int frame;
  private int size;

  // Game Objects
  private Wall[] walls;
  private Player player;
  private Monster[] monsters;
  private Boss[] bosses;
  private Rock rock;
  private Tree tree;

  public GameEngine(int size) {
    if (size < 1) {
      throw new IllegalArgumentException("The world should exist");
    }
    this.frame = 0;
    this.size = size;

    // do this in a separate method to keep the constructor clean
    this.createWalls();
    this.rock = new Rock(5, 5);
    this.tree = new Tree(10, 18);

    this.player = new Player(3, 4);
    this.monsters = new Monster[4];
    this.monsters[0] = new Monster(4, 3, 1, 0, z);
    this.monsters[1] = new Monster(10, 12, 0, 1, x);
    this.monsters[2] = new Monster(8, 17, 1, 1, a);
    this.monsters[3] = new Monster(5, 6, 12, 3, s);
    this.bosses = new Boss[2];
    this.bosses[0] = new Boss(3, 4, 17, 2, o);
    this.bosses[1] = new Boss(1, 1, 13, 9, k);

  }

  private void createWalls() {
    // Let's create walls
    //for now, we only care about putting walls on the edges

    int wallCount = 0;
    // calculate the amount of walls we'll need
    this.walls = new Wall[this.size * 4 - 4];

    for (int x = 0; x < this.size; x++) {
      Wall x1 = new Wall(x, 0);
      walls[wallCount++] = x1;
      Wall x2 = new Wall(x, this.size - 1);
      walls[wallCount++] = x2;
    }

    for (int y = 1; y < size - 1; y++) {
      Wall y1 = new Wall(0, y);
      walls[wallCount++] = y1;
      Wall y2 = new Wall(this.size - 1, y);
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
      Wall w = this.walls[i];
      renderedWorld[w.getY()][w.getX()] = Character.toString(w.getRenderedCharacter());
    }

    renderedWorld[this.player.getY()][this.player.getX()] =
        Character.toString(this.player.getRenderedCharacter());

    // monster
    for (int i = 0; i < this.monsters.length; i++) {
      Monster m = this.monsters[i];
      renderedWorld[m.getY()][m.getX()] = Character.toString(m.getRenderedCharacter());
    }

    // boss
    for (int i = 0; i < this.bosses.length; i++) {
      Boss b = this.bosses[i];
      renderedWorld[b.getY()][b.getX()] = Character.toString(b.getRenderedCharacter());
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

    System.out.println("=========================");
  }

  private void updateObjects() {
    // everytime we add a new game object, we've got to go back through
    // every other place and add in more code - such duplication
    this.player.update();
    for (int i = 0; i < this.monsters.length; i++) {
      this.monsters[i].update();
    }
    for (int i = 0; i < this.bosses.length; i++) {
      this.bosses[i].update();
    }
  }

  private void checkCollisions() {
    for (int i = 0; i < this.walls.length; i++) {
      Wall w = this.walls[i];
      this.player.checkCollision(w);
    }
    for (int i = 0; i < this.walls.length; i++) {
      Wall w = this.walls[i];
      this.player.checkCollision(w);
    }
    for (int i = 0; i < this.walls.length; i++) {
      Wall w = this.walls[i];
      for (int j = 0; j < this.monsters.length; j++) {
        this.monsters[j].checkCollision(w);
      }
    }
    for (int i = 0; i < this.walls.length; i++) {
      Wall w = this.walls[i];
      for (int j = 0; j < this.bosses.length; j++) {
        this.bosses[j].checkCollision(w);
      }
    }
  }
}