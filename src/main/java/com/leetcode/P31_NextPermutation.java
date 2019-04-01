package com.leetcode;

import org.junit.Test;

public class P31_NextPermutation {
  public static void main(String[] args) {
    //    int[] intArray = new int[]{10,9,8,7,6};
    int[] intArray = new int[] { 1 };
    new P31_NextPermutation().nextPermutation(intArray);
//    Arrays.stream(intArray).forEach(System.out::println);

  }

  @Test public void test1() {
    int[] array = { 1, 3, 2 };
    nextPermutation(array);
//    Arrays.stream(array).forEach(System.out::println);
  }

  @Test public void test2() {
    //3,1,2,4
    int[] array = { 2, 4, 3, 1 };
    nextPermutation(array);
//    Arrays.stream(array).forEach(System.out::println);
  }

  /**
   * 5 2 6 3 2
   * 关键思路：从最右开始，找到第一个左边比右边小的数，记下索引i，再次从最右开始，找到第一个比nums[i]
   * 大的数nums[j]，交换nums[i]和nums[j]，剩下i右边的数进行倒转（就是实现了排序）
   */
  public void nextPermutation(int[] nums) {
    int i = nums.length - 2;
    while (i >= 0 && nums[i + 1] <= nums[i]) {
      i--;
    }
    if (i >= 0) {
      int j = nums.length - 1;
      while (j >= 0 && nums[j] <= nums[i]) {
        j--;
      }
      swap(nums, i, j);
    }
    reverse(nums, i + 1);
  }

  private void reverse(int[] nums, int start) {
    int i = start, j = nums.length - 1;
    while (i < j) {
      swap(nums, i, j);
      i++;
      j--;
    }
  }
  private void swap(int[] nums, int i,int j) {
    int temp=nums[i];
    nums[i]=nums[j];
    nums[j]=temp;
  }
}
