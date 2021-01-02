package com.iv.knapsack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Knapsack {
  public int capacity;
  public List<KnapGold> sack;

  public Knapsack(int capacity) {
    this.sack = new ArrayList<>();
    this.capacity = capacity;
  }

  public void add(int weight, int cost) {
    KnapGold newGold = new KnapGold(weight, cost);
    sack.add(newGold);
  }

  public int knapsackMemo() {
    int[][] table = new int[this.sack.size() + 1][this.capacity + 1];
    for (int i = 1; i <= this.sack.size(); i++) {
      for (int j = 1; j <= this.capacity; j++) {
        if (j < this.sack.get(i - 1).weight) {
          table[i][j] = table[i - 1][j];
        } else {
          table[i][j] = Math.max(table[i - 1][j],
              table[i - 1][j - this.sack.get(i - 1).weight] + this.sack.get(i - 1).cost);
        }
      }
    }
    return table[this.sack.size()][this.capacity];
  }

  public int knapsackZeroOneRecursive() {
    int[][] memo = new int[this.sack.size() + 1][this.capacity + 1];
    for (int[] array : memo)
      Arrays.fill(array, Integer.MIN_VALUE);
    return knapsackZeroOneRecursive(this.sack, this.capacity, 0, memo);
  }

  public int knapsackZeroOneRecursive(List<KnapGold> list, int remainingWeight, int currentIndex) {
    if (currentIndex >= list.size() || remainingWeight == 0)
      return 0;
    int profitWith = 0;
    int profitWithout = 0;

    if (remainingWeight >= list.get(currentIndex).weight) {
      profitWith = knapsackZeroOneRecursive(list, remainingWeight - list.get(currentIndex).weight, currentIndex + 1)
          + list.get(currentIndex).cost;
    }
    profitWithout = knapsackZeroOneRecursive(list, remainingWeight, currentIndex + 1);

    return Math.max(profitWith, profitWithout);
  }

  public int knapsackZeroOneRecursive(List<KnapGold> list, int remainingWeight, int currentIndex, int[][] memo) {
    if (currentIndex >= list.size() || remainingWeight == 0)
      return 0;
    if (memo[currentIndex][remainingWeight] != Integer.MIN_VALUE)
      return memo[currentIndex][remainingWeight];

    int profitWith = 0;
    int profitWithout = 0;

    if (remainingWeight >= list.get(currentIndex).weight) {
      profitWith = knapsackZeroOneRecursive(list, remainingWeight - list.get(currentIndex).weight, currentIndex + 1)
          + list.get(currentIndex).cost;
    }
    profitWithout = knapsackZeroOneRecursive(list, remainingWeight, currentIndex + 1);

    int result = Math.max(profitWith, profitWithout);
    memo[currentIndex][remainingWeight] = result;
    return result;
  }

  @Override
  public String toString() {
    return "{" + " capacity='" + this.capacity + "'" + ", sack='" + this.sack + "'" + "}";
  }

}

class KnapGold implements Comparable<KnapGold> {
  public Integer weight;
  public Integer cost;
  public Double value;

  public KnapGold(int weight, int cost) {
    this.weight = weight;
    this.cost = cost;
    this.value = this.cost.doubleValue() / this.weight.doubleValue();
  }

  @Override
  public int compareTo(KnapGold other) {
    if (this.value < other.value)
      return -1;

    else if (this.value > other.value)
      return 1;
    else
      return 0;
  }

  @Override
  public String toString() {
    return "{" + " weight='" + this.weight + "'" + ", cost='" + this.cost + "'" + ", value='" + this.value + "'" + "}";
  }
}
