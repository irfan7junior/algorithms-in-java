package com.dynamic_programming.tabulation;

import java.util.List;

public class CanSumTab {
  public static boolean canSum(int targetSum, List<Integer> numbers) {
    boolean[] table = new boolean[targetSum + 1];
    table[0] = true;

    for (int i = 0; i <= targetSum; i++) {
      if (table[i] == true) {
        for (int num : numbers) {
          if (i + num <= targetSum)
            table[i + num] = true;
        }
      }
    }

    return table[targetSum];
  }
}
