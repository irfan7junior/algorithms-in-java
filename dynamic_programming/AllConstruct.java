package com.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AllConstruct {
  public static List<List<String>> allConstruct(String target, List<String> wordBank) {
    HashMap<String, List<List<String>>> memo = new HashMap<>();
    return allConstruct(target, wordBank, memo);
  }

  public static List<List<String>> allConstruct(String target, List<String> wordBank,
      HashMap<String, List<List<String>>> memo) {
    if (memo.containsKey(target))
      return memo.get(target);

    if (target.compareTo("") == 0) {
      return new ArrayList<>(Arrays.asList(new ArrayList<>()));
    }

    List<List<String>> result = new ArrayList<>();

    for (String word : wordBank) {

      if (target.indexOf(word) == 0) {
        String suffix = target.substring(word.length());

        List<List<String>> suffixWays = allConstruct(suffix, wordBank, memo);
        List<List<String>> targetWays = new ArrayList<>();

        for (int i = 0; i < suffixWays.size(); i++) {
          List<String> temp = new ArrayList<>(suffixWays.get(i));
          temp.add(word);
          targetWays.add(temp);
        }

        for (int i = 0; i < targetWays.size(); i++) {
          result.add(new ArrayList<>(targetWays.get(i)));
        }

      }
    }

    memo.put(target, result);
    return result;
  }
}
