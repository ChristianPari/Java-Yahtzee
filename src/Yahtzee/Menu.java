package Yahtzee;

import Console.Console;

public class Menu {
  public static void welcome() {
    System.out.println("Welcome!");
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

    int sidesOnDie = Console.getNumber(
            "\nHow many sides per die?",
            "Sides: ",
            3,
            16
    );
    int numberOfDice = Console.getNumber(
            "\nHow many dice?",
            "Dice: ",
            2,
            10
    );

    var gameSetup = new GameSetup(sidesOnDie, numberOfDice);
    gameSetup.startGame();
  }
}
