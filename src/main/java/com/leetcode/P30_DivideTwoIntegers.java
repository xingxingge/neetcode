package com.leetcode;

import org.junit.Test;

public class P30_DivideTwoIntegers extends BaseTest {
  @Test
  public void test() {
    int a = Integer.MAX_VALUE;
    int b = 3;
    System.out.println(divide3(a, b));

  }

  @Test
  public void test2() {
    int a = Integer.MIN_VALUE;
    int b = -1;
//    System.out.println(divide(a, b));
    System.out.println(divide2(a, b));
    System.out.println(divide3(a, b));

  }

  @Test
  public void test3() {
    int a = 101;
    int b = 102;
    System.out.println(divide3(a, b));

  }

  @Test
  public void testn() {
    System.out.println(Integer.MIN_VALUE / -1);
    System.out.println((Integer.MIN_VALUE + 1) / -1);
    System.out.println(Integer.MIN_VALUE - 0);

  }

  public int divide(int a, int b) {
    if (a == b) return 1;
    if (b == 1) return a;
    int sign = 1;
    if (a < 0 && b > 0) {
      sign = -1;
      b = 0 - b;
    }
    if (b < 0 && a > 0) {
      sign = -1;
      a = 0 - a;
    }
    int r = 0;
    while ((b > 0 && a - b >= 0) || (b < 0 && a - b <= 0)) {
      a = a - b;
      r++;
      if (r == 2147483647) break;
    }
    return (sign == 1) ? r : (0 - r);
  }

  /**
   * 不用long,转换为整数关键点，通过翻倍，递归读取商.
   */
  public int divide3(int a, int b) {
    if (a == Integer.MIN_VALUE && b == -1) return Integer.MAX_VALUE;
    if (b == 1) return a;
    int sign = 1;
    if (a < 0 && b > 0) {
      sign = -1;
      b = 0 - b;
    }
    if (b < 0 && a > 0) {
      sign = -1;
      a = 0 - a;
    }
    //全部设置成负数 -100,-2;
    if (a > 0 && b > 0) {
      a = 0 - a;
      b = 0 - b;
    }
    int result = helper(a, b);
    return (sign == 1) ? result : (0 - result);
  }

  private int helper(int a, int b) {
    if (a > b) return 0;
    int count = 1;
    int sum = b;
    while (sum + sum > a && sum + sum < 0) {
      sum += sum;
      count += count;
    }
    return count + helper(a - sum, b);
  }

  public int divide2(int dividend, int divisor) {
    // if(divisor==0) throw new Exception("Illegal Operation");
    if (dividend == Math.pow(-2, 31) && divisor == -1) {//handling overflow
      // System.out.println("wtf");
      return Integer.MAX_VALUE;
    }
    if (divisor == 1) return dividend;
    int sign = 1;
    if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
      sign = -1;
    }

    long ldividend = Math.abs((long) dividend);
    long ldivisor = Math.abs((long) divisor);
    int result = divideHelper(ldividend, ldivisor);

    return sign > 0 ? result : 0 - result;
  }

  public int divideHelper(long dividend, long divisor) {
    if (dividend < divisor) return 0;
    long sum = divisor;
    int count = 1;
    while (sum + sum < dividend) {
      sum += sum;
      count += count;
    }
    return count + divideHelper(dividend - sum, divisor);
  }
}
