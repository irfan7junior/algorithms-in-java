package com.ii.medians_and_order_statistics;

import java.util.List;

public class Minimum {
  public static <T extends Comparable<? super T>> T minimum(List<T> list) {
    T minEl = list.get(0);
    for (T el : list)
      if (minEl.compareTo(el) > 0)
        minEl = el;
    return minEl;
  }
}
