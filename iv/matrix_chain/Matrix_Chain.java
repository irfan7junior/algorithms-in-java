package com.iv.matrix_chain;

import java.util.HashMap;

public class Matrix_Chain {
  public static int mcm_recursive(int[] matrices, int left, int right) {
    if (left == right)
      return 0;
    int minMuls = Integer.MAX_VALUE;
    for (int i = left; i < right; i++) {
      int curMuls = mcm_recursive(matrices, left, i) + mcm_recursive(matrices, i + 1, right)
          + matrices[left - 1] * matrices[i] * matrices[right];
      if (curMuls < minMuls)
        minMuls = curMuls;
    }
    return minMuls;
  }

  public static int mcm_recursive_memo(int[] matrices, int left, int right) {
    HashMap<String, Integer> memo = new HashMap<>();
    return mcm_recursive_memo(matrices, left, right, memo);
  }

  public static int mcm_recursive_memo(int[] matrices, int left, int right, HashMap<String, Integer> memo) {
    if (left == right)
      return 0;
    String key = Integer.valueOf(left).toString() + "," + Integer.valueOf(right).toString();
    if (memo.containsKey(key))
      return memo.get(key);

    int minMuls = Integer.MAX_VALUE;
    for (int i = left; i < right; i++) {
      int curMuls = mcm_recursive_memo(matrices, left, i, memo) + mcm_recursive_memo(matrices, i + 1, right, memo)
          + matrices[left - 1] * matrices[i] * matrices[right];
      if (curMuls < minMuls)
        minMuls = curMuls;
    }
    memo.put(key, minMuls);
    return minMuls;
  }

  public static int mcm_bt(int[] matrices) {
    int length = matrices.length - 1;
    int[][] memo = new int[length + 1][length + 1];
    int[][] optimalParams = new int[length + 1][length + 1];

    for (int l = 2; l <= length; l++) {
      for (int i = 1; i <= length - l + 1; i++) {
        int j = i + l - 1;
        memo[i][j] = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
          int currentMuls = memo[i][k] + memo[k + 1][j] + matrices[i - 1] * matrices[k] * matrices[j];
          if (currentMuls < memo[i][j]) {
            memo[i][j] = currentMuls;
            optimalParams[i][j] = k;
          }
        }
      }
    }

    // printOptimalParens(optimalParams, 1, length);
    // System.out.println();

    return memo[1][length];
  }

  public static void printOptimalParens(int[][] pop, int i, int j) {
    if (i == j) {
      System.out.printf("A%d", i);
    } else {
      System.out.printf("(");
      printOptimalParens(pop, i, pop[i][j]);
      printOptimalParens(pop, pop[i][j] + 1, j);
      System.out.printf(")");
    }
  }
}
