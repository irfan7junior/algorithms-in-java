package com.iii.elementary_data_structures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class AStack<T> {
  public List<T> items;
  public int top;
  public int capacity;

  public AStack() {
  }

  public AStack(int capacity) {
    this.items = new ArrayList<>(Collections.nCopies(capacity, null));
    this.top = -1;
    this.capacity = capacity;
  }

  public boolean isEmpty() {
    if (this.top == -1)
      return true;
    return false;
  }

  public boolean isFull() {
    if (this.top + 1 == this.capacity)
      return true;
    return false;
  }

  public void push(T item) throws Exception {
    if (isFull())
      throw new Exception("stack is full");

    this.top += 1;
    this.items.set(this.top, item);
  }

  public T pop() throws Exception {
    if (isEmpty())
      throw new Exception("stack is empty");

    this.top -= 1;
    return this.items.get(this.top + 1);
  }

  private List<T> getItems() {
    return this.items;
  }

  @Override
  @SuppressWarnings("unchecked")
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof AStack)) {
      return false;
    }
    AStack<T> aStack = (AStack<T>) o;
    return Objects.equals(items, aStack.items) && top == aStack.top && capacity == aStack.capacity;
  }

  @Override
  public int hashCode() {
    return Objects.hash(items, top, capacity);
  }

  @Override
  public String toString() {
    return "{\n" + " items='" + getItems() + "'" + "\n}";
  }

}
