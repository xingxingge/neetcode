package com.leetcode;

import org.junit.Test;

public class P28_ImplementStrStr {
  @Test
  public void test() {
    String a = "abd";
    String b = "abdf";
    System.out.println(strStr(a, b));

  }

  public int strStr(String a, String b) {
    for (int i = 0; a.length() - i >= b.length(); i++) {
      int j = i, k = 0;
      for (; k < b.length(); j++, k++) {
        if (a.charAt(j) != b.charAt(k))
          k = b.length() + 1;
      }
      if (k == b.length()) return i;
    }
    return -1;

  }
}
