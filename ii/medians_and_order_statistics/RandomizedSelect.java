package com.ii.medians_and_order_statistics;

import java.util.List;

import com.ii.quicksort.QuickSort;

public class RandomizedSelect {
  public static <T extends Comparable<? super T>> T randomizedSelect(List<T> list, int i) {
    return randomizedSelect(list, 0, list.size() - 1, i);
  }

  public static <T extends Comparable<? super T>> T randomizedSelect(List<T> list, int p, int r, int i) {
    // Only one element is left, return it
    if (p == r)
      return list.get(p);

    // partition the list around a random element
    int q = QuickSort.randomized_parition(list, p, r);

    // index of the parition element
    int k = q - p;

    // if the array[k] is the ith smallest element, return it
    if (i == k)
      return list.get(q);

    // if 'i' is less than 'k', continue our search in the left-hand side
    else if (i < k)
      return randomizedSelect(list, p, q - 1, i);

    // if 'i' is greater than 'k', continue our search in the right-hand side
    else
      return randomizedSelect(list, q + 1, r, i - k - 1);
  }
}
