package com.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * /**
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class P1_TwoSum {

  @Test
  public void test() {
//    int[] nums = new int[]{1, 2, 3, 6, 5};
    int[] nums = new int[]{5, 6, 3, 1, 2};
    int target = 5;
//    int[] ints = bruteForce(nums, target);
//    int[] ints = twoPassHashTable(nums, target);
    int[] ints = onePassHashTable(nums, target);
    for (int i = 0; i < ints.length; i++) {
      System.out.println(ints[i]);

    }
  }

  /**
   * 复杂度分析：
   *
   * 时间复杂度：O(n^2)， 对于每个元素，我们试图通过遍历数组的其余部分来寻找它所对应的目标元素，
   * 这将耗费 O(n)的时间。因此时间复杂度为 O(n^2)。
   *
   * 空间复杂度：O(1)。
   */
  public int[] bruteForce(int[] nums, int target) {
    /**
     * 暴力法
     */
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[]{i, j};
        }
      }
    }
    throw new IllegalArgumentException("No two sum solution");
  }

  /**
   * 两遍哈希表法
   * 复杂度分析：
   *
   * 时间复杂度：O(n)， 我们把包含有 n 个元素的列表遍历两次。哈希表将查找时间缩短到 O(1)
   * 注意：当出现哈希冲突时，由于需要遍历哈希桶上的链表，有可能查找时间变成O(n)
   * 空间复杂度：O(n)， 所需的额外空间取决于哈希表中存储的元素数量，该表中存储了 n 个元素。
   */
  public int[] twoPassHashTable(int[] nums, int target) {

    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], i);
    }
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement) && map.get(complement) != i) {
        return new int[]{i, map.get(complement)};
      }

    }
    throw new IllegalArgumentException("No two sum solution");
  }

  /**
   * 事实证明，我们可以一次完成。在进行迭代并将元素插入到表中的同时，
   * 我们还会回过头来检查表中是否已经存在当前元素所对应的目标元素。
   * 如果它存在，那我们已经找到了对应解，并立即将其返回(不用首先全部写到哈希表中，如果
   * 数组在开头部分就能得到需要的值，时间复杂度和空间复杂度都降低)。
   * 时间复杂度：O(n)， 我们只遍历了包含有 n 个元素的列表一次。
   * 在表中进行的每次查找只花费 O(1) 的时间。

   空间复杂度：O(n)， 所需的额外空间取决于哈希表中存储的元素数量，
   该表最多需要存储 n个元素。
   * @param nums
   * @param target
   * @return
   */
  public int[] onePassHashTable(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      Integer integer = map.get(complement);
      if (integer != null) {
        return new int[]{integer, i};
      }
      map.put(nums[i], i);
    }
    throw new IllegalArgumentException("No two sum solution");
  }
}


