package Yahtzee;

import Console.Console;

import java.util.List;

public class Game {
  // variables
  private final int MAX_ROUNDS = 13;
  private List<Player> players;
  private int currentRound;

  // constructors
  public Game(List<Player> players) {
    this.players = players;
    currentRound = 0;
  }

  // methods
  public void play() {
    displayPlayers();

    while (currentRound < MAX_ROUNDS) {
      round();
    }

    displayScores();
  }

  private void round() {
    currentRound++;

    System.out.println(currentRound == 13 ? "[FINAL ROUND]" : "\nRound " + currentRound);

    for (var player : players) {
      System.out.println("\n" + player.name + "'s turn...");
      player.turn();
    }
  }

  private void displayPlayers() {
    String header = "\n[PLAYERS]";
    int headerLength = header.length();
    String separator = Console.separator(headerLength);
    System.out.println(header);

    for (var player : players) {
      System.out.println(player.playerNumber + ": " + player.name);
    }

    System.out.println(separator);
  }

  private void displayScores() {
    String header = "\n[SCORES]";
    int headerLength = header.length();
    String separator = Console.separator(headerLength);
    System.out.println(header);

    for (var player : players) {
      System.out.println(player);
    }

    System.out.println(separator);
  }
}
