package com.ii.lineartime;

import java.util.Collections;
import java.util.List;

import com.ii.lineartime.countingsort.CountingSort;

public class RadixSort {
  public static void radixSort(List<Integer> array) {
    int maxNum = Collections.max(array);
    int exp = 1;
    while (maxNum > 0) {
      CountingSort.countingSort(array, exp);
      exp *= 10;
      maxNum /= exp;
    }
  }
}
