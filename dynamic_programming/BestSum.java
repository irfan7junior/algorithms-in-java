package com.dynamic_programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BestSum {

  public static List<Integer> bestSum(int targetSum, List<Integer> numbers) {
    HashMap<Integer, List<Integer>> memo = new HashMap<>();
    return bestSum(targetSum, numbers, memo);
  }

  public static List<Integer> bestSum(int targetSum, List<Integer> numbers, HashMap<Integer, List<Integer>> memo) {
    if (memo.containsKey(targetSum))
      return memo.get(targetSum);

    if (targetSum == 0)
      return new ArrayList<>();

    if (targetSum < 0)
      return null;

    List<Integer> shortestCombination = null;

    for (Integer num : numbers) {
      int remainder = targetSum - num;
      List<Integer> remainderCombination = bestSum(remainder, numbers, memo);
      if (remainderCombination != null) {
        List<Integer> combination = new ArrayList<>(remainderCombination);
        combination.add(num);
        if (shortestCombination == null || shortestCombination.size() > combination.size()) {
          shortestCombination = combination;
        }
      }
    }
    memo.put(targetSum, shortestCombination);
    return shortestCombination;
  }
}
