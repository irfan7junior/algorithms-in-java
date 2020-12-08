# An Intro to Dynamic Programming

---

# Memoization Recipe

- **Make it work.**
  - visualize the problem
  - implement the tree using recursion
  - test it
- **Make it efficient.**
  - add a mem object
  - add a base case to return memo values
  - store return values into the memo

---

# Fibonacci Problem

![images/Untitled.png](images/Untitled.png)

```java
package com.dynamic_programming;
import java.util.HashMap;

public class Fib {
	public static HashMap<Integer, Integer> memo = new HashMap<>();
	public static int fib(int num) {
		if (memo.containsKey(num)) return memo.get(num);
		if (num <= 1) return num;
		int put = memo.put(num, fib(num - 1) + fib(num - 2));
		return put;
	}
}
```

---

# GridTraveler Problem

![images/Untitled%201.png](images/Untitled%201.png)

```java
package com.dynamic_programming;
import java.util.HashMap;

public class GridTraveler {
	public static HashMap<String, Integer> memo = new HashMap<String, Integer>();
	public static getPaths(int rows, int cols) {
		String key = String.parse(rows) + "," + String.parse(cols);
		if (memo.containsKey(key)) return memo.get(key);
		if (rows == 1 && cols == 1) return 1;
		if (rows == 0 || cols == 0) return 0;
		put = memo.put(key, getPaths(rows - 1, cols) + getPaths(rows, cols - 1));
		return put;
	}
}
```

---

# canSum

- Write a function `canSum(targetSum, numbers)` that takes in a `targetSum` and an array of numbers as arguments.
- The function should return a boolean indicating whether or not it is possible to generate the `targetSum` using numbers from the array.
- You may use an element of the array as many times as needed.
- You may assume that all input numbers are non-negative.

![images/Untitled%202.png](images/Untitled%202.png)

```java
package com.dynamic_programming;

import java.util.HashMap;
import java.util.List;

public class CanSum {
  public static boolean canSum(int targetSum, List<Integer> numbers) {
    HashMap<Integer, Boolean> memo = new HashMap<>();
    return canSum(targetSum, numbers, memo);
  }

  public static boolean canSum(int targetSum, List<Integer> numbers, HashMap<Integer, Boolean> memo) {
    if (memo.containsKey(targetSum))
      return memo.get(targetSum);
    if (targetSum == 0)
      return true;
    if (targetSum < 0)
      return false;

    for (Integer num : numbers) {
      int remainder = targetSum - num;
      if (canSum(remainder, numbers, memo)) {
        memo.put(targetSum, true);
        return true;
      }
    }
    memo.put(targetSum, false);
    return false;
  }
}
```

---

## howSum

- Write a function `howSum(targetSum, numbers)` that takes in a targetSum and an array of numbers as arguments.
- The function should return an array containing any combination of elements that add up to exactly that `targetSum`. If there is no combination that adds up to the `targetSum`, then return null.
- If there are multiple combinations possible, you may return any single one.

![images/Untitled%203.png](images/Untitled%203.png)

```java
package com.dynamic_programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HowSum {
  public static List<Integer> howSum(int targetSum, List<Integer> numbers, HashMap<Integer, List<Integer>> memo) {
    if (memo.containsKey(targetSum))
      return memo.get(targetSum);
    if (targetSum == 0)
      return new ArrayList<>();
    if (targetSum < 0)
      return null;

    for (Integer num : numbers) {
      int remainder = targetSum - num;
      List<Integer> remainderResult = howSum(remainder, numbers, memo);
      if (remainderResult != null) {
        remainderResult.add(num);
        memo.put(targetSum, remainderResult);
        return remainderResult;
      }
    }
    memo.put(targetSum, null);
    return null;
  }

  public static List<Integer> howSum(int targetSum, List<Integer> numbers) {
    HashMap<Integer, List<Integer>> memo = new HashMap<>();
    return howSum(targetSum, numbers, memo);
  }
}
```

---

## bestSum

- Write a function `bestSum(targetSum, numbers)` that takes in a `targetSum` and an array of numbers as arguments.
- The function should return an array containing the `shortest` combination of numbers that add up to exactly the `targetSum`.
- If there is a tie for the shortest combination, you may return any one of the shortest.

![images/Untitled%204.png](images/Untitled%204.png)

```java
package com.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class BestSum {

  public static List<Integer> bestSum(int targetSum, List<Integer> numbers) {
    HashMap<Integer, List<Integer>> memo = new HashMap<>();
    return bestSum(targetSum, numbers, memo);
  }

  public static List<Integer> bestSum(int targetSum, List<Integer> numbers, HashMap<Integer, List<Integer>> memo) {
    if (memo.containsKey(targetSum))
      return memo.get(targetSum);

    if (targetSum == 0)
      return new ArrayList<>();

    if (targetSum < 0)
      return null;

    List<Integer> shortestCombination = null;

    for (Integer num : numbers) {
      int remainder = targetSum - num;
      List<Integer> remainderCombination = bestSum(remainder, numbers, memo);
      if (remainderCombination != null) {
        List<Integer> combination = new ArrayList<>(remainderCombination);
        combination.add(num);
        if (shortestCombination == null || shortestCombination.size() > combination.size()) {
          shortestCombination = combination;
        }
      }
    }
    memo.put(targetSum, shortestCombination);
    return shortestCombination;
  }
}
```

---

## In a nutshell

- `canSum -> Decision Problem`
  "Can you do it? yes/no"
- `howSum -> Combinatoric Problem`
  "How will you do it?"
- `bestSum -> Optimization Problem`
  "What is the 'best' way to do it?"

---

### canConstruct

- Write a function `canConstruct(target, wordBank)` that accepts a target string and an array of strings.
- The function should return a boolean indicating whether or not the `target` can be constructed by concatenating elements of the `wordBank` array.
- You may reuse elements of `wordBank` as many times as needed.

![images/Untitled%205.png](images/Untitled%205.png)

```java
package com.dynamic_programming;

import java.util.HashMap;
import java.util.List;

public class CanConstruct {
  public static boolean canConstruct(String target, List<String> wordBank) {
    HashMap<String, Boolean> memo = new HashMap<>();
    return canConstruct(target, wordBank, memo);
  }

  public static boolean canConstruct(String target, List<String> wordBank, HashMap<String, Boolean> memo) {
    if (memo.containsKey(target))
      return memo.get(target);

    if (target.compareTo("") == 0)
      return true;

    for (String word : wordBank) {
      if (target.indexOf(word) == 0) {
        String suffix = target.substring(word.length());
        if (canConstruct(suffix, wordBank, memo)) {
          memo.put(target, true);
          return true;
        }
      }
    }

    memo.put(target, false);
    return false;
  }
}
```

---

## canCount

- Write a function `countConstruct(target, wordBank)` that accepts a target string and an array of strings.
- The function should return the number of ways that the `target` can be constructed by concatenating elements of the `wordBank` array.
- You may reuse elements of `wordBank` as many times as needed.

![images/Untitled%206.png](images/Untitled%206.png)

canCount Tree

![images/Untitled%207.png](images/Untitled%207.png)

time-space complexity

```java
package com.dynamic_programming;

import java.util.HashMap;
import java.util.List;

public class CountConstruct {
  public static Integer countConstruct(String target, List<String> wordBank) {
    HashMap<String, Integer> memo = new HashMap<>();
    return countConstruct(target, wordBank, memo);
  }

  public static Integer countConstruct(String target, List<String> wordBank, HashMap<String, Integer> memo) {
    if (memo.containsKey(target))
      return memo.get(target);

    if (target.compareTo("") == 0)
      return 1;

    int totalCount = 0;

    for (String word : wordBank) {
      if (target.indexOf(word) == 0) {
        int numWaysForRest = countConstruct(target.substring(word.length()), wordBank, memo);
        totalCount += numWaysForRest;
      }
    }

    memo.put(target, totalCount);
    return totalCount;
  }
}
```

---

## allConstruct

- Write a function `allConstruct(target, wordBank)` that accepts a target string and an array of strings.
- The function should return a 2D array containing all of the ways that the `target` can be constructed by concatenating elements of the `wordBank` array. Each element of the 2D array should represent one combination that constructs the `target`.

![images/Untitled%208.png](images/Untitled%208.png)

allConstruct Tree

![images/Untitled%209.png](images/Untitled%209.png)

time-space complexity

```java
package com.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AllConstruct {
  public static List<List<String>> allConstruct(String target, List<String> wordBank) {
    HashMap<String, List<List<String>>> memo = new HashMap<>();
    return allConstruct(target, wordBank, memo);
  }

  public static List<List<String>> allConstruct(String target, List<String> wordBank,
      HashMap<String, List<List<String>>> memo) {
    if (memo.containsKey(target))
      return memo.get(target);

    if (target.compareTo("") == 0) {
      return new ArrayList<>(Arrays.asList(new ArrayList<>()));
    }

    List<List<String>> result = new ArrayList<>();

    for (String word : wordBank) {

      if (target.indexOf(word) == 0) {
        String suffix = target.substring(word.length());

        List<List<String>> suffixWays = allConstruct(suffix, wordBank, memo);
        List<List<String>> targetWays = new ArrayList<>();

        for (int i = 0; i < suffixWays.size(); i++) {
          List<String> temp = new ArrayList<>(suffixWays.get(i));
          temp.add(word);
          targetWays.add(temp);
        }

        for (int i = 0; i < targetWays.size(); i++) {
          result.add(new ArrayList<>(targetWays.get(i)));
        }

      }
    }

    memo.put(target, result);
    return result;
  }
}
```

---

## fibTab

```java
package com.tabulation;

public class FibTab {
  public static int fib(int target) {
    int[] table = new int[target + 1];
    table[0] = 0;
    table[1] = 1;

    for (int i = 2; i <= target; i++)
      table[i] = table[i - 1] + table[i - 2];

    return table[target];

  }
}
```

---

## gridTravelerTab

```java
package com.dynamic_programming.tabulation;

import java.util.Arrays;

public class GridTravelerTab {
  public static int gridTraveler(int rows, int cols) {
    int[][] table = new int[rows + 1][cols + 1];
    for (int i = 0; i < table.length; i++)
      Arrays.fill(table[i], 0);

    table[1][1] = 1;

    for (int i = 0; i <= rows; i++) {
      for (int j = 0; j <= cols; j++) {
        int current = table[i][j];
        if (j + 1 <= cols)
          table[i][j + 1] += current;
        if (i + 1 <= rows)
          table[i + 1][j] += current;
      }
    }

    return table[rows][cols];
  }
}
```

---

## Tabulation Recipe

- visualize the problem as a table
- size the table based on the inputs
- initialize the table with default values
- seed the trivial answer into the table
- iterate through the table
- fill further positions based on the current position

---

## canSumTab

```java
package com.dynamic_programming.tabulation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CanSumTab {
  public static boolean canSum(int targetSum, List<Integer> numbers) {
    boolean[] table = new boolean[targetSum + 1];
    table[0] = true;

    for (int i = 0; i <= targetSum; i++) {
      if (table[i] == true) {
        for (int num : numbers) {
          if (i + num <= targetSum)
            table[i + num] = true;
        }
      }
    }

    return table[targetSum];
  }
}
```

---

## howSumTab

```java
package com.dynamic_programming.tabulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HowSumTab {
  public static List<Integer> howSum(int targetSum, List<Integer> numbers) {
    List<List<Integer>> table = new ArrayList<>(Collections.nCopies(targetSum + 1, null));
    table.set(0, new ArrayList<>());

    for (int i = 0; i <= targetSum; i++) {
      if (table.get(i) == null)
        continue;
      for (int num : numbers) {
        if (i + num > targetSum)
          continue;
        table.set(i + num, new ArrayList<>(table.get(i)));
        table.get(i + num).add(num);
      }
    }

    return table.get(targetSum);
  }
}
```

---

## bestSumTab

```java
package com.dynamic_programming.tabulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BestSumTab {
  public static List<Integer> bestSum(int targetSum, List<Integer> numbers) {
    List<List<Integer>> table = new ArrayList<>(Collections.nCopies(targetSum + 1, null));
    table.set(0, new ArrayList<>());

    for (int i = 0; i <= targetSum; i++) {
      if (table.get(i) != null) {
        for (int num : numbers) {
          if (i + num > targetSum)
            continue;

          List<Integer> combination = new ArrayList<>();
          for (int el : table.get(i))
            combination.add(el);
          combination.add(num);

          if (table.get(i + num) == null || table.get(i + num).size() > combination.size())
            table.set(i + num, combination);
        }
      }
    }

    return table.get(targetSum);
  }
}
```

---

## canConstructTab

```java
package com.dynamic_programming.tabulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CanConstructTab {
  public static boolean canConstruct(String target, List<String> wordBank) {
    List<Boolean> table = new ArrayList<>(Collections.nCopies(target.length() + 1, false));
    table.set(0, true);

    for (int i = 0; i <= target.length(); i++) {
      if (table.get(i)) {
        for (String word : wordBank) {
          if (target.substring(i).indexOf(word) == 0) {
            table.set(i + word.length(), true);
          }
        }
      }
    }

    return table.get(target.length());
  }
}
```

---

## countConstructTab

```java
package com.dynamic_programming.tabulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountConstructTab {
  public static Integer countConstruct(String target, List<String> wordBank) {
    List<Integer> table = new ArrayList<>(Collections.nCopies(target.length() + 1, 0));
    table.set(0, 1);

    for (int i = 0; i <= target.length(); i++) {
      if (table.get(i) != 0) {
        for (String word : wordBank) {
          if (target.substring(i).indexOf(word) == 0) {
            table.set(i + word.length(), table.get(i + word.length()) + table.get(i));
          }
        }
      }
    }

    return table.get(target.length());
  }
}
```

---

## allConstructTab

```java
package com.dynamic_programming.tabulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AllConstructTab {

  public static void main(String[] args) {
    AllConstructTab.allConstruct("purple", Arrays.asList("purp", "le"));
  }

  public static List<List<String>> allConstruct(String target, List<String> wordBank) {
    List<List<List<String>>> table = new ArrayList<>(Collections.nCopies(target.length() + 1, null));
    for (int i = 0; i <= target.length(); i++) {
      table.set(i, new ArrayList<>());
    }
    table.get(0).add(new ArrayList<>());

    for (int i = 0; i <= target.length(); i++) {
      for (String word : wordBank) {
        if (target.substring(i).indexOf(word) == 0) {
          List<List<String>> newCombinations = new ArrayList<>();

          for (List<String> subArray : table.get(i)) {
            List<String> subArrayTemp = new ArrayList<>(subArray);
            subArrayTemp.add(word);
            newCombinations.add(subArrayTemp);
          }

          for (List<String> subArray : newCombinations) {
            table.get(i + word.length()).add(new ArrayList<>(subArray));
          }

        }
      }
    }

    return table.get(target.length());
  }
}
```

---

## Dynamic Programming

- notice any overlapping subproblems
- decide what is the trivially smallest input
- think recursively to use Memoization
- think iteratively to use Tabulation
- draw a strategy first!!!

---
