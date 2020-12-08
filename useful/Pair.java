package com.useful;

import java.util.Objects;

public class Pair<T extends Comparable<? super T>> {
  public T minEl;
  public T maxEl;

  public Pair() {
  }

  public Pair(T minEl, T maxEl) {
    this.minEl = minEl;
    this.maxEl = maxEl;
  }

  public T getMinEl() {
    return this.minEl;
  }

  public void setMinEl(T minEl) {
    this.minEl = minEl;
  }

  public T getMaxEl() {
    return this.maxEl;
  }

  public void setMaxEl(T maxEl) {
    this.maxEl = maxEl;
  }

  public Pair<T> minEl(T minEl) {
    this.minEl = minEl;
    return this;
  }

  public Pair<T> maxEl(T maxEl) {
    this.maxEl = maxEl;
    return this;
  }

  @Override
  public int hashCode() {
    return Objects.hash(minEl, maxEl);
  }

  @Override
  public String toString() {
    return "{" + " minEl='" + getMinEl() + "'" + ", maxEl='" + getMaxEl() + "'" + "}";
  }
}