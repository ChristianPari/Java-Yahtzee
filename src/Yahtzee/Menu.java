package Yahtzee;

import CLI.CLI;

public class Menu {
  public static void welcome() {
    System.out.println("Welcome to Yahtzee!");
  }

  public static void exit() {
    System.out.println("Have a good day!");
  }

  public static void mainMenu() {
    int choice = CLI.getNumber(
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

    int sidesOnDie = CLI.getNumber(
            "\nHow many sides per die?",
            "Sides: ",
            3,
            16
    );
    int numberOfDice = CLI.getNumber(
            "\nHow many dice?",
            "Dice: ",
            2,
            10
    );

    var yahtzee = new Yahtzee(sidesOnDie, numberOfDice);
    yahtzee.startGame();
  }
}
