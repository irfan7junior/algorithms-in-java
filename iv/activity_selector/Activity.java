package com.iv.activity_selector;

public class Activity implements Comparable<Activity> {
  public int startTime;
  public int endTime;
  public char name;

  public Activity(int startTime, int endTime, char name) {
    this.startTime = startTime;
    this.endTime = endTime;
    this.name = name;
  }

  @Override
  public int compareTo(Activity other) {
    return this.endTime - other.endTime;
  }

  @Override
  public String toString() {
    return "{" + " startTime='" + this.startTime + "'" + ", endTime='" + this.endTime + "'" + ", name='" + this.name
        + "'" + "}";
  }
}