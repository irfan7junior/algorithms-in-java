package com.ii.medians_and_order_statistics;

import java.util.List;

public class SecondMinimum {
  public static <T extends Comparable<? super T>> T secondMinimum(List<T> list) {
    T firstMin = list.get(0);
    T secondMin = null;

    for (int i = 1; i < list.size(); i++) {
      if (secondMin == null || list.get(i).compareTo(secondMin) < 0) {
        if (list.get(i).compareTo(firstMin) < 0)
          firstMin = list.get(i);
        else
          secondMin = list.get(i);
      }
    }

    return secondMin;
  }
}
