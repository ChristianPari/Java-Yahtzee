package Yahtzee;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hand {
  // variables
  private int numberOfDice = 5;
  private int sidesOfDie = 6;
  public List<Die> dice = new ArrayList<>();

  // constructors
  public Hand() {
    generateDice();
  }

  public Hand(int numberOfDice) {
    this.numberOfDice = numberOfDice;
    generateDice();
  }

  public Hand(
          int numberOfDice,
          int sidesOfDie
  ) {
    this.numberOfDice = numberOfDice;
    generateDice(sidesOfDie);
  }

  // methods
  private void generateDice() {
    for (int count = 0; count < numberOfDice; count++) {
      dice.add(new Die());
    }
  }

  private void generateDice(int sidesOnDie) {
    for (int count = 0; count < numberOfDice; count++) {
      dice.add(new Die(sidesOnDie));
    }
  }

  public void roll(Random random) {
    for (var die : dice) {
      die.roll(random);
    }
  }

  // specific die rolls
//  public void rollDice(Random random, int[] dieNumbers) {
//    for (int dieNumber: dieNumbers) {
//      Die die = availableDice.get(dieNumber - 1);
//      dieValues.indexOf()
//      die.rollDie();
//    }
//  }

  // overrides
  @Override
  public String toString() {
    String output = "";
    for (var die : dice) {
      output += die.getValue() + " ";
    }
    return output.trim();
  }
}
