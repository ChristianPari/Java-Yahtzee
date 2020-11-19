package Yahtzee.Hand;

import Yahtzee.Die.Die;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Hand {
  public List<Die> availableDice = new ArrayList<>();
//  public List<Integer> diceValues = new ArrayList<>();
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
    for (Die die : availableDice) {
      die.rollDie();
    }
    turns++;
  }

  public boolean reRoll(String dieNumbersString) {
    String[] dieNumbers = dieNumbersString.split(" ");

    for (String dieNumber : dieNumbers) {
      int intDieNumber = Integer.parseInt(dieNumber);
      if (intDieNumber <= 6 & intDieNumber >= 1){
        for (int i = 1; i <= availableDice.size(); i++) {
          if (i == intDieNumber) {
            Die die = availableDice.get(i - 1);
            die.rollDie();
          }
        }
      } else {
        System.out.println("\nThe choices you entered were not recognized, please try again...");
        return false;
      }
    }
    turns++;
    return true;
  }

}
