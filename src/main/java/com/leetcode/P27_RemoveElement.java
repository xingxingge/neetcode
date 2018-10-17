package com.leetcode;

import org.junit.Test;

public class P27_RemoveElement {
  @Test
  public void test1(){
    int[] nums=Wrapper.stringToIntegerArray("[1,2,2,3,2,3,2,2,3]");
    System.out.println(removeElement(nums,2));
    Wrapper.printArray(nums);

  }
  @Test
  public void test2(){
    int[] nums=Wrapper.stringToIntegerArray("[3]");
    System.out.println(removeElement(nums,2));
    Wrapper.printArray(nums);

  }
  @Test
  public void test3(){
    int[] nums=Wrapper.stringToIntegerArray("[1,2,2,3,2,3,2,2,3]");
    System.out.println(removeElement2(nums,2));
    Wrapper.printArray(nums);

  }

  /**
   * 双指针法，从头和尾部开始向中间靠，把元素往最后面移动
   * @param nums
   * @param val
   * @return
   */
  public int removeElement(int[] nums, int val) {
    int start = 0;
    int end = nums.length - 1;
    int len = nums.length;
    while (start <= end) {
      if (nums[start] == val) {
        len--;
        while (start > end) {
          if (nums[end] != val) {
            nums[start] = nums[end];
            nums[end] = val;
            end--;
            break;
          } else {
            len--;
            end--;
          }
        }
      }
      start++;
    }
    return len;
  }

  /**
   * 不移动元素，直接设置值即可
   * @param nums
   * @param val
   * @return
   */
  public int removeElement2(int[] nums, int val) {
    int curr = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != val) {
        nums[curr] = nums[i];
        curr++;
      }
    }
    return curr;
  }
}
