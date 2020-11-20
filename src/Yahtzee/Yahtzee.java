package Yahtzee;

import Yahtzee.UserInterface.Menu;

public class Yahtzee {

  public Yahtzee() {
    initializeGame();
  }

  private void initializeGame() {
    Menu.welcome();
    Menu.mainMenu();
  }
}
