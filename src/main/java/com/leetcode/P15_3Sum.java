package com.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class P15_3Sum {
  @Test
  public  void test(){
    int[] nums=  {-4,-3,-2,-1,-1,0,1,2,3,4,5,6};
    System.out.println(threeSum(nums));

  }

  /**
   * 双指针法，计算另外两个元素三个数相加等于0
   * @param nums
   * @return
   */
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    if (nums == null || nums.length < 3) return result;
    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 2; i++) {
      while (i < nums.length - 2 && i > 0 && nums[i] == nums[i - 1]) i++;//去除相等的元素
      int sum = -nums[i];
      int j = i + 1;
      int k = nums.length - 1;
      while (j < k) {
        if (nums[k] + nums[j] == sum) {
          result.add(Arrays.asList(nums[i], nums[j], nums[k]));
          j++;
          k--;
          while (j < k && nums[j] == nums[j - 1]) j++;
          while (j < k && nums[k] == nums[k + 1]) k--;
        } else if (nums[k] + nums[j] < sum) {
          j++;
        } else {
          k--;
        }
      }
    }
    return result;
  }
}
