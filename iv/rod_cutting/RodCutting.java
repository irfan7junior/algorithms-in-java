package com.iv.rod_cutting;

import java.util.Arrays;

public class RodCutting {
  public static int rodCuttingRecursive(int[] prices, int length) {
    if (length == 0)
      return 0;
    int maxPrice = Integer.MIN_VALUE;
    for (int i = 1; i <= length; i++) {
      maxPrice = Math.max(maxPrice, prices[i - 1] + rodCuttingRecursive(prices, length - i));
    }
    return maxPrice;
  }

  public static int rodCuttingRecursiveMemo(int[] prices, int length) {
    int[] memo = new int[length + 1];
    Arrays.fill(memo, -1);
    return rodCuttingRecursiveMemo(prices, length, memo);
  }

  public static int rodCuttingRecursiveMemo(int[] prices, int length, int[] memo) {
    if (length == 0)
      return 0;
    if (memo[length] != -1)
      return memo[length];
    int maxPrice = Integer.MIN_VALUE;
    for (int i = 1; i <= length; i++)
      maxPrice = Math.max(maxPrice, prices[i - 1] + rodCuttingRecursiveMemo(prices, length - i, memo));
    memo[length] = maxPrice;
    return maxPrice;
  }

  public static int rodCuttingTopDown(int[] prices, int length) {
    int[] memo = new int[length + 1];
    for (int i = 1; i <= length; i++) {
      int maxPrice = Integer.MIN_VALUE;
      for (int j = 1; j <= i; j++) {
        maxPrice = Math.max(maxPrice, prices[j - 1] + memo[i - j]);
      }
      memo[i] = maxPrice;
    }
    return memo[length];
  }

  public static void rodCuttingPrint(int[] prices, int length) {
    int[] memo = new int[length + 1];
    int[] print = new int[length + 1];
    for (int i = 1; i <= length; i++) {
      int maxPrice = Integer.MIN_VALUE;
      for (int j = 1; j <= i; j++) {
        if (maxPrice < prices[j - 1] + memo[i - j]) {
          maxPrice = prices[j - 1] + memo[i - j];
          print[i] = j;
        }
      }
      memo[i] = maxPrice;
    }
    System.out.println(memo[length]);
    while (length > 0) {
      System.out.println("Size: " + print[length]);
      length -= print[length];
    }
  }
}