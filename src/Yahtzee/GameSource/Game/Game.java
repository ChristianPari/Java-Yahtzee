package Yahtzee.GameSource.Game;

import Console.Console;
import Yahtzee.GameSource.Player.Player;

import java.util.List;

public class Game {
  // variables
  private final int MAX_ROUNDS = 13;
  private List<Player> players; // In game players
  private int currentRound; // Tracks the current round

  // constructors
  public Game(List<Player> players) { // Players created during game setup and assigned here
    this.players = players;
    currentRound = 0;
  }

  // methods
  public void play() { // Initiates the game, round by round
    displayPlayers();

    while (currentRound < MAX_ROUNDS) {
      round();
    }

    announceWinner();
    displayScores();
  }

  private void round() { // Round play through
    currentRound++;

    System.out.println(currentRound == 13 ? "\n[FINAL ROUND]" : "\nRound " + currentRound);

    for (var player : players) {
      System.out.println("\n" + player.getName() + "'s turn...");
      player.turn();
    }
  }

  private void displayPlayers() {
    String header = "\n[PLAYERS]";
    int headerLength = header.length();
    String separator = Console.separator(headerLength);
    System.out.println(header);

    for (var player : players) {
      System.out.println(player.getPlayerNumber() + ": " + player.getName());
    }

    System.out.println(separator);
  }

  private void displayScores() {
    String header = "\n[SCORES]";
    System.out.println(header);

    for (var player : players) {
      System.out.println(player);
      System.out.println(player.scorecard.displayScorecard());
    }
  }

  private void announceWinner() {
    System.out.println("\n[THE WINNER IS...]");

    Player winner = players.get(0);
    for (var player : players) {
      if (player.scorecard.tallyUpScore() > winner.scorecard.tallyUpScore())
        winner = player;
    }

    System.out.println(winner.getName());
  }
}
