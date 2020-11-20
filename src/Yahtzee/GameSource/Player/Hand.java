package Yahtzee.GameSource.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hand {
  // variables
  private int numberOfDice = 5;
  private int sidesOfDie = 6;
  public List<Die> dice = new ArrayList<>();
  private List<Die> heldDice = new ArrayList<>();

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

  public void holdDice(List<Integer> dieNumbers) {
    for (int dieNumber : dieNumbers) {
      Die die = dice.get(dieNumber - 1);
      die.isHeld = true;
      heldDice.add(die);
    }
  }

  public String getRollValues() {
    String output = "";
    for (var die : dice) {
      output += die.getValue() + " ";
    }
    return output.trim();
  }

  // overrides
  @Override
  public String toString() {
    String output = "";

    if (heldDice.size() != 0) {
      output += "\nCurrently holding... ";
      for (var die : heldDice) {
        output += die.getValue() + " ";
      }
    }

    output += heldDice.size() == 0
            ? "\nMost current roll value... "
            : "\nCurrently waiting to re-roll... ";
    for (var die : dice) {
      if (!die.isHeld)
        output += die.getValue() + " ";
    }
    return output.trim();
  }
}
