package com.dynamic_programming;

import java.util.HashMap;

public class Fib {
  public static HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();

  public static int fib(int num) {
    if (memo.containsKey(num)) {
      return memo.get(num);
    }
    if (num <= 1)
      return num;
    memo.put(num, fib(num - 1) + fib(num - 2));
    return memo.get(num);
  }
}
