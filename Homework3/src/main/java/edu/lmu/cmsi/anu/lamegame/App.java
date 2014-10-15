package edu.lmu.cmsi.anu.lamegame;

import java.util.Scanner;

import edu.lmu.cmsi.anu.lamegame.engine.GameEngine1;

public class App {

  private Scanner keyboard = null;
  private GameEngine1 engine;

  public App() {
    System.out.println("Welcome to LameGame");
    System.out.println("Commands are: [N]ext frame or [Q]uit");
    this.keyboard = new Scanner(System.in);
    this.engine = new GameEngine1(20);
    this.engine.initiate();
  }

  /*
   Returns the lower case String of the keyboard input
   */
  private String getInput() {
    return this.keyboard.next().toLowerCase();
  }

  public static void main(String[] args) {
    App theApp = new App();
    String input = theApp.getInput();

    while (!input.equals("q")) {
      if (input.equals("n")) {
        theApp.engine.update();
      }

      input = theApp.getInput();
    }
  }
}
