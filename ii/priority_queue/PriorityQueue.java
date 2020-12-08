package com.ii.priority_queue;

import java.util.List;

import com.ii.heap.Heap;
import com.useful.Utility;

public class PriorityQueue {
  public Heap<Integer> heap;

  public PriorityQueue(List<Integer> items) {
    Heap<Integer> heap = new Heap<>(items);
    heap.build_max_heap();
  }

  public Integer heap_maximum() {
    return this.heap.items.get(0);
  }

  public Integer extract_max() {
    if (this.heap.heapSize < 0)
      throw new IndexOutOfBoundsException("heap size is 0");
    Integer max = this.heap.items.remove(0);
    this.heap.items.set(0, this.heap.items.get(this.heap.heapSize - 1));
    this.heap.heapSize -= 1;
    this.heap.max_heapify(0);
    return max;
  }

  public void heap_increase_key(int index, int key) throws Exception {
    if (key < this.heap.items.get(index))
      throw new Exception("new key is smaller than the current key");
    this.heap.items.set(index, key);
    while (index > 0 && this.heap.items.get(this.heap.parent(index)) < this.heap.items.get(index)) {
      Utility.swap(this.heap.items, index, this.heap.parent(index));
      index = this.heap.parent(index);
    }
  }

  public void max_heap_insert(int key) throws Exception {
    this.heap.heapSize += 1;
    this.heap.items.add(Integer.MIN_VALUE);
    this.heap_increase_key(this.heap.heapSize - 1, key);
  }
}
