package com.dynamic_programming;

import java.util.HashMap;
import java.util.List;

public class CountConstruct {
  public static Integer countConstruct(String target, List<String> wordBank) {
    HashMap<String, Integer> memo = new HashMap<>();
    return countConstruct(target, wordBank, memo);
  }

  public static Integer countConstruct(String target, List<String> wordBank, HashMap<String, Integer> memo) {
    if (memo.containsKey(target))
      return memo.get(target);

    if (target.compareTo("") == 0)
      return 1;

    int totalCount = 0;

    for (String word : wordBank) {
      if (target.indexOf(word) == 0) {
        int numWaysForRest = countConstruct(target.substring(word.length()), wordBank, memo);
        totalCount += numWaysForRest;
      }
    }

    memo.put(target, totalCount);
    return totalCount;
  }
}
