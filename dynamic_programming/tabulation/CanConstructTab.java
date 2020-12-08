package com.dynamic_programming.tabulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CanConstructTab {
  public static boolean canConstruct(String target, List<String> wordBank) {
    List<Boolean> table = new ArrayList<>(Collections.nCopies(target.length() + 1, false));
    table.set(0, true);

    for (int i = 0; i <= target.length(); i++) {
      if (table.get(i)) {
        for (String word : wordBank) {
          if (target.substring(i).indexOf(word) == 0) {
            table.set(i + word.length(), true);
          }
        }
      }
    }

    return table.get(target.length());
  }
}
