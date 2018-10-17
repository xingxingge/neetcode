package com.leetcode;

import org.junit.Test;

/**
 * 移除重复的元素,返回前面不重复的元素
 */
public class P26_RemoveDuplicatesFromSortedArray {
  @Test
  public void test() {
    int[] nums = {1, 2, 3, 3, 4, 4, 5, 5, 6, 6};
    System.out.println(removeDuplicates(nums));
    for (int k:nums){
      System.out.print(k+"\t");
    }
  }

  public int removeDuplicates(int[] nums) {
    if (nums.length == 0) return 0;
    int pre = nums[0];
    int curr = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != pre) {
        pre = nums[i];
        nums[curr++] = nums[i];
      }
    }
    return curr;
  }
}
