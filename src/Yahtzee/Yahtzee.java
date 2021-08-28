package Yahtzee;

import Yahtzee.UserInterface.YahtzeeMenu;

public class Yahtzee {

  public Yahtzee() {
    initializeGame();
  }

  private void initializeGame() {
    YahtzeeMenu.welcome();
    YahtzeeMenu.mainMenu();
  }
}
