package com.ii.medians_and_order_statistics;

import java.util.List;

import com.useful.Pair;

public class MinimumMaximum {
  public static <T extends Comparable<? super T>> Pair<T> minMax(List<T> list) {
    Pair<T> pair = new Pair<>();

    Boolean isOdd = list.size() % 2 != 0;

    if (isOdd) {
      pair.setMinEl(list.get(0));
      pair.setMaxEl(list.get(0));
    } else {
      if (list.get(0).compareTo(list.get(1)) < 0) {
        pair.setMinEl(list.get(0));
        pair.setMaxEl(list.get(1));
      } else {
        pair.setMinEl(list.get(1));
        pair.setMaxEl(list.get(0));
      }
    }

    int startIndex = isOdd ? 1 : 2;
    for (int i = startIndex; i < list.size(); i += 2) {
      if (list.get(i).compareTo(list.get(i + 1)) < 0) {
        if (pair.getMinEl().compareTo(list.get(i)) > 0) {
          pair.setMinEl(list.get(i));
        }
        if (pair.getMaxEl().compareTo(list.get(i + 1)) < 0) {
          pair.setMaxEl(list.get(i + 1));
        }
      } else {
        if (pair.getMinEl().compareTo(list.get(i + 1)) > 0) {
          pair.setMinEl(list.get(i + 1));
        }
        if (pair.getMaxEl().compareTo(list.get(i)) < 0) {
          pair.setMaxEl(list.get(i));
        }
      }
    }

    return pair;
  }
}
