package com.leetcode;

import org.junit.Test;

/**
 * 输入: 123
 * 输出: 321
 *
 * 示例 2:
 * 输入: -123
 * 输出: -321
 *
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储 32 位有符号整数，
 * 其数值范围是 [−2^31,  2^31 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
 *
 */

public class P7_ReverseInteger {
  @Test
  public void test() {
    System.out.println(reverse(-15));

  }

  /**
   * Complexity Analysis

   Time Complexity: O(log(x)). There are roughly log10(x) digits in xx.
   Space Complexity: O(1).
   *
   * @param x
   * @return
   */
  public int reverse(int x) {
    System.out.println(Integer.MAX_VALUE);
    System.out.println(Integer.MIN_VALUE);
    int result = 0;
    while (x != 0) {
      int pop = x % 10;
      x /= 10;
      if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
      if (result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE / 10 && pop < -8)) return 0;

      result = result * 10 + pop;
    }
    return result;
  }
}
