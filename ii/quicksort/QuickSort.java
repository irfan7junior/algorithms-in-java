package com.ii.quicksort;

import java.util.List;

import com.useful.Utility;

public class QuickSort {
  public static <T extends Comparable<? super T>> int parition(List<T> list, int p, int r) {
    T x = list.get(r);
    int i = p - 1;
    for (int j = p; j < r; j++) {
      if (list.get(j).compareTo(x) < 0 || list.get(j).compareTo(x) == 0) {
        i += 1;
        Utility.swap(list, i, j);
      }
    }
    Utility.swap(list, i + 1, r);
    return i + 1;
  }

  public static <T extends Comparable<? super T>> void quicksort(List<T> list, int low, int high) {
    if (low < high) {
      int q = randomized_parition(list, low, high);
      quicksort(list, low, q - 1);
      quicksort(list, q + 1, high);
    }
  }

  public static <T extends Comparable<? super T>> int randomized_parition(List<T> list, int low, int high) {
    int rand_value = Utility.random(low, high);
    Utility.swap(list, rand_value, high);
    return parition(list, low, high);
  }
}
