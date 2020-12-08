package com.i.sorts_and_search;

import java.util.ArrayList;
import java.util.List;

public class SortsSearches {

  public static <T> void swap(int pos1, int pos2, List<T> list) {
    T temp = list.get(pos1);
    list.set(pos1, list.get(pos2));
    list.set(pos2, temp);
  }

  public static <T extends Comparable<? super T>> int binary_search(List<T> list, T key) {
    int low = 0;
    int high = list.size() - 1;
    int mid = (low + high) / 2;
    while (low <= high) {
      if (list.get(mid).compareTo(key) == 0)
        return mid;
      else if (list.get(mid).compareTo(key) > 0) {
        high = mid - 1;
        mid = (low + high) / 2;
      } else {
        low = mid + 1;
        mid = (low + high) / 2;
      }
    }
    return -1;
  }

  public static <T extends Comparable<? super T>> void bubble_sort(List<T> list) {
    for (int i = 0; i < list.size(); i++) {
      for (int j = list.size() - 1; j > i; j--) {
        if (list.get(j).compareTo(list.get(j - 1)) < 0) {
          swap(j, j - 1, list);
        }
      }
    }
  }

  public static <T extends Comparable<? super T>> void insertion_sort(List<T> list) {
    for (int i = 1; i < list.size(); i++) {
      T key = list.get(i);
      int j = i - 1;
      while (j >= 0 && key.compareTo(list.get(j)) < 0) {
        list.set(j + 1, list.get(j));
        j--;
      }
      list.set(j + 1, key);
    }
  }

  public static <T extends Comparable<? super T>> int linear_search(List<T> list, T key) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).compareTo(key) == 0)
        return i;
    }
    return -1;
  }

  public static <T extends Comparable<? super T>> void merge(List<T> list, int p, int q, int r) {
    int n1 = q - p + 1;
    int n2 = r - q;

    List<T> L = new ArrayList<T>(n1);
    List<T> R = new ArrayList<T>(n2);

    for (int i = 0; i < n1; i++)
      L.add(list.get(i + p));

    for (int i = 0; i < n2; i++)
      R.add(list.get(q + 1 + i));

    int k = p, i = 0, j = 0;
    while (i < n1 && j < n2) {
      if (L.get(i).compareTo(R.get(j)) < 0) {
        list.set(k, L.get(i));
        i++;
        k++;
      } else {
        list.set(k, R.get(j));
        j++;
        k++;
      }
    }
    while (i < n1) {
      list.set(k, L.get(i));
      i++;
      k++;
    }
    while (j < n2) {
      list.set(k, R.get(j));
      j++;
      k++;
    }
  }

  public static <T extends Comparable<? super T>> void merge_sort(List<T> list, int low, int high) {
    if (low < high) {
      int mid = (low + high) / 2;
      merge_sort(list, low, mid);
      merge_sort(list, mid + 1, high);
      merge(list, low, mid, high);
    }
  }

  public static <T extends Comparable<? super T>> void selection_sort(List<T> list) {
    for (int i = 0; i < list.size(); i++) {
      int minIndex = i;
      for (int j = i + 1; j < list.size(); j++) {
        if (list.get(j).compareTo(list.get(minIndex)) < 0) {
          minIndex = j;
        }
        if (i != minIndex)
          swap(i, minIndex, list);
      }
    }
  }
}
