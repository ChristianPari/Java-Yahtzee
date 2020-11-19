package Yahtzee.Die;

public class Die {
  private int sides = 6;
  private int value = 0;

  public Die() {}

  public Die(
          int sides
  ) {
    this.sides = sides;
  }

  public void rollDie() {
    int numberRolled = (int)(Math.random() * sides) + 1;
    value = numberRolled;
  }

  public int getDieValue() { return value; }
}
