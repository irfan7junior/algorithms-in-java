package com.i.divide_and_conquer;

import java.util.List;

public class Maximum_Subarray {
  public static ResultSubarray find_max_crossing_subarray(List<Integer> list, int low, int mid, int high) {
    int sum;

    int left_sum = Integer.MIN_VALUE;
    sum = 0;
    int max_left = -1;
    for (int i = mid; i >= low; i--) {
      sum += list.get(i);
      if (sum > left_sum) {
        left_sum = sum;
        max_left = i;
      }
    }

    int right_sum = Integer.MIN_VALUE;
    sum = 0;
    int max_right = -1;
    for (int i = mid + 1; i <= high; i++) {
      sum += list.get(i);
      if (sum > right_sum) {
        right_sum = sum;
        max_right = i;
      }
    }

    return new ResultSubarray(max_left, max_right, left_sum + right_sum);
  }

  public static ResultSubarray find_max_subarray(List<Integer> list, int low, int high) {
    if (high == low)
      return new ResultSubarray(low, high, list.get(low));
    int mid = (low + high) / 2;

    ResultSubarray left = find_max_subarray(list, low, mid);
    ResultSubarray right = find_max_subarray(list, mid + 1, high);
    ResultSubarray crossing = find_max_crossing_subarray(list, low, mid, high);

    if (left.sum >= right.sum && left.sum >= crossing.sum)
      return left;
    else if (right.sum >= left.sum && right.sum >= crossing.sum)
      return right;
    return crossing;
  }
}