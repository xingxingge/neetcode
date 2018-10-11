package com.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P18_4Sum {
  @Test
  public void test1() {
    int[] nums = {-4, -1, -1,-1, 0, 1, 2};//[[-4, 0, 1, 2], [-1, -1, -1, 2], [-1, -1, 0, 1]]
    System.out.println(fourSum(nums, -1));
  }

  @Test
  public void test2() {
    int[] nums = {-3, -2, -1, 0, 0, 1, 2, 3};//[[-4, 0, 1, 2],[-1,-1,0,1]]
    //[[-3, -2, 2, 3], [-3, -1, 1, 3], [-3, 0, 0, 3], [-3, 0, 1, 2], [-2, -1, 0, 3], [-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]

    System.out.println(fourSum(nums, 0));
  }

  @Test
  public void test3() {
    int[] nums = {-5, -5, -3, -1, 0, 2, 4, 5};//[[-5, -5, -1, 4], [-5, -3, -1, 2]]
    System.out.println(fourSum(nums, -7));
  }

  @Test
  public void test4() {
    int[] nums = {-5, -1, -1, 0, 2, 2, 4};//[[-5, 2, 2, 4], [-1, 0, 2, 2]]
    System.out.println(fourSum(nums, 3));
  }

  @Test
  public void test5() {
    int[] nums = {-2, -1, 0, 0, 3, 3};//[[-1, 0, 3, 3]]
    System.out.println(fourSum(nums, 5));
  }

  @Test
  public void test6() {
    int[] nums = {-5, -2, -1, 0, 0, 0, 1, 3, 5};//[[-2, 0, 3, 5], [0, 0, 1, 5]
    System.out.println(fourSum(nums, -10));
  }


  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> result = new ArrayList();
    if (nums == null || nums.length < 4) return result;
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 3; i++) {
      if(nums[i]>target){
        break;
      }
      if (i - 1 >= 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      int base = target - nums[i];
      for (int j = i + 1; j < nums.length - 2; j++) {
        if (j - 1 >= 0 && nums[j] == nums[j - 1] && j>i+1) {
          continue;
        }
        int t = nums[j], b = base - t, l = j + 1, h = nums.length - 1;
        while (l < h) {
          if (nums[l] + nums[h] > b) {
            h--;
          } else if (nums[l] + nums[h] < b) {
            l++;
          } else {
            List ele = new ArrayList();
            ele.add(nums[i]);
            ele.add(nums[j]);
            ele.add(nums[l]);
            ele.add(nums[h]);
            result.add(ele);
            l++;
            h--;
            while ( l + 1 < h && nums[l] == nums[l + 1] ) l++;
            while ( h - 1 > l && nums[h] == nums[h - 1] ) h--;
          }
        }
      }
    }
    return result;
  }
}
