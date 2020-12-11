package com.iii.binary_serach_tree;

import java.util.Stack;

class Node<T> {
  public T key;
  public Node<T> left;
  public Node<T> right;
  public Node<T> parent;

  public Node(T key) {
    this.key = key;
  }

  public static <T> Node<T> createNode(T key) {
    return new Node<>(key);
  }

  public String toString() {
    return this.key.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Node)) {
      return false;
    }
    return false;
  }

}

public class BST<T extends Comparable<? super T>> {
  public Node<T> root;

  public BST() {
  }

  public void insert(T key) {
    Node<T> node = new Node<>(key);

    Node<T> current = this.root;
    Node<T> parent = null;

    while (current != null) {
      parent = current;
      if (key.compareTo(current.key) < 0)
        current = current.left;
      else
        current = current.right;
    }

    if (parent == null) {
      this.root = node;
      return;
    }

    if (key.compareTo(parent.key) < 0) {
      parent.left = node;
      node.parent = parent;
    } else {
      parent.right = node;
      node.parent = parent;
    }

  }

  public String inOrder() {
    StringBuilder sb = new StringBuilder();
    inOrder(this.root, sb);
    if (sb.length() > 2)
      sb.delete(sb.length() - 2, sb.length());
    return sb.toString();
  }

  public void inOrder(Node<T> node, StringBuilder sb) {
    if (node == null)
      return;
    inOrder(node.left, sb);
    sb.append(node.key + "->");
    inOrder(node.right, sb);
  }

  public String preOrder() {
    StringBuilder sb = new StringBuilder();
    preOrder(this.root, sb);
    if (sb.length() > 2)
      sb.delete(sb.length() - 2, sb.length());
    return sb.toString();
  }

  public void preOrder(Node<T> node, StringBuilder sb) {
    if (node == null)
      return;
    sb.append(node.key + "->");
    preOrder(node.left, sb);
    preOrder(node.right, sb);
  }

  public String postOrder() {
    StringBuilder sb = new StringBuilder();
    postOrder(this.root, sb);
    if (sb.length() > 2)
      sb.delete(sb.length() - 2, sb.length());
    return sb.toString();
  }

  public void postOrder(Node<T> node, StringBuilder sb) {
    if (node == null)
      return;
    postOrder(node.left, sb);
    postOrder(node.right, sb);
    sb.append(node.key + "->");
  }

  public String inOrderIterative() {
    Node<T> current = this.root;
    boolean done = false;
    Stack<Node<T>> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();

    while (done == false) {
      if (current != null) {
        stack.push(current);
        current = current.left;
      } else {
        if (stack.isEmpty() == false) {
          current = stack.pop();
          sb.append(current.key + "->");
          current = current.right;
        } else
          done = true;
      }
    }
    if (sb.length() > 2)
      sb.delete(sb.length() - 2, sb.length());
    return sb.toString();
  }

  public String preOrderIterative() {
    StringBuilder sb = new StringBuilder();
    Stack<Node<T>> stack = new Stack<>();

    Node<T> current = null;
    stack.push(this.root);

    while (stack.isEmpty() == false) {
      current = stack.pop();
      sb.append(current.key + "->");
      if (current.right != null)
        stack.push(current.right);
      if (current.left != null)
        stack.push(current.left);
    }

    if (sb.length() > 2)
      sb.delete(sb.length() - 2, sb.length());
    return sb.toString();
  }

  public String postOrderIterative() {
    StringBuilder sb = new StringBuilder();
    Stack<Node<T>> stack1 = new Stack<>();
    Stack<Node<T>> stack2 = new Stack<>();
    Node<T> current = null;

    stack1.push(this.root);
    while (stack1.isEmpty() == false) {
      current = stack1.pop();
      stack2.push(current);

      if (current.left != null)
        stack1.push(current.left);
      if (current.right != null)
        stack1.push(current.right);
    }

    while (stack2.isEmpty() == false) {
      current = stack2.pop();
      sb.append(current.key + "->");
    }

    if (sb.length() > 2)
      sb.delete(sb.length() - 2, sb.length());
    return sb.toString();
  }

  public Node<T> searchIterative(T key) {
    Node<T> current = this.root;
    while (current.key.compareTo(key) != 0 && current != null) {
      if (key.compareTo(current.key) < 0)
        current = current.left;
      else
        current = current.right;
    }
    return current;
  }

  public void transplant(Node<T> u, Node<T> v) {
    if (u.parent == null)
      this.root = v;
    else if (u == u.parent.left) {
      u.parent.left = v;
    } else {
      u.parent.right = v;
    }
    if (v != null)
      v.parent = u.parent;
  }

  public void delete(T key) {
    Node<T> node = searchIterative(key);
    if (node == null)
      return;
    if (node.left == null)
      transplant(node, node.right);
    if (node.right == null)
      transplant(node, node.left);
    else {
      Node<T> y = minimum(node.right);
      if (y.parent != node) {
        transplant(y, y.right);
        y.right = node.right;
        y.right.parent = y;
      }
      transplant(node, y);
      y.left = node.left;
      y.left.parent = y;
    }
  }

  public Node<T> minimum(Node<T> current) {
    while (current.left != null)
      current = current.left;
    return current;
  }

  public Node<T> maximum(Node<T> current) {
    while (current.right != null)
      current = current.right;
    return current;
  }

}
