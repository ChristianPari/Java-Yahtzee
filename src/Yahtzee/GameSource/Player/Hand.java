package Yahtzee.GameSource.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hand {
  // variables
  public List<Die> dice = new ArrayList<>();

  // constructors
  public Hand(int numberOfDice, int sidesOfDie) {
    generateDice(numberOfDice, sidesOfDie);
  }

  // methods
  private void generateDice(int numberOfDice, int sidesOfDie) {
    for (int count = 0; count < numberOfDice; count++) {
      dice.add(new Die(sidesOfDie));
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
