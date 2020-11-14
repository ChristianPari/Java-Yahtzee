package Yahtzee;

import Yahtzee.Hand.Hand;

public class Yahtzee {

  protected void game() {
    Hand userHand = new Hand(5);
    userHand.rollDice();
    action("turn", userHand);
  }

  private void action(String action, Hand userHand) {
    switch (action) {
      case "turn":
        userTurn(userHand);
        break;

      case "re-roll":
        userReRoll(userHand);
        break;
    }
  }

  private void userTurn(Hand userHand) {
    StringBuilder dieValues = new StringBuilder();
    Menu menu = new Menu();

    for (int i = 0; i < userHand.diceValues.size(); i++) {

      String dieNumber = Integer.toString(i + 1);
      String dieValue = Integer.toString(userHand.diceValues.get(i));

      dieValues.append("Die " + dieNumber + " [" + dieValue + "] | ");
    }

    dieValues.delete(dieValues.length() - 2, dieValues.length());

    if (userHand.turns == 3) {
      System.out.println("\nYour final die values are:\n" + dieValues);
      return;
    }

    System.out.println("\nYou rolled:\n" + dieValues);
    Boolean isReRolling = menu.userReRoll();

    if (!isReRolling) {
      System.out.println("\nYour final die values are:\n" + dieValues);
      return;
    }

    action("re-roll", userHand);
  }

  private void userReRoll(Hand userHand) {
    Menu menu = new Menu();
    System.out.println("\nPlease enter the die number(s) you wish to re-roll below...");
    String choices = menu.getResponse();
    if (choices.isBlank()) {
      userReRoll(userHand);
    }
    userHand.reRoll(choices);
    action("turn", userHand);
  }

}
