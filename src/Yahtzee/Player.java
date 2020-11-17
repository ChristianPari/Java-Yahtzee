package Yahtzee;

import CLI.CLI;

import java.util.List;
import java.util.Random;

public class Player {
  // variables
  private CLI cli = new CLI();
  private Random random;
  public String name;
  public Hand hand;
  private int rolls;
  private int score;

  // constructors
  public Player(
          int sidesOfDie,
          int numberOfDie,
          Random random
  ) {
    this.name = cli.getString(
            "What is your name?",
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
        System.out.println(hand);
      }

      if (rolls == 1 | rolls == 2) {
        List<Integer> choices = cli.getListIntegers(
                "\nPlease enter the dice you wish to re-roll or 0 to end turn...",
                "Dice: ",
                0,
                hand.dice.size()
        );

        roll(choices);
        System.out.println(hand);
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
    } else if (dieNumbers.size() == 1 & dieNumbers.get(0) == 0) {
      rolls = 3;
      return;
    }

    hand.roll(random, dieNumbers);
    rolls++;
  }

//  public void hold() {}

  private void finishTurn() {
    System.out.println(name + " final roll is " + hand);
  }

  // overrides
  @Override
  public String toString() {
    String output = name + "'s Dice: " + hand.toString();
    return output;
  }
}
