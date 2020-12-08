package com.ii.heapsort;

import java.util.List;

import com.ii.heap.Heap;
import com.useful.Utility;

public class HeapSort<T extends Comparable<? super T>> {
  public static void sort(List<Integer> list) {
    Heap<Integer> heap = new Heap<>(list);
    heap.build_max_heap();
    for (int i = heap.items.size() - 1; i > 0; i--) {
      Utility.swap(list, heap.heapSize - 1, 0);
      heap.heapSize -= 1;
      heap.max_heapify(0);
    }
  }
}
