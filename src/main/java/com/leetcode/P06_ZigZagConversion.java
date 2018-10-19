package com.leetcode;

import org.junit.Test;

public class P06_ZigZagConversion {
  @Test
  public void test1() {
    String s = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwx";
    int numRows = 8;
    System.out.println(convert(s, numRows));
    System.out.println(convert("abc",1));
    System.out.println(convert("abc",2));
    System.out.println(convert("abc",3));
    System.out.println(convert("abc",4));

  }

  /**
   0        14        28        42
   1      1315      2729      4143
   2     12 16     26 30     40 44
   3    11  17    25  31    39  45
   4   10   18   24   32   38   46
   5  9     19  23    33  37    47
   6 8      20 22     34 36     48
   7        21        35        49

   a       o       c       q
   b      np      bd      pr
   c     m q     a e     o s
   d    l  r    z  f    n  t
   e   k   s   y   g   m   u
   f  j    t  x    h  l    v
   g i     u w     i k     w
   h       v       j       x
   * @param s
   * @param numRows
   * @return
   */

  public String convert(String s, int numRows) {
    int length = s.length();// 16/6
    if (numRows==1 || numRows >= length) return s; //直接返回
    int numColumn;
    if (numRows > 2) {
      numColumn = length / (numRows - 2) + 1;//每个数组的计算长度
    } else {
      numColumn = length / 2 + 1;
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < numRows; i++) {
      for (int j = 0, k = 0; j < numColumn; j++, k++) {
        if (i == 0 || i == numRows - 1) {
          int index = i + ((2 * numRows) - 2) * j;
          if (index < s.length()) {
            sb.append(s.charAt(index));
          } else {
            break;
          }
        } else {
            int left = ((2 * numRows) - 2) * k - i;
            int right = left + 2 * i;
            if (left >= length) break;
            if (j < numColumn && left>=0 && left < length) {
              sb.append(s.charAt(left));
            }
            if (j < numColumn - 1 && right < length) {
              sb.append(s.charAt(right));
            if (j>0)j++;
          }
        }
      }
      sb.append("\n");
    }
    return sb.toString();
  }

}
