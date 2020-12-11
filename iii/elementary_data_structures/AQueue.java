package com.iii.elementary_data_structures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AQueue<T> {
  public List<T> items;
  public int head;
  public int tail;
  public int capacity;

  public AQueue() {
  }

  public AQueue(int capacity) {
    this.items = new ArrayList<>(Collections.nCopies(capacity, null));
    this.head = 0;
    this.tail = 0;
    this.capacity = capacity;
  }

  public boolean isEmpty() {
    if (this.head == this.tail)
      return true;
    return false;
  }

  public boolean isFull() {
    if (this.head == this.tail + 1)
      return true;
    if (this.head == 0 && this.tail == this.capacity - 1)
      return true;
    return false;
  }

  public void enqueue(T item) throws Exception {
    if (isFull())
      throw new Exception("queue is full");

    this.items.set(this.tail, item);
    if (this.tail == this.capacity - 1)
      this.tail = 0;
    else
      this.tail += 1;
  }

  public T dequeue() throws Exception {
    if (isEmpty())
      throw new Exception("queue is empty");

    T x = this.items.get(this.head);
    if (this.head == this.capacity - 1)
      this.head = 0;
    else
      this.head += 1;
    return x;
  }

  @Override
  public String toString() {
    return "{\n" + " items='" + items + "'" + "\n}";
  }
}