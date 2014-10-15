 package edu.lmu.cmsi.anu.lamegame.engine;

import edu.lmu.cmsi.anu.lamegame.gameobjects.Wall;
import edu.lmu.cmsi.anu.lamegame.gameobjects.Rock;
import edu.lmu.cmsi.anu.lamegame.gameobjects.Tree;
import edu.lmu.cmsi.anu.lamegame.gameobjects.Player;
import edu.lmu.cmsi.anu.lamegame.gameobjects.MonsterA;
import edu.lmu.cmsi.anu.lamegame.gameobjects.MonsterS;
import edu.lmu.cmsi.anu.lamegame.gameobjects.MonsterZ;
import edu.lmu.cmsi.anu.lamegame.gameobjects.MonsterX;
import edu.lmu.cmsi.anu.lamegame.gameobjects.BossO;
import edu.lmu.cmsi.anu.lamegame.gameobjects.BossK;

public class GameEngine1 {

  private int frame;
  private int size;

  // Game Objects
  private Wall[] walls;
  private Rock rock;
  private Tree tree;
  private Player player;
  private MonsterA monsterA;
  private MonsterS monsterS;
  private MonsterZ monsterZ;
  private MonsterX monsterX;
  private BossO bossO;
  private BossK bossK;

  public void GameEngine(int size) {
    if (size < 20) {
      throw new IllegalArgumentException("This game recommends a size of at least 20.");
    }

    this.frame = 0;
    this.size = size;
  }

  public void initiate() {
    this.createWalls();

    this.rock = new Rock(5, 5);
    this.tree = new Tree(10, 10);

    this.player = new Player(3, 4);
    this.player.setDisplacement(1, 0);
    this.monsterA = new MonsterA(5, 6);
    this.monsterA.setDisplacement(1, 1);
    this.monsterS = new MonsterS(8, 8);
    this.monsterS.setDisplacement(0, 1);
    this.monsterX = new MonsterX(1, 2);
    this.monsterX.setDisplacement(1, -1);
    this.monsterZ = new MonsterZ(7, 12);
    this.monsterZ.setDisplacement(0, -1);
    this.bossO = new BossO(10, 3);
    this.bossO.setDisplacement(1, 1);
    this.bossK = new BossK(12, 3);
    this.bossK.setDisplacement(-1, 0);
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

  // the main update loop
  public void update() {
    this.frame++;
    this.render();
    this.updateObjects();
    this.checkCollisions();
  }

  private void render() {
    String[][] renderedWorld = new String[this.size][this.size];

    //walls
    for (int i = 0; i < this.walls.length; i++) {
      Wall w = this.walls[i];
      renderedWorld[w.coords.getY()][w.coords.getX()] = Character.toString(w.getLabel());
    }

    //rock
    renderedWorld[this.rock.coords.getY()][this.rock.coords.getX()] =
        Character.toString(this.rock.getLabel());

    //tree
    renderedWorld[this.tree.coords.getY()][this.tree.coords.getX()] =
        Character.toString(this.tree.getLabel());

    //player
    renderedWorld[this.player.coords.getY()][this.player.coords.getX()] =
        Character.toString(this.player.getLabel());

    //monsters
    renderedWorld[this.monsterA.coords.getY()][this.monsterA.coords.getX()] =
        Character.toString(this.monsterA.getLabel());

    renderedWorld[this.monsterS.coords.getY()][this.monsterS.coords.getX()] =
        Character.toString(this.monsterS.getLabel());

    renderedWorld[this.monsterZ.coords.getY()][this.monsterZ.coords.getX()] =
        Character.toString(this.monsterZ.getLabel());

    renderedWorld[this.monsterX.coords.getY()][this.monsterX.coords.getX()] =
        Character.toString(this.monsterX.getLabel());

    //bosses
    renderedWorld[this.bossO.coords.getY()][this.bossO.coords.getX()] =
        Character.toString(this.bossO.getLabel());

    renderedWorld[this.bossK.coords.getY()][this.bossK.coords.getX()] =
        Character.toString(this.bossK.getLabel());

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
    System.out.print(player.getLabel() + ":" + player.getHitPoints() + " ");
    System.out.print(monsterA.getLabel() + ":" + monsterA.getHitPoints() + " ");
    System.out.print(monsterS.getLabel() + ":" + monsterS.getHitPoints() + " ");
    System.out.print(monsterZ.getLabel() + ":" + monsterZ.getHitPoints() + " ");
    System.out.print(monsterX.getLabel() + ":" + monsterX.getHitPoints() + " ");
    System.out.print(bossO.getLabel() + ":" + bossO.getHitPoints() + " ");
    System.out.print(bossK.getLabel() + ":" + bossK.getHitPoints() + " ");
    System.out.println("");

    System.out.println("=========================");
  }

  private void updateObjects() {
    this.player.updateCoordinates();
    this.monsterA.updateCoordinates();
    this.monsterS.updateCoordinates();
    this.monsterZ.updateCoordinates();
    this.monsterX.updateCoordinates();
    this.bossO.updateCoordinates();
    this.bossK.updateCoordinates();
  }

  private void checkCollisions() {
    
    //player
    for (int i = 0; i < this.walls.length; i++) {
      Wall w = this.walls[i];
      this.player.checkCollision(w);
    }
    this.player.checkCollision(monsterA);
    this.player.checkCollision(monsterS);
    this.player.checkCollision(monsterZ);
    this.player.checkCollision(monsterX);
    this.player.checkCollision(rock);
    this.player.checkCollision(tree);

    //monsters
    for (int i = 0; i < this.walls.length; i++) {
      Wall w = this.walls[i];
      this.monsterA.checkCollision(w);
    }
    this.monsterA.checkCollision(player);
    this.monsterA.checkCollision(rock);
    this.monsterA.checkCollision(tree);

    for (int i = 0; i < this.walls.length; i++) {
      Wall w = this.walls[i];
      this.monsterS.checkCollision(w);
    }
    this.monsterS.checkCollision(player);
    this.monsterS.checkCollision(rock);
    this.monsterS.checkCollision(tree);

    for (int i = 0; i < this.walls.length; i++) {
      Wall w = this.walls[i];
      this.monsterZ.checkCollision(w);
    }
    this.monsterZ.checkCollision(player);
    this.monsterZ.checkCollision(rock);
    this.monsterZ.checkCollision(tree);

    for (int i = 0; i < this.walls.length; i++) {
      Wall w = this.walls[i];
      this.monsterX.checkCollision(w);
    }
    this.monsterX.checkCollision(player);
    this.monsterX.checkCollision(rock);
    this.monsterX.checkCollision(tree);

    //bosses
    for (int i = 0; i < this.walls.length; i++) {
      Wall w = this.walls[i];
      this.bossO.checkCollision(w);
    }
    this.bossO.checkCollision(player);
    this.bossO.checkCollision(rock);
    this.bossO.checkCollision(tree);

    for (int i = 0; i < this.walls.length; i++) {
      Wall w = this.walls[i];
      this.bossK.checkCollision(w);
    }
    this.bossK.checkCollision(player);
    this.bossK.checkCollision(rock);
    this.bossK.checkCollision(tree);

  }
}
