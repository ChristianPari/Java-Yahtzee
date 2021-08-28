package Yahtzee.GameSource.Game.Setup;

import Yahtzee.GameSource.Game.Game;

public class YahtzeeGameSetup extends DiceGameSetup {
  public YahtzeeGameSetup() {
    super(5, 6);
  }

  public void startGame() {
    var game = new Game(super.getPlayers());
    game.play();
  }
}
