package com.iv.knapsack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

  public int fractionKS() {
    List<KnapGold> list = new ArrayList<>(this.sack);
    Collections.sort(list, Collections.reverseOrder());

    int remainingWeight = this.capacity;
    int result = 0;
    int i = 0;
    while (remainingWeight > 0) {
      if (list.get(i).weight <= remainingWeight) {
        result += list.get(i).cost;
        remainingWeight -= list.get(i).weight;
      } else {
        result += (list.get(i).value * remainingWeight);
        remainingWeight = 0;
      }
      i++;
    }

    return result;
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
