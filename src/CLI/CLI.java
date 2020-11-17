package CLI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CLI {
  // variables
  private final Scanner scanner = new Scanner(System.in);

  // methods
  public List<Integer> getListIntegers(
          String prompt,
          String inputStarter,
          int min,
          int max
  ) {
    System.out.println(prompt);
    System.out.print(inputStarter);
    String choices = scanner.nextLine();
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

  public String getString(
          String prompt,
          String inputStarter
  ) {
    System.out.println(prompt);
    System.out.print(inputStarter);
    String input = scanner.nextLine();
    return input;
  }

  public int getNumber(
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
}
