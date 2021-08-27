package Yahtzee.GameSource.Player.Scorecard;

import java.util.*;
import java.util.regex.Pattern;

public class Scorecard {
  // fields
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

  public void addScore(ScoreTypes st, int score) {
    String ord = String.valueOf(st.ordinal());
    if (Pattern.matches("[0-5]", ord)) {
      Integer val = scorecard.get(ScoreTypes.TotalFacesScore);
      int newVal = (val == null) ? score : (val + score);
      scorecard.put(ScoreTypes.TotalFacesScore, newVal);
    }

    if (st.toString().equals("YahtzeeBonus")) {
      Integer val = scorecard.get(st);
      score = (val == null) ? 1 : (val + 1);
    }

    scorecard.put(st, score);
  }

  public int tallyUpScore() {
    scorecard.put(ScoreTypes.GrandTotal, 0);

    for (ScoreTypes st : scorecard.keySet()) {
      if (scorecard.get(st) == null)
        continue;

      int grandT = scorecard.get(ScoreTypes.GrandTotal);
      String str = st.toString();

      if (str.equals("GrandTotal"))
        continue;

      if (str.equals("YahtzeeBonus") && scorecard.get(st) != null) {
        scorecard.put(ScoreTypes.GrandTotal, grandT + (scorecard.get(st) * 100));
        continue;
      }

      if (str.equals("TotalFacesScore") && scorecard.get(st) >= 63) {
        scorecard.put(ScoreTypes.GrandTotal, grandT + 35);
        continue;
      }

      scorecard.put(ScoreTypes.GrandTotal, grandT + scorecard.get(st));
    }

    return scorecard.get(ScoreTypes.GrandTotal);
  }

  @Override
  public String toString() {
    String output = "\nFields that are currently empty...\n";
    ScoreTypes[] scores = ScoreTypes.values();
    List<String> notIncluded = Arrays.asList("TotalFacesScore", "Bonus", "GrandTotal", "YahtzeeBonus");

    for (ScoreTypes sc : scores) {
      if (!notIncluded.contains(sc.toString()) && scorecard.get(sc) == null)
        output += sc + ", ";
    }

    return output.substring(0, output.length() - 2);
  }
}
