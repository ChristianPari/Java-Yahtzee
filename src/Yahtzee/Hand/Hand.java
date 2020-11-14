package Yahtzee.Hand;

import Yahtzee.Die.Die;

import java.util.ArrayList;
import java.util.List;

public class Hand {
  public List<Die> availableDice = new ArrayList<>();
  public List<Integer> diceValues = new ArrayList<>();
  public List<Die> heldDice = new ArrayList<>();
  public int turns = 0;

  public Hand(
          int amountOfDice
  ) {
    generateDice(amountOfDice);
  }

  private void generateDice(int amountOfDice) {
    for (int i = 1; i <= amountOfDice; i++) {
      availableDice.add(new Die());
    }
  }

  public void rollDice() {
    for (Die die :
            availableDice) {
      diceValues.add(die.rollDie());
    }
    turns++;
  }

  public void reRoll(String dieNumbersString) {
    String[] dieNumbers = dieNumbersString.split(" ");

    for (String dieNumber : dieNumbers) {

      for (int i = 1; i <= availableDice.size(); i++) {

        if (i == Integer.parseInt(dieNumber)) {
          int newDieValue = availableDice.get(i - 1).rollDie();
          diceValues.set(i - 1, newDieValue);
          turns++;
        }
      }
    }
  }

}
