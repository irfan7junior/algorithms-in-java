package com.dynamic_programming.tabulation;

public class FibTab {
  public static int fib(int target) {
    int[] table = new int[target + 1];
    table[0] = 0;
    table[1] = 1;

    for (int i = 2; i <= target; i++)
      table[i] = table[i - 1] + table[i - 2];

    return table[target];

  }
}
