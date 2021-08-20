package Yahtzee.GameSource.Player;

import Console.Console;
import Yahtzee.GameSource.Player.Scorecard.ScoreTypes;
import Yahtzee.GameSource.Player.Scorecard.Scorecard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Player {
  // variables
  private Random random;
  private String name;
  private String playerNumber;
  public Hand hand = new Hand();
  private int rolls = 0;
  private Scorecard scorecard = new Scorecard();

  // constructors
  public Player(
          Random random,
          String playerNumber
  ) {
    this.playerNumber = "Player " + playerNumber;
    this.name = Console.getString(
            "\n" + this.playerNumber + ", what is your name?",
            "Name: "
    );
    this.random = random;
  }

  // methods
  public String getName() { return name; }
  public String getPlayerNumber() { return playerNumber; }

  public void turn() {
    while (rolls < 3) {

      if (rolls == 0) {
        roll();
      }

      if (rolls <= 2) {
        List<Integer> choices = Console.getListIntegers(
                "\nPlease enter the dice you wish to re-roll or 0 to end turn..." +
                  "\nFormat: 1 3 5",
                "Dice: ",
                0,
                hand.dice.size()
        );

        roll(choices);
        if (rolls == 2)
          finishTurn();
      }
    }

    rolls = 0;
  }

  private void roll() {
    hand.roll(random);
    System.out.println("\n[ROLLED]\n" + hand);
    rolls++;
  }

  private void roll(List<Integer> dieNumbers) {
    if (dieNumbers.contains(0)) {
      if (dieNumbers.size() > 1) {
        System.out.println("Turn ended because you entered a '0' into the choices...");
      }
      rolls = 3;
      finishTurn();
      return;
    }

    hand.roll(random, dieNumbers);
    System.out.println("\n[ROLLED]\n" + hand);
    rolls++;
  }

  private void chooseScore() {
    // each unique number has to have own choice: 1 2 3 2 3 -> 1 Ones 2 Twos 2 Threes
    // check for 3, 4 or 5 of same die value: 3 and 4 are total of die values, 5 is Yahtzee
    // check for full house (3 same die, 2 same different die)
    // check for small straight and large straight
    // always have a chance option

    Map<ScoreTypes, Integer> options = new HashMap<>();
    for (Die d : hand.dice) {
      for (ScoreTypes st : ScoreTypes.values()) {
        int scoreID = st.ordinal() + 1;
        if (scoreID > 6)
          break;

        if (scoreID == d.getValue()) {
          int amountInHand = 1;

          if (options.containsKey(st))
            amountInHand += options.get(st);

          options.put(st, amountInHand);
        }
      }
    }
  }

  private void finishTurn() {
    String output = name + "'s final roll is: " + hand;
    int outputLength = output.length();
    String separator = Console.separator(outputLength);
    System.out.println("");
    System.out.println(separator);
    System.out.println(output);
    System.out.println(separator);
  }

  // overrides
  @Override
  public String toString() {
    String output = name + "'s Dice: " + hand;
    return output;
  }
}
