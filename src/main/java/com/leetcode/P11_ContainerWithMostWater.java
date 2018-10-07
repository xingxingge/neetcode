package com.leetcode;

import org.junit.Test;

/**
 * 木桶原理，求最大面积方法
 */
public class P11_ContainerWithMostWater {
  public int maxArea(int[] height) {
    if (height.length == 0) throw new IllegalArgumentException("");
    return 11;

  }

  @Test
  public void test() {
    int[] a = {1, 8, 6, 2, 5, 4, 8};
    System.out.println(bruteForce(a));
    System.out.println(towPoints(a));


  }

  /**
   * 暴力法
   * 时间复杂度：O(n^2)
   * )
   */
  public int bruteForce(int[] height) {
    int maxArea = 0;
    for (int i = 0; i < height.length - 1; i++) {
      for (int j = i + 1; j < height.length; j++) {
        maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
      }
    }
    return maxArea;
  }

  /**
   * 双指针法
   * 方法二：双指针法
   * 算法
   *
   * 这种方法背后的思路在于，两线段之间形成的区域总是会受到其中较短那条长度的限制。
   * 此外，两线段距离越远，得到的面积就越大。
   *
   * 我们在由线段长度构成的数组中使用两个指针，一个放在开始，一个置于末尾。
   * 此外，我们会使用变量 maxare 来持续存储到目前为止所获得的最大面积。
   * 在每一步中，我们会找出指针所指向的两条线段形成的区域，更新 maxarea，
   * 并将指向较短线段的指针向较长线段那端移动一步。
   *
   * 复杂度分析
   * 时间复杂度：O(n)，一次扫描。
   * 空间复杂度：O(1)，使用恒定的空间。
   */
  public int towPoints(int[] height) {
    int maxArea = 0, l = 0, r = height.length - 1;
    while (l < r) {
      maxArea = Math.max(maxArea, Math.min(height[l], height[r]) * (r - l));
      if (height[l] < height[r]) {
        l++;
      } else {
        r--;
      }
    }
    return maxArea;
  }
}
