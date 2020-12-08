package com.dynamic_programming.tabulation;

public class GridTravelerTab {
  public static int gridTraveler(int rows, int cols) {
    int[][] table = new int[rows + 1][cols + 1];

    table[1][1] = 1;

    for (int i = 0; i <= rows; i++) {
      for (int j = 0; j <= cols; j++) {
        int current = table[i][j];
        if (j + 1 <= cols)
          table[i][j + 1] += current;
        if (i + 1 <= rows)
          table[i + 1][j] += current;
      }
    }

    return table[rows][cols];
  }
}
