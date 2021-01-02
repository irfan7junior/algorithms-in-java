package com.iv.activity_selector;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ActivitySelector {
  public static Set<Activity> greedy_activity_selector(List<Activity> list) {
    Set<Activity> result = new HashSet<>();
    Collections.sort(list);

    result.add(list.get(0));
    int current = 0;
    for (int i = 1; i < list.size(); i++) {
      if (list.get(i).startTime >= list.get(current).endTime) {
        result.add(list.get(i));
        current = i;
      }
    }

    return result;
  }
}