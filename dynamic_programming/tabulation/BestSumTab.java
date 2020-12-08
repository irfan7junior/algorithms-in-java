package com.dynamic_programming.tabulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BestSumTab {
  public static List<Integer> bestSum(int targetSum, List<Integer> numbers) {
    List<List<Integer>> table = new ArrayList<>(Collections.nCopies(targetSum + 1, null));
    table.set(0, new ArrayList<>());

    for (int i = 0; i <= targetSum; i++) {
      if (table.get(i) != null) {
        for (int num : numbers) {
          if (i + num > targetSum)
            continue;

          List<Integer> combination = new ArrayList<>();
          for (int el : table.get(i))
            combination.add(el);
          combination.add(num);

          if (table.get(i + num) == null || table.get(i + num).size() > combination.size())
            table.set(i + num, combination);
        }
      }
    }

    return table.get(targetSum);
  }
}
