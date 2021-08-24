package Yahtzee.GameSource.Player.Scorecard;

import java.util.HashMap;
import java.util.Map;

public class Scorecard {
  // fields
  private int grandTotal = 0;
  private final Map<ScoreTypes, Integer> defaultScores = Map.of(
    ScoreTypes.FullHouse, 25,
    ScoreTypes.SmStraight, 30,
    ScoreTypes.LgStraight, 40,
    ScoreTypes.Yahtzee, 50
  );
  private Map<ScoreTypes, Integer> scorecard = new HashMap<>();

  // constructor
  public Scorecard() {
    fillScorecard();
  }

  // methods
  private void fillScorecard() {
    for (ScoreTypes st : ScoreTypes.values()) {
      scorecard.put(st, null);
    }
  }

  public boolean isAvailable(ScoreTypes st) { return scorecard.get(st) == null; }

  public boolean addScore(ScoreTypes st, int score) {
    if (scorecard.get(st) == null) {
      if (defaultScores.containsKey(st))
        score = defaultScores.get(st);
      scorecard.put(st, score);
      return true; // successful score added
    }

    return false; // failure, score already exists
  }

  public void tallyUpScore() {
    for (Integer score : scorecard.values()) {
      grandTotal += score;
    }
  }
}
