package com.ii.heap;

import java.util.List;

import com.useful.Utility;

public class Heap<T extends Comparable<? super T>> {
  public List<T> items;
  public int heapSize;

  public Heap(List<T> items) {
    this.items = items;
    this.heapSize = 0;
  }

  public int parent(int index) {
    int answer = (index - 1) / 2;
    // if (answer < 0 || answer >= this.items.size())
    // throw new IndexOutOfBoundsException();
    return answer;
  }

  public int left(int index) {
    int answer = (index * 2) + 1;
    // if (answer < 0 || answer >= this.items.size())
    // throw new IndexOutOfBoundsException();
    return answer;
  }

  public int right(int index) {
    int answer = (index * 2) + 2;
    // if (answer < 0 || answer >= this.items.size())
    // throw new IndexOutOfBoundsException();
    return answer;
  }

  public void max_heapify(int index) {
    int l = this.left(index);
    int r = this.right(index);
    int largest;

    if (l < this.heapSize && this.items.get(l).compareTo(this.items.get(index)) > 0) {
      largest = l;
    } else {
      largest = index;
    }

    if (r < this.heapSize && this.items.get(r).compareTo(this.items.get(largest)) > 0) {
      largest = r;
    }

    if (largest != index) {
      Utility.swap(this.items, largest, index);
      this.max_heapify(largest);
    }
  }

  public void build_max_heap() {
    this.heapSize = this.items.size();
    for (int i = (this.heapSize - 1) / 2; i >= 0; i--) {
      this.max_heapify(i);
    }
  }
}
