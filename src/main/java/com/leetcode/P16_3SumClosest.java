package com.leetcode;

import org.junit.Test;

import java.util.Arrays;

public class P16_3SumClosest {
  @Test
  public void test() {
    int[] array = {-3, -3, -2, -2, -1, 0, 1, 2, 3, 4, 5};
    array = new int[]{0, 1, 2};
    array = new int[]{-1, 2, 1, -4};
    array = new int[]{0,1,2};
    array = new int[]{1,1,-1};
    array = new int[]{1,1,1,1};
    array = new int[]{0,2,1,-3};
    array = new int[]{1,1,-1,-1,3};
    System.out.println(threeSumClosest(array, 1));

  }

  public int threeSumClosest(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return 0;
    } else if (nums.length == 1) {
      return Math.abs(nums[0] - target);
    } else if (nums.length == 2) {
      return Math.abs(nums[0] + nums[1] - target);
    }
    Arrays.sort(nums);
    int minDiff = Integer.MAX_VALUE;
    int value = 0;
    for (int i = 0; i < nums.length - 2; i++) {
//      if (nums[i] == nums[i + 1] && i<nums.length-3) {
//        continue;
//
//      }
      int base = nums[i];
      int l = i + 1, r = nums.length - 1;
      while (l < r) {
//        if (nums[r] == nums[r - 1] && r-l>1) {
//          r--;
//          continue;
//        }
//        if (nums[l] == nums[l + 1] && r-l>1) {
//          l++;
//          continue;
//        }
        int total=base + nums[l] + nums[r];

        int diff = total - target;//差值最小
        int absDiff = Math.abs(diff);
        if (absDiff <= minDiff) {
          minDiff = absDiff;
          value = base + nums[l] + nums[r];
        }
        if (diff == 0) {
          System.out.println(nums[i] + " " + nums[l] + " " + nums[r]);
          return value;
        } else if (diff > 0) {
          r--;
        } else {
          l++;
        }
      }
    }
    return value;
  }

  /**
   * 代码改进
   * @param nums
   * @param target
   * @return
   */
  public int threeSumClosest2(int[] nums, int target) {
    int result = 0;
    int diff = Integer.MAX_VALUE;
    Arrays.sort(nums);
    for(int i = 0; i < nums.length - 2; i++) {
      int low = i + 1, high = nums.length - 1;
      while(low < high) {
        int sum = nums[i] + nums[low] + nums[high];
        if(sum > target)
          high--;
        else
          low++;
        if(Math.abs(sum - target) < diff) {
          diff = Math.abs(sum - target);
          result = sum;
        }
      }
    }
    return result;
  }
}
