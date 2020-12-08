package com.dynamic_programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HowSum {
  public static List<Integer> howSum(int targetSum, List<Integer> numbers, HashMap<Integer, List<Integer>> memo) {
    if (memo.containsKey(targetSum))
      return memo.get(targetSum);
    if (targetSum == 0)
      return new ArrayList<>();
    if (targetSum < 0)
      return null;

    for (Integer num : numbers) {
      int remainder = targetSum - num;
      List<Integer> remainderResult = howSum(remainder, numbers, memo);
      if (remainderResult != null) {
        remainderResult.add(num);
        memo.put(targetSum, remainderResult);
        return remainderResult;
      }
    }
    memo.put(targetSum, null);
    return null;
  }

  public static List<Integer> howSum(int targetSum, List<Integer> numbers) {
    HashMap<Integer, List<Integer>> memo = new HashMap<>();
    return howSum(targetSum, numbers, memo);
  }
}
