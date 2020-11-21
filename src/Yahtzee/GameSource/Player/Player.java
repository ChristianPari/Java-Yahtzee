package Yahtzee.GameSource.Player;

import Console.Console;

import java.util.ArrayList;
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
    rolls = 1;
  }

  // methods
  public void turn() {
    // roll 1) initial roll
      // display dice
        // option to choose what to hold
    // roll 2) roll non chosen dice
      // display dice
        // option to choose what to hold
    // roll 3) roll non chosen dice
      // display final dice
        // end turn

    while (rolls <= 3) {
      if (rolls == 1) {
        roll();
        List<Integer> choices = Console.getListIntegers(
                "\nPlease enter the dice you want to hold, the rest will be re-rolled",
                "Dice: ",
                0,
                hand.dice.size()
        );
        hold(choices);

      } else if (rolls == 2) {
        roll(getRollableDice());
        hand.clearHeldDice();
        List<Integer> choices = Console.getListIntegers(
                "\nPlease enter the dice you want to hold, the rest will be re-rolled",
                "Dice: ",
                0,
                hand.dice.size()
        );
        hold(choices);

      } else if (rolls == 3) {
        roll(getRollableDice());
        hand.clearHeldDice();
        finishTurn();

      }
    }
  }

//    while (rolls < 3) {
//      if (rolls == 0) {
//        roll();
//        System.out.println("\n[ROLLED]\n" + hand.getRollValues());
//      }
//
//      if (rolls == 1 | rolls == 2) {
//        List<Integer> choices = Console.getListIntegers(
//                "\nPlease enter the dice you wish to re-roll or 0 to end turn...",
//                "Dice: ",
//                0,
//                hand.dice.size()
//        );
//
//        roll(choices);
//        System.out.println("\n[ROLLED]\n\t" + hand);
//      }
//    }
//
//    if (rolls == 3) {
//      finishTurn();
//    }

  private void roll() {
    rolls++;
    hand.roll(random);
    System.out.println("\n[ROLLED]\n" + hand.getRollValues());
  }

  private void roll(List<Integer> dieNumbers) {
    if (dieNumbers.size() == 1 & dieNumbers.get(0) == 0) {
      rolls = 3;
      return;
    }

    rolls++;
    hand.roll(random, dieNumbers);
    System.out.println(rolls != 3 ? "\n[ROLLED]\n" + hand : "");
  }

  private void hold(List<Integer> dieNumbers) {
    if (dieNumbers.size() == 1 & dieNumbers.get(0) == 0) {
      System.out.println("options");
      return;
    }

    hand.holdDice(dieNumbers);
  }

  private List<Integer> getRollableDice() {
    List<Integer> dice = new ArrayList<>();
    for (var die : hand.dice) {
      if (!die.isHeld) {
        int index = hand.dice.indexOf(die);
        dice.add(index + 1);
      }
    }

    return dice;
  }

  private void finishTurn() {
    rolls = 0;
    String output = "\n" + name + "'s final roll is: " + hand.getRollValues();
    int outputLength = output.length();
    String separator = Console.separator(outputLength);
    System.out.println(separator);
    System.out.println(output);
    System.out.println(separator);
  }

  // overrides
  @Override
  public String toString() {
    String output = name + "'s Dice: " + hand.getRollValues();
    return output;
  }
}
