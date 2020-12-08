package com.i.divide_and_conquer;

public class ResultSubarray {
  public int left;
  public int right;
  public int sum;

  public ResultSubarray(int left, int right, int sum) {
    this.left = left;
    this.right = right;
    this.sum = sum;
  }

  public ResultSubarray() {
    this.left = -1;
    this.right = -1;
    this.sum = Integer.MIN_VALUE;
  }

  @Override
  public String toString() {
    return "{" + " left='" + left + "'" + ", right='" + right + "'" + ", sum='" + sum + "'" + "}";
  }
}
