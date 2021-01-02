package com.iv.knapsack;

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