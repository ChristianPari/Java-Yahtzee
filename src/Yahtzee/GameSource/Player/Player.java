package Yahtzee.GameSource.Player;

import Console.Console;
import Yahtzee.GameSource.Game.ScoreOptionsGenerator;
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
  public Hand hand;
  private int rolls = 0;
  public Scorecard scorecard = new Scorecard();

  // constructors
  public Player(
          Random random,
          String playerNumber,
          int numberOfDice,
          int sidesOfDice
  ) {
    this.playerNumber = "Player " + playerNumber;
    this.name = Console.getString(
            "\n" + this.playerNumber + ", what is your name?",
            "Name: "
    );
    this.random = random;
    this.hand = new Hand(numberOfDice, sidesOfDice);
  }

  // methods
  public String getName() { return name; }
  public String getPlayerNumber() { return playerNumber; }

  public void turn() {
    while (rolls < 4) {
      System.out.println(scorecard.toString());

      if (rolls == 0)
        roll();

      if (rolls <= 3) {
        int choice = decide(rolls);

        if (choice == 1) {
          List<Integer> reRolling = Console.getListIntegers(
            "\nPlease enter the dice you wish to re-roll" +
              "\nFormat: 1 3 5",
            "Dice: ",
            1,
            hand.dice.size()
          );
          roll(reRolling);

        } else {
          rolls = 4;
          pickScore(ScoreOptionsGenerator.generate(hand.dice, scorecard));
        }
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
    hand.roll(random, dieNumbers);
    System.out.println("\n[ROLLED]\n" + hand);
    rolls++;
  }

  private int decide(int rolls) {
    if (rolls <= 2) {
      return Console.getNumber(
        "\nWould you like to..." +
          "\n1) Roll again" +
          "\n2) Choose a score to keep",
        "\nChoice: ",
        1,
        2
      );
    }

    return 0;
  }

  private void pickScore(Map<ScoreTypes, Integer> choices) {
    Map<Integer, ScoreTypes> picks = new HashMap<>();
    String choicesStr = "\n";
    int counter = 1;
    int max = choices.size();
    for (ScoreTypes st : choices.keySet()) {
      picks.put(counter, st);
      String placeholder = counter++ + ") ";
      placeholder += st.toString() + ": " + choices.get(st) + " points\n";
      choicesStr += placeholder;
    }

    int choice = Console.getNumber(
      "\nThese are your possible choices..." + choicesStr,
      "Choice (1-" + max + "): ",
      1,
      max
    );

    ScoreTypes picked = picks.get(choice);
    int score = choices.get(picked);
    scorecard.addScore(picked, score);
    finishTurn(picked, score);
  }

  private void finishTurn(ScoreTypes picked, int score) {
    String output = name + " picked " + picked.toString() + " for " + score + " points!";
    int outputLength = output.length();
    String separator = Console.separator(outputLength);
    System.out.println(separator);
    System.out.println(output);
    System.out.println(separator);
  }

  // overrides
  @Override
  public String toString() {
    String output = name + "'s Score: " + scorecard.tallyUpScore();
    return output;
  }
}
