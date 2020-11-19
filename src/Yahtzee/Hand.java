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
          int sidesOfDie,
          int numberOfDice
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

  public void roll(Random random, List<Integer> dieNumbers) {
    for (int dieNumber: dieNumbers) {
      var die = dice.get(dieNumber - 1);
      die.roll(random);
    }
  }

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
