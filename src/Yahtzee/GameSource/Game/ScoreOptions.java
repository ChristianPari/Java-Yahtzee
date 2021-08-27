package Yahtzee.GameSource.Game;

import Yahtzee.GameSource.Player.Die;
import Yahtzee.GameSource.Player.Scorecard.ScoreTypes;
import Yahtzee.GameSource.Player.Scorecard.Scorecard;

import java.util.*;

public abstract class ScoreOptions {
  public static Map<ScoreTypes, Integer> scoreChoices(List<Die> dieList, Scorecard playerSC) {
    Map<ScoreTypes, Integer> choices = new HashMap<>();
    Map<Integer, Integer> occurrences = new HashMap<>();
    for (Die d : dieList) {
      int val = d.getValue();
      int occur = 1;
      if (occurrences.containsKey(val))
        occur += occurrences.get(val);
      occurrences.put(val, occur);
    }

    List<String> notIncluded = Arrays.asList("TotalFacesScore", "Bonus", "GrandTotal", "YahtzeeBonus");
    for (ScoreTypes st : ScoreTypes.values()) {
      if (!notIncluded.contains(st.toString()) && playerSC.isAvailable(st))
        choices.put(st, 0);
    }

    int score = 0; // total for Chance, 3 of a Kind and 4 of a Kind
    for (int die : occurrences.keySet()) {
      score += (die * occurrences.get(die));
    }

    if (playerSC.isAvailable(ScoreTypes.Chance))
      choices.put(ScoreTypes.Chance, score);

    if (occurrences.size() == 1) { // can only be Yahtzee / Yahtzee Bonus
      if (playerSC.isAvailable(ScoreTypes.Yahtzee))
        choices.put(ScoreTypes.Yahtzee, 50);
      else
        choices.put(ScoreTypes.YahtzeeBonus, 100);

    } else if (occurrences.size() == 2) { // must have a 4 of a Kind, 3 of a kind, or Full House
      if (occurrences.containsValue(4)) {
        if (playerSC.isAvailable(ScoreTypes.FoaK))
          choices.put(ScoreTypes.FoaK, score);
        if (playerSC.isAvailable(ScoreTypes.ToaK))
          choices.put(ScoreTypes.ToaK, score);
      } else if (occurrences.containsValue(3)) {
        if (playerSC.isAvailable(ScoreTypes.ToaK))
          choices.put(ScoreTypes.ToaK, score);
        if (playerSC.isAvailable(ScoreTypes.FullHouse))
          choices.put(ScoreTypes.FullHouse, 25);
      }

    } else if (occurrences.size() == 3) { // can have 3 of a kind
      if (occurrences.containsValue(3) && playerSC.isAvailable(ScoreTypes.ToaK))
        choices.put(ScoreTypes.ToaK, score);

    } else { // with more than 4 different die values, straights become possibilities
      List<Integer> dieVals = new ArrayList<>(occurrences.keySet());
      Collections.sort(dieVals);
      int consecutive = 1;
      for (int i = 0; i < occurrences.size() - 1; i++) {
        if (dieVals.get(i) + 1 == dieVals.get(i + 1))
          consecutive++;
        else {
          if (consecutive == 4)
            break;
          consecutive = 1;
        }
      }

      if (consecutive == 5 && playerSC.isAvailable(ScoreTypes.LgStraight)) {
        choices.put(ScoreTypes.LgStraight, 40);
        choices.put(ScoreTypes.SmStraight, 30);
      } else if (consecutive == 4 && playerSC.isAvailable(ScoreTypes.SmStraight))
        choices.put(ScoreTypes.SmStraight, 30);
    }

    for (int die : occurrences.keySet()) { // individual value scores
      for (ScoreTypes st : ScoreTypes.values()) {
        if (st.ordinal() + 1 == die) {
          if (playerSC.isAvailable(st))
            choices.put(st, (die * occurrences.get(die)));
          break;
        }
      }
    }

    return choices;
  }
}
