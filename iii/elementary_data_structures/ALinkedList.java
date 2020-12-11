package com.iii.elementary_data_structures;

class Node<T> {
  public T key;
  public Node<T> next;
  public Node<T> prev;

  public Node() {
  }

  public Node(T key) {
    this.key = key;
  }
}

public class ALinkedList<T> {
  public Node<T> head;

  public ALinkedList() {
    this.head = null;
  }

  public Node<T> search(T key) {
    Node<T> x = this.head;
    while (x != null && x.key != key)
      x = x.next;
    return x;
  }

  public void insert(T value) throws Exception {
    Node<T> node = new Node<>(value);
    insert(node);
  }

  public void insert(Node<T> node) throws Exception {
    if (node == null)
      throw new Exception("node is null");
    node.next = this.head;
    if (this.head != null)
      this.head.prev = node;
    this.head = node;
  }

  public void delete(Node<T> node) throws Exception {
    if (node == null)
      throw new Exception("node is null");
    if (node.prev != null)
      node.prev.next = node.next;
    else
      this.head = node.next;
    if (node.next != null)
      node.next.prev = node.prev;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    Node<T> x = this.head;
    sb.append("[ ");
    while (x != null) {
      sb.append(x.key);
      sb.append("->");
      x = x.next;
    }
    sb.append("null ]");
    return sb.toString();
  }

}
