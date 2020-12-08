package com.ii.medians_and_order_statistics;

import java.util.List;

public class Maximum {
  public static <T extends Comparable<? super T>> T maximum(List<T> list) {
    T maxEl = list.get(0);
    for (T num : list) {
      if (maxEl.compareTo(num) < 0)
        maxEl = num;
    }
    return maxEl;
  }
}
