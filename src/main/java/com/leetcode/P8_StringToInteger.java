package com.leetcode;

import org.junit.Test;

public class P8_StringToInteger {

  @Test
  public void test() {
    System.out.println(myAtoi("-3147483649"));
    System.out.println(myAtoi("     +00"));

  }

  /**
   * 2147483647   2^31-1
   * -2147483648   -2^31
   */
  public int myAtoi(String str) {
    if (str == null || str.length() == 0) return 0;
    int sign = 1, value = 0, index = 0;
    while (index < str.length() && str.charAt(index) == ' ') {
      index++;
    }
    if (index == str.length()) return 0;

    if (str.charAt(index) == '-') {
      sign = -1;
      index++;
    } else if (str.charAt(index) == '+') {
      sign = 1;
      index++;
    }
    while (index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
      if (value > Integer.MAX_VALUE / 10 || (value == Integer.MAX_VALUE / 10 && str.charAt(index) > '7')) {
        if (sign == 1) {
          return Integer.MAX_VALUE;
        } else if (sign == -1) {
          return Integer.MIN_VALUE;
        }
      }
      value = 10 * value + (str.charAt(index++) - '0');
    }
    return value * sign;
  }
}
