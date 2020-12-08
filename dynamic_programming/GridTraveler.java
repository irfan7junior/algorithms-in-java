package com.dynamic_programming;

import java.util.HashMap;

public class GridTraveler {
  public static HashMap<String, Integer> memo = new HashMap<>();

  public static int getPaths(int rows, int cols) {
    String key = String.valueOf(rows) + "," + String.valueOf(cols);
    if (memo.containsKey(key))
      return memo.get(key);
    if (rows == 1 && cols == 1)
      return 1;
    if (rows == 0 || cols == 0)
      return 0;
    memo.put(key, getPaths(rows - 1, cols) + getPaths(rows, cols - 1));
    return memo.get(key);
  }
}