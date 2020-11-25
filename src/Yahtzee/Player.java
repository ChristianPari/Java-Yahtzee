package Yahtzee;

import CLI.CLI;

import java.util.List;
import java.util.Random;

public class Player {
  // variables
  private Random random;
  public String name;
  public Hand hand;
  private int rolls;

  // constructors
  public Player(
          int sidesOfDie,
          int numberOfDie,
          Random random
  ) {
    this.name = CLI.getString(
            "\nWhat is your name?",
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
        System.out.println("\nROLLED: " + hand);
      }

      if (rolls == 1 || rolls == 2) {
        List<Integer> choices = CLI.getListIntegers(
                "\nPlease enter the dice you wish to re-roll or 0 to end turn...",
                "Dice: ",
                0,
                hand.dice.size()
        );

        roll(choices);
        System.out.println("\nROLLED: " + hand);
      }
    }

    if (rolls == 3) {
      finishTurn();
    }
  }

  private void roll() {
    if (rolls >= 3) {
      System.out.println("\nNo more turns");
      return;
    }

    hand.roll(random);
    rolls++;
  }

  private void roll(List<Integer> dieNumbers) {
    if (rolls >= 3) {
      System.out.println("\nNo more turns");
      return;
    } else if (dieNumbers.contains(0)) {
      rolls = 3;
      return;
    }

    hand.roll(random, dieNumbers);
    rolls++;
  }

//  public void hold() {}

  private void finishTurn() {
    String output = "\n" + name + "'s final roll is: " + hand;
    int outputLength = output.length();
    String separator = CLI.separator(outputLength);
    System.out.println(separator);
    System.out.println(output);
    System.out.println(separator);
  }

  // overrides
  @Override
  public String toString() {
    String output = name + "'s Dice: " + hand.toString();
    return output;
  }
}
