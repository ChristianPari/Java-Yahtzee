package Yahtzee.UserInterface;

import Console.Console;
import Yahtzee.GameSource.Game.Setup.DiceGameSetup;
import Yahtzee.GameSource.Game.Setup.YahtzeeGameSetup;

public abstract class YahtzeeMenu {
  public static void welcome() {
    System.out.println("Welcome to Yahtzee!");
    System.out.println("* Each user has 13 rounds of up to 3 rolls to achieve the highest point total by completing 'Score Objectives'");
    System.out.println("[Score Objectives]\n" +
            "* Aces  * Twos  * Threes  * Fours  * Fives  * Sixes\n" +
            "* 3 of a kind   * 4 of a kind\n" +
            "* Full House    * Small Straight   * Large Straight\n" +
            "* YAHTZEE       * Chance");
  }

  public static void exit() {
    System.out.println("Have a good day!");
  }

  public static void mainMenu() {
    int choice = Console.getNumber(
            "\n1) Start Game" +
                    "\n2) Exit",
            "Enter Choice (1 - 2): ",
            1,
            2
    );

    if (choice == 2) {
      exit();
      return;
    }

    DiceGameSetup dgs = new YahtzeeGameSetup();
    dgs.startGame();
  }
}
