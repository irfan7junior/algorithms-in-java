package com.dynamic_programming.tabulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountConstructTab {
  public static Integer countConstruct(String target, List<String> wordBank) {
    List<Integer> table = new ArrayList<>(Collections.nCopies(target.length() + 1, 0));
    table.set(0, 1);

    for (int i = 0; i <= target.length(); i++) {
      if (table.get(i) != 0) {
        for (String word : wordBank) {
          if (target.substring(i).indexOf(word) == 0) {
            table.set(i + word.length(), table.get(i + word.length()) + table.get(i));
          }
        }
      }
    }

    return table.get(target.length());
  }
}
