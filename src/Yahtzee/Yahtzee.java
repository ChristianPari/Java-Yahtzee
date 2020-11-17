package Yahtzee;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import CLI.CLI;

public class Yahtzee {
  // variables
  private final CLI cli = new CLI();
  private final List<Player> players = new ArrayList<>();
  private final int sidesOfDie;
  private final int numberOfDice;
  private final Random random;

  // constructors
  public Yahtzee(
          int sidesOfDie,
          int numberOfDice
  ) {
    this.sidesOfDie = sidesOfDie;
    this.numberOfDice = numberOfDice;
    random = new Random();
    generatePlayers(cli.getNumber(
            "How many players?",
            "Players: ",
            1,
            4
    ));
  }

  // methods
  private void generatePlayers(int numberOfPlayers) {
    for (int count = 0; count < numberOfPlayers; count++) {
      var player = new Player(sidesOfDie, numberOfDice, random);
      players.add(player);
    }
  }

}
