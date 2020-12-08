package com.useful;

import java.util.ArrayList;
import java.util.List;

public class Utility {
  public static <T extends Comparable<? super T>> void swap(List<T> list, int pos1, int pos2) {
    T temp = list.get(pos1);
    list.set(pos1, list.get(pos2));
    list.set(pos2, temp);
  }

  public static int random(int low, int high) {
    return (int) (Math.random() * (high - low + 1) + low);
  }

  public static <T> void fill2d(List<List<T>> list, T value, int rows, int cols) {
    while (list.size() < rows)
      list.add(new ArrayList<>());

    for (int i = 0; i < rows; i++) {
      list.get(i).clear();
      for (int j = 0; j < cols; j++) {
        if (list.get(i).size() < j)
          list.get(i).set(j, value);
        else
          list.get(i).add(value);
      }
    }
  }
}
