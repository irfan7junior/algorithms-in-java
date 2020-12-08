package com.dynamic_programming;

import java.util.HashMap;
import java.util.List;

public class CanSum {
  public static boolean canSum(int targetSum, List<Integer> numbers) {
    HashMap<Integer, Boolean> memo = new HashMap<>();
    return canSum(targetSum, numbers, memo);
  }

  public static boolean canSum(int targetSum, List<Integer> numbers, HashMap<Integer, Boolean> memo) {
    if (memo.containsKey(targetSum))
      return memo.get(targetSum);
    if (targetSum == 0)
      return true;
    if (targetSum < 0)
      return false;

    for (Integer num : numbers) {
      int remainder = targetSum - num;
      if (canSum(remainder, numbers, memo)) {
        memo.put(targetSum, true);
        return true;
      }
    }
    memo.put(targetSum, false);
    return false;
  }
}
