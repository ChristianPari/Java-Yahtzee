package Yahtzee.GameSource.Game;

import Console.Console;
import Yahtzee.GameSource.Player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameSetup {
  // variables
  private final List<Player> players = new ArrayList<>();
  private final Random random = new Random();

  // constructors
  public GameSetup() {
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
      var player = new Player(random, Integer.toString(count));
      players.add(player);
    }
  }

}
