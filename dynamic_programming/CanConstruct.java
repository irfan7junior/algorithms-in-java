package com.dynamic_programming;

import java.util.HashMap;
import java.util.List;

public class CanConstruct {
  public static boolean canConstruct(String target, List<String> wordBank) {
    HashMap<String, Boolean> memo = new HashMap<>();
    return canConstruct(target, wordBank, memo);
  }

  public static boolean canConstruct(String target, List<String> wordBank, HashMap<String, Boolean> memo) {
    if (memo.containsKey(target))
      return memo.get(target);

    if (target.compareTo("") == 0)
      return true;

    for (String word : wordBank) {
      if (target.indexOf(word) == 0) {
        String suffix = target.substring(word.length());
        if (canConstruct(suffix, wordBank, memo)) {
          memo.put(target, true);
          return true;
        }
      }
    }

    memo.put(target, false);
    return false;
  }
}
