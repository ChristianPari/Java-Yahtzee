package CLI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CLI {
  // variables
  static private Scanner scanner = new Scanner(System.in);

  // methods
  public static List<Integer> getListIntegers(
          String prompt,
          String inputStarter,
          int min,
          int max
  ) {
    System.out.println(prompt);
    System.out.print(inputStarter);
    String choices = scanner.next();
    List<String> choicesList = Arrays.asList(choices.split(" "));
    List<Integer> intChoices = new ArrayList<>();

    for (String choice : choicesList) {
      if (!choice.matches("[" + min + "-" + max + "]")) {
        System.out.println("Please provide a valid choice input...");
        intChoices.clear();
        return getListIntegers(prompt, inputStarter, min, max);
      }

      int numericalChoice = Integer.parseInt(choice);
      intChoices.add(numericalChoice);
    }

    return intChoices;
  }

  public static String getString(
          String prompt,
          String inputStarter
  ) {
    System.out.println(prompt);
    System.out.print(inputStarter);
    String input = scanner.next();
    return input;
  }

   public static int getNumber(
          String prompt,
          String inputStarter,
          int min,
          int max
  ) {
    System.out.println(prompt);
    System.out.print(inputStarter);
    int input = scanner.nextInt();

    if (input < min | input > max) {
      System.out.println("Please enter a valid input...");
      return getNumber(prompt, inputStarter, min, max);
    }

    return input;
  }

  public static String separator(int length) {
    var builder = new StringBuilder();
    for (int count = 0; count < length - 1; count++) {
      builder.insert(count, "-");
    }
    return builder.toString();
  }
}
