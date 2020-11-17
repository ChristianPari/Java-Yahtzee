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
  private int turns;
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
    turns = 0;
  }

  // methods
//  public void playerTurn() {}
  public void roll() {
    if (turns >= 3) {
      System.out.println("No more turns");
      return;
    }

    hand.roll(random);
  }

  public void roll(List<Integer> dieNumbers) {
    if (turns >= 3) {
      System.out.println("No more turns");
      return;
    }

    hand.roll(random, dieNumbers);
  }
//  public void hold() {}

  // overrides
  @Override
  public String toString() {
    String output = name + "'s Dice: " + hand.toString();
    return output;
  }
}
