package com.ii.lineartime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.i.sorts_and_search.SortsSearches;

public class BucketSort {
  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    bucketSort(list);
  }

  public static int countLength(int number) {
    int count = 0;
    while (number != 0) {
      count++;
      number /= 10;
    }
    return count;
  }

  public static void bucketSort(List<Integer> array) {
    // getting the length of the max element in the array
    int length = countLength(Collections.max(array));

    // converting all the values of the array to a double
    List<Double> A = new ArrayList<>(Arrays.asList(new Double[array.size()]));
    for (int i = 0; i < A.size(); i++) {
      Double value = (Double.valueOf(array.get(i)) / Math.pow(10, length));
      A.set(i, value);
    }

    // creating the list of list of floats
    List<List<Double>> B = new ArrayList<>();
    for (int i = 0; i < array.size(); i++)
      B.add(new ArrayList<>());

    // filling in the values in the list of list of floats
    for (int i = 0; i < A.size(); i++) {
      int index = (int) (Math.floor(A.get(i) * A.size()));
      B.get(index).add(A.get(i));
    }

    // sorting each list in the list of list of floats using insertion sort
    for (int i = 0; i < B.size(); i++)
      SortsSearches.insertion_sort(B.get(i));

    // storing back all the values from B to A
    int k = 0;
    for (int i = 0; i < B.size(); i++) {
      for (int j = 0; j < B.get(i).size(); j++)
        array.set(k++, (int) (B.get(i).get(j) * Math.pow(10, length)));
    }
  }
}
