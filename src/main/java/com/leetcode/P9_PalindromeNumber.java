package com.leetcode;

import org.junit.Test;

public class P9_PalindromeNumber {
  @Test
  public void test1(){
    System.out.println(isPalindrome(200));
    System.out.println(isPalindrome(021120));

  }
  public boolean isPalindrome(int x) {
    int temp = x;
    if (x < 0 || (x % 10 == 0 && x != 0)) return false;
    int reverseNumber = 0;
    while (x > 0) {
      int pop = x % 10;
      reverseNumber = 10 * reverseNumber + pop;
      x /= 10;
    }
    return reverseNumber == temp;
  }
}
