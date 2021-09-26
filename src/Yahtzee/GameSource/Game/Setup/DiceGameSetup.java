package Yahtzee.GameSource.Game.Setup;

import Console.Console;
import Yahtzee.GameSource.Game.Game;
import Yahtzee.GameSource.Player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
  This abstract class is dynamic and can be used for any
  Dice Game Setup, it is uncoupled from any other part of
  the program
*/
public abstract class DiceGameSetup {
  // variables
  private final List<Player> players = new ArrayList<>();
  private final Random random = new Random(); // Single instance of the Random class

  // constructors
  /*
    Created 2 constructors:
      - one that can be used to give the user a choice
        in how many dice a player has to their hand
        and how many sides each dice has
      - the other takes the amount of dice and the
        amount of sides per dice in as arguments
      - both ask the user how many players there are tho
  */
  public DiceGameSetup() {
    int numberOfDice = Console.getNumber(
      "\nHow many dice will each player have?",
      "Dice: ",
      1,
      20
    );
    int sidesOfDice = Console.getNumber(
      "\nHow many sides do the dice have?",
      "Sides: ",
      1,
      20
    );
    int numberOfPlayers = Console.getNumber(
      "\nHow many players?",
      "Players: ",
      1,
      4
    );

    generatePlayers(numberOfPlayers, numberOfDice, sidesOfDice);
  }

  public DiceGameSetup(int numberOfDice, int sidesOfDice) {
    int numberOfPlayers = Console.getNumber(
      "\nHow many players?",
      "Players: ",
      1,
      4
    );
    generatePlayers(numberOfPlayers, numberOfDice, sidesOfDice);
  }

  // methods
  public abstract void startGame(); // To be overridden in the class that inherits

  /*
    Uses the whole of the data collected to generate the basis of players
    and pass the data into a new instance of a Player class 'n' amount of
    times
  */
  private void generatePlayers(int numberOfPlayers, int numberOfDice, int sidesOfDice) {
    for (int count = 1; count <= numberOfPlayers; count++) {
      var player = new Player(random, Integer.toString(count), numberOfDice, sidesOfDice);
      players.add(player);
    }
  }

  public List<Player> getPlayers() { return players; }
}
