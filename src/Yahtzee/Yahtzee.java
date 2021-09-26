package Yahtzee;

import Yahtzee.UserInterface.YahtzeeMenu;

public class Yahtzee {

  public Yahtzee() {
    initializeGame();
  }

  private void initializeGame() {
    YahtzeeMenu.welcome(); // Welcome message to users
    YahtzeeMenu.mainMenu(); // Beginning prompt for users
  }
}
