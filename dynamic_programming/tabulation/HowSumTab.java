package com.dynamic_programming.tabulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HowSumTab {
  public static List<Integer> howSum(int targetSum, List<Integer> numbers) {
    List<List<Integer>> table = new ArrayList<>(Collections.nCopies(targetSum + 1, null));
    table.set(0, new ArrayList<>());

    for (int i = 0; i <= targetSum; i++) {
      if (table.get(i) == null)
        continue;
      for (int num : numbers) {
        if (i + num > targetSum)
          continue;
        table.set(i + num, new ArrayList<>(table.get(i)));
        table.get(i + num).add(num);
      }
    }

    return table.get(targetSum);
  }
}
