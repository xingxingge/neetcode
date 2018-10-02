package com.leetcode;

import org.junit.Test;

/**
 * 5. 最长回文子串
 * cabad 的回文串时aba
 */
public class LongestPalindromicSubstring5 {
  @Test
  public void longestPalindrome() {
    String s = "12212321";
    System.out.println(manacher(s));
  }

  /**
   * 中心扩展法，移动中心点,考虑abba这种情况
   */
  public String expandCenter(String s) {
    if (s == null || s.length() == 0) return "";
    int left = 0, right = 0;
    for (int i = 0; i < s.length(); i++) {
      int len1 = expandCenter(s, i, i);
      int len2 = expandCenter(s, i, i + 1);
      int len = Math.max(len1, len2);
      if (len > right - left) {//大于最长长度
        left = i - ((len - 1) >> 1);
        right = i + (len >> 1);
      }
    }
    left = (left >= 0 ? left : 0);
    right = (right < s.length() ? right : s.length());
    return s.substring(left, right + 1);

  }

  /**
   * 从两点向外部扩展，找到子串
   */
  private int expandCenter(String s, int left, int right) {
    int l = left, r = right;
    while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
      l--;
      r++;
    }
    return r - l - 1;
  }

  /**
   * 动态规划
   * 因此，
   *
   * P(i, j) = ( P(i+1, j-1) and S_i == S_j )
   *
   * 基本示例如下：
   *
   * P(i, i) = true
   *
   * P(i, i+1) = ( S_i == S_{i+1} )
   */
  public String dynamicProgramming(String s) {
    boolean[][] dp = new boolean[s.length()][s.length()];
    int max = 0;
    String res = new String();
    // for this problem, we have to go from the bottom to the top
    // dp[i][j] relys on dp[i+1][j-1], dp[i+1][j-1] is at the bottom left of dp[i][j]
    // so to determin dp[i][j], we need to have dp[i+1][j-1] first
    for (int i = s.length() - 1; i >= 0; i--) {
      // we only need half of the matrix table, since dp[i][j] is essentially the same as dp[j][i]
      for (int j = i; j < s.length(); j++) {
        if (i == j) {
          dp[i][j] = true;
        } else {
          // combine base case 2 and general case into one line
          dp[i][j] = (s.charAt(i) == s.charAt(j)) && (dp[i + 1][j - 1] || j == i + 1);
        }

        if (dp[i][j] && (j - i + 1 > max)) {
          res = s.substring(i, j + 1);
          max = j - i + 1;
        }
      }
    }
    return res;

  }

  /**
   * manacher 算法,利用回文串回文数量的对称性
   */
  public String manacher(String s) {
    if (s == null || s.length() == 0) return "";
    StringBuilder newStr = new StringBuilder();
    newStr.append('#');
    for (int i = 0; i < s.length(); i++) {
      newStr.append(s.charAt(i));
      newStr.append('#');
    }
    s = newStr.toString();
    int maxLength = 0; // max palindrome length;
    int start = 0, end = 0;//max palindrome start index and end index

    int[] p = new int[s.length()];

    int mx = 0, id = 0;

    for (int i = 0; i < s.length(); i++) {
      int j = 2 * id - i;
      if (j >= 0 && mx - i > p[j])
        p[i] = p[j];
      else /* P[j] >= mx - i */
        p[i] = mx - i;
      while (i + p[i] < s.length() && i - p[i] >= 0 && s.charAt(i + p[i]) == s.charAt(i - p[i])) {
        p[i]++;
      }
      if (i + p[i] > mx) {
        mx = i + p[i];//R
        id = i;//C
        if (p[i] > maxLength) {
          maxLength = p[i];
          start = i - p[i] + 1;
          end = i + p[i] - 1;
        }
      }
    }
    return s.substring(start, end + 1).replace("#", "");
  }

}
