package Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public abstract class Console {
  // variables
  static private Scanner scanner = new Scanner(System.in);

  // methods
  public static List<Integer> getListIntegers(
      String prompt,
      String inputStarter,
      int min,
      int max
  ) {
    List<Integer> intChoices = new ArrayList<>();

    while (true) {
      System.out.println(prompt);
      System.out.print(inputStarter);
      String choices = scanner.nextLine().trim();
      List<String> choicesList = Arrays.asList(choices.split("\\s+"));

      for (String choice : choicesList) {
        if (!choice.matches("[" + min + "-" + max + "]")) {
          System.out.println("Please provide a valid choice input...");
          intChoices.clear();
          break;
        }

        int numericalChoice = Integer.parseInt(choice);
        intChoices.add(numericalChoice);
      }

      if (intChoices.size() == choicesList.size()) {
        break;
      }
    }

    return intChoices;
  }

  public static String getString(
      String prompt,
      String inputStarter
  ) {
    System.out.println(prompt);
    System.out.print(inputStarter);
    String input = scanner.nextLine();
    return input;
  }

  public static int getNumber(
      String prompt,
      String inputStarter,
      int min,
      int max
  ) {
    int choice = 0;
    System.out.println(prompt);
    System.out.print(inputStarter);

    while (true) {
      try {
        choice = scanner.nextInt();
        scanner.nextLine();
        if (choice < min || choice > max) {
          System.out.println("Please enter a valid input...\n");
          System.out.print(inputStarter);
        } else {
          break;
        }
      } catch (Exception e) {
        scanner.next();
        System.out.println("Please enter a valid input...\n");
        System.out.print(inputStarter);
      }
    }
    return choice;
  }

  public static String separator(int length) {
    var builder = new StringBuilder();
    for (int count = 0; count < length; count++) {
      builder.insert(count, "-");
    }
    return builder.toString();
  }
}
