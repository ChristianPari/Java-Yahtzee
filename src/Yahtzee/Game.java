package Yahtzee;

import Console.Console;

import java.util.ArrayList;
import java.util.List;

public class Game {
  // variables
  private List<Player> players;

  // constructors
  public Game(List<Player> players) {
    this.players = players;
  }

  // methods
  public void play() {
    displayPlayers();

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
