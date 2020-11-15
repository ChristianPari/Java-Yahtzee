package Yahtzee;

import java.util.Scanner;

public class Menu {
  private Scanner scanner = new Scanner(System.in);
  private Yahtzee yahtzee = new Yahtzee();

  public void welcome() {
    System.out.println("Hello! Welcome to Yahtzee!\n");
    System.out.println("Please choose from the list below...");
  }

  public void end() {
    System.out.println("\nHave a good day!");
  }

  public void mainMenu() {
    System.out.println("(1) Play!");
    System.out.println("(2) Exit.");
    int choice = scanner.nextInt();

    switch (choice) {
      case 1:
        System.out.println("\nGreat, lets begin!");
        yahtzee.game();
        break;

      case 2:
        System.out.println("\nHave a great day!");
        break;

      default:
        System.out.println("\nPLEASE ENTER A VALID OPTION\n");
        mainMenu();
        break;
    }
  }

  protected boolean userReRoll() {
    System.out.println("\nWould you like to roll again?");
    System.out.print("[yes | no]: ");
    String response = scanner.next().toLowerCase();

    if (response.equals("yes") & response.equals("no")) {
      System.out.println("\nPLEASE ENTER 'yes' or 'no'!\n");
      userReRoll();
    }

    if (response.equals("yes"))
      return true;
    else
      return false;
  }

  protected String getResponse() {
    String response = scanner.nextLine();
    return response;
  }
}
