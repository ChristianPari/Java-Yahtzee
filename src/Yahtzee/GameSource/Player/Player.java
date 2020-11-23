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
        System.out.println("\n[ROLLED]\n" + hand);
      }

      if (rolls == 1) {
        List<Integer> choices = Console.getListIntegers(
                "\nPlease enter the dice you wish to re-roll or 0 to end turn...",
                "Dice: ",
                0,
                hand.dice.size()
        );

        roll(choices);
        System.out.println("\n[ROLLED]\n" + hand);
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
  }

  private void roll() {
    hand.roll(random);
    rolls++;
  }

  private void roll(List<Integer> dieNumbers) {
    if (dieNumbers.size() == 1 & dieNumbers.get(0) == 0) {
      rolls = 3;
      return;
    }

    hand.roll(random, dieNumbers);
    rolls++;
  }

  private void finishTurn() {
    rolls = 0;
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
