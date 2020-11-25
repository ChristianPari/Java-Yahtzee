package Yahtzee.GameSource.Player;

import Console.Console;

import java.util.List;
import java.util.Random;

public class Player {
  // variables
  private Random random;
  public String name;
  public String playerNumber;
  public Hand hand;
  private int rolls;

  // constructors
  public Player(
          int sidesOfDie,
          int numberOfDie,
          Random random,
          String playerNumber
  ) {
    this.playerNumber = "Player " + playerNumber;
    this.name = Console.getString(
            "\n" + this.playerNumber + ", what is your name?",
            "Name: "
    );
    this.random = random;
    hand = new Hand(sidesOfDie, numberOfDie);
    rolls = 0;
  }

  // methods
  public void turn() {
    while (rolls < 3) {

      if (rolls == 0) {
        roll();
      }

      if (rolls == 1) {
        List<Integer> choices = Console.getListIntegers(
                "\nPlease enter the dice you wish to re-roll or 0 to end turn...",
                "Dice: ",
                0,
                hand.dice.size()
        );

        roll(choices);
      }

      if (rolls == 2) {
        List<Integer> choices = Console.getListIntegers(
                "\nPlease enter the dice you wish to re-roll or 0 to end turn...",
                "Dice: ",
                0,
                hand.dice.size()
        );

        roll(choices);
        finishTurn();
      }
    }

    rolls = 0;
  }

  private void roll() {
    hand.roll(random);
    System.out.println("\n[ROLLED]\n" + hand);
    rolls++;
  }

  private void roll(List<Integer> dieNumbers) {
    if (dieNumbers.contains(0)) {
      if (dieNumbers.size() > 1) {
        System.out.println("Turn ended because you entered a '0' into the choices...");
      }
      rolls = 3;
      finishTurn();
      return;
    }

    hand.roll(random, dieNumbers);
    System.out.println("\n[ROLLED]\n" + hand);
    rolls++;
  }

  private void finishTurn() {
    String output = name + "'s final roll is: " + hand;
    int outputLength = output.length();
    String separator = Console.separator(outputLength);
    System.out.println("");
    System.out.println(separator);
    System.out.println(output);
    System.out.println(separator);
  }

  // overrides
  @Override
  public String toString() {
    String output = name + "'s Dice: " + hand;
    return output;
  }
}
