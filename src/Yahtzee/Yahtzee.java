package Yahtzee;

import CLI.CLI;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Yahtzee {
  // variables
  private final List<Player> players = new ArrayList<>();
  private final int sidesOfDie;
  private final int numberOfDice;
  private final Random random;

  // constructors
  public Yahtzee(
          int sidesOnDie,
          int numberOfDice
  ) {
    this.sidesOfDie = sidesOnDie;
    this.numberOfDice = numberOfDice;
    random = new Random();
    generatePlayers(CLI.getNumber(
            "\nHow many players?",
            "Players: ",
            1,
            4
    ));
  }

  // methods
  public void startGame() {
    for (var player : players) {
      System.out.println("\n" + player.name + "'s turn...");
      player.turn();
    }
<<<<<<< HEAD

    displayScores();
  }
=======
  }

  private void userTurn(Hand userHand) {
    StringBuilder dieValues = new StringBuilder();
    Menu menu = new Menu();

    for (int i = 0; i < userHand.availableDice.size(); i++) {

      String dieNumber = Integer.toString(i + 1);
      String dieValue = Integer.toString(userHand.availableDice.get(i).getDieValue());
>>>>>>> main

  private void generatePlayers(int numberOfPlayers) {
    for (int count = 0; count < numberOfPlayers; count++) {
      var player = new Player(sidesOfDie, numberOfDice, random);
      players.add(player);
    }

    displayPlayers();
  }

  private void displayPlayers() {
    String header = "\n[PLAYERS]";
    int headerLength = header.length();
    String separator = CLI.separator(headerLength);
    System.out.println(header);

    for (var player : players) {
      System.out.println(player.name);
    }

    System.out.println(separator);
  }

  private void displayScores() {
    String header = "\n[SCORES]";
    int headerLength = header.length();
    String separator = CLI.separator(headerLength);
    System.out.println(header);

    for (var player : players) {
      System.out.println(player);
    }

    System.out.println(separator);
  }
}
