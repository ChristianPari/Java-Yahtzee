package Yahtzee;

import Console.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameSetup {
  // variables
  private final List<Player> players = new ArrayList<>();
  private final int sidesOfDie;
  private final int numberOfDice;
  private final Random random;

  // constructors
  public GameSetup(
          int sidesOnDie,
          int numberOfDice
  ) {
    this.sidesOfDie = sidesOnDie;
    this.numberOfDice = numberOfDice;
    random = new Random();
    generatePlayers(Console.getNumber(
            "\nHow many players?",
            "Players: ",
            1,
            4
    ));
  }

  // methods
  public void startGame() {
    var game = new Game(players);
    game.play();
  }

  private void generatePlayers(int numberOfPlayers) {
    for (int count = 1; count <= numberOfPlayers; count++) {
      var player = new Player(sidesOfDie, numberOfDice, random, Integer.toString(count));
      players.add(player);
    }
  }

}
