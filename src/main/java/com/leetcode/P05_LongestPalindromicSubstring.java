package com.leetcode;

import org.junit.Test;

/**
 * 5. 最长回文子串
 * cabad 的回文串时aba
 */
public class P05_LongestPalindromicSubstring {
  @Test
  public void longestPalindrome() {
    String s = "12212321";
    System.out.println(manacher(s));
  }

  @Test
  public void dynamicProgramming(){
    String s="abcdcbb";
    System.out.println(dynamicProgramming(s));
  }
  @Test
  public void expandCenterTest(){
    String s="abcdcba";
    System.out.println(expandCenter(s));
  }

  /**
   * 中心扩展法，移动中心点,考虑abba这种情况
   */
  public String expandCenter(String s) {
    if (s == null || s.length() < 1){
      return "";
    }

    // 初始化最大回文子串的起点和终点
    int start = 0;
    int end   = 0;

    // 遍历每个位置，当做中心位
    for (int i = 0; i < s.length(); i++) {
      // 分别拿到奇数偶数的回文子串长度
      //奇数长度
      int len_odd = expandCenter(s,i,i);
      //偶数长度
      int len_even = expandCenter(s,i,i + 1);
      // 对比最大的长度
      int len = Math.max(len_odd,len_even);
      // 计算对应最大回文子串的起点和终点
      if (len > end - start){
        start = i - (len - 1)/2;
        end = i + len/2;
      }
    }
    // 注意：这里的end+1是因为 java自带的左闭右开的原因
    return s.substring(start,end + 1);
  }


  /**
   *
   * @param s             输入的字符串
   * @param left          起始的左边界
   * @param right         起始的右边界
   * @return              回文串的长度
   */
  private int expandCenter(String s,int left,int right){
    // left = right 的时候，此时回文中心是一个字符，回文串的长度是奇数
    // right = left + 1 的时候，此时回文中心是一个空隙，回文串的长度是偶数
    // 跳出循环的时候恰好满足 s.charAt(left) ！= s.charAt(right)
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
      left--;
      right++;
    }
    // 回文串的长度是right-left+1-2 = right - left - 1
    return right - left - 1;
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
   * //原则，先填写左下方，再填写变得，因为要通过判断[i+1][j-1]得到[i][j]
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
          // combine base case 2 and general case into one line  //边界，j=i+1时，可能左下方的元素还没计算出来，所以需要这样判断
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
