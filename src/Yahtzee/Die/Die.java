package Yahtzee.Die;

public class Die {
  private int sides = 6;
  public boolean isHeld = false;

  public Die() {}

  public Die(
          int sides
  ) {
    this.sides = sides;
  }

  public int rollDie() {
    int numberRolled = (int)(Math.random() * sides) + 1;
    return numberRolled;
  }
}
