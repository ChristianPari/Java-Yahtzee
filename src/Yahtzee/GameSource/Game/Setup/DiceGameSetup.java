package Yahtzee.GameSource.Game.Setup;

import Console.Console;
import Yahtzee.GameSource.Game.Game;
import Yahtzee.GameSource.Player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class DiceGameSetup {
  // variables
  private final List<Player> players = new ArrayList<>();
  private final Random random = new Random();

  // constructors
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
  public abstract void startGame();

  private void generatePlayers(int numberOfPlayers, int numberOfDice, int sidesOfDice) {
    for (int count = 1; count <= numberOfPlayers; count++) {
      var player = new Player(random, Integer.toString(count), numberOfDice, sidesOfDice);
      players.add(player);
    }
  }

  public List<Player> getPlayers() { return players; }
}
