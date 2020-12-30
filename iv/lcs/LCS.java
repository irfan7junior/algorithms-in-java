package com.iv.lcs;

import java.util.Arrays;

public class LCS {
  public static int lcs_recursive(char[] string1, char[] string2, int i, int j) {
    if (i < 0 || j < 0)
      return 0;
    if (string1[i] == string2[j])
      return lcs_recursive(string1, string2, i - 1, j - 1) + 1;
    return Math.max(lcs_recursive(string1, string2, i, j - 1), lcs_recursive(string1, string2, i - 1, j));
  }

  public static int lcs_recursive_memo(char[] str1, char[] str2) {
    int[][] memo = new int[str1.length + 1][str2.length + 1];
    for (int[] array : memo)
      Arrays.fill(array, Integer.MAX_VALUE);
    return lcs_recursive_memo(str1, str2, str1.length - 1, str2.length - 1, memo);
  }

  public static int lcs_recursive_memo(char[] str1, char[] str2, int i, int j, int[][] memo) {
    if (i < 0 || j < 0)
      return 0;
    if (memo[i][j] != Integer.MAX_VALUE)
      return memo[i][j];
    int result;
    if (str1[i] == str2[j])
      result = lcs_recursive_memo(str1, str2, i - 1, j - 1, memo) + 1;
    else
      result = Math.max(lcs_recursive_memo(str1, str2, i, j - 1, memo), lcs_recursive_memo(str1, str2, i - 1, j, memo));
    memo[i][j] = result;
    return result;
  }

  public static int lcs_bt(char[] str1, char[] str2) {
    int[][] memo = new int[str1.length + 1][str2.length + 1];
    char[][] table = new char[str1.length + 1][str2.length + 1];
    for (int i = 1; i <= str1.length; i++) {
      for (int j = 1; j <= str2.length; j++) {
        if (str1[i - 1] == str2[j - 1]) {
          memo[i][j] = memo[i - 1][j - 1] + 1;
          table[i][j] = 'D';
        } else if (memo[i - 1][j] >= memo[i][j - 1]) {
          memo[i][j] = memo[i - 1][j];
          table[i][j] = 'T';
        } else {
          memo[i][j] = memo[i][j - 1];
          table[i][j] = 'L';
        }
      }
    }
    print_lcs(str1, str2, table, str1.length, str2.length);
    System.out.println();
    return memo[str1.length][str2.length];
  }

  public static void print_lcs(char[] str1, char[] str2, char[][] table, int i, int j) {
    if (i == 0 || j == 0)
      return;
    if (table[i][j] == 'D') {
      print_lcs(str1, str2, table, i - 1, j - 1);
      System.out.printf("%c", str1[i]);
    } else if (table[i][j] == 'L')
      print_lcs(str1, str2, table, i, j - 1);
    else
      print_lcs(str1, str2, table, i - 1, j);
  }
}
