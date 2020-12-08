package com.ii.lineartime.countingsort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountingSort {
  public static void countingSort(List<Integer> A, int exp) {
    int k = 9;

    // temporary output storage
    List<Integer> B = new ArrayList<>(Collections.nCopies(A.size(), null));

    // Initializing Count to zero
    List<Integer> Count = new ArrayList<>(Collections.nCopies(k + 1, 0));

    // Change Count so that it contains the number of occurence of a digit
    for (int i = 0; i < A.size(); i++) {
      int index = (A.get(i) / exp) % 10;
      Count.set(index, Count.get(index) + 1);
    }

    // Modifying Count so that it contains the position of a particular digit
    for (int i = 1; i <= k; i++)
      Count.set(i, Count.get(i) + Count.get(i - 1));

    for (int i = A.size() - 1; i >= 0; i--) {
      int index = (A.get(i) / exp) % 10;
      B.set(Count.get(index) - 1, A.get(i));
      Count.set(index, Count.get(index) - 1);
    }

    for (int i = 0; i < A.size(); i++)
      A.set(i, B.get(i));
  }
}
