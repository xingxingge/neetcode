package com.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {
  @Test
  public void test() {
    String s = "abczaaaaaaaafffffffabcdefagbd1234567oiuytre";
    System.out.println(lengthOfLongestSubstring(s));
  }


  /**
   * 向前滑动，找到重复的字符串，记录最大长度，新的开始索引和结束索引
   * @param s
   * @return
   */
  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0) return 0;
    Map<Character, Integer> map = new HashMap<>();//index map
    int currentStartIndex = 0, currentEndIndex = 0;
    int preStartIndex = 0, preEndIndex = 0;
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      char c = chars[i];
      Integer mapCharIndex = map.get(c);
      //Map records all char index,but it does not remove the element before currentStartIndex
      if (mapCharIndex != null && mapCharIndex >= currentStartIndex) {
        currentStartIndex = mapCharIndex + 1;//new start index
      }
      map.put(c, i);
      currentEndIndex = i;//new end index
      if (currentEndIndex - currentStartIndex > preEndIndex - preStartIndex) {
        preStartIndex = currentStartIndex;
        preEndIndex = currentEndIndex;
      }
    }
    System.out.println(s.substring(preStartIndex, preEndIndex + 1));
    return preEndIndex + 1 - preStartIndex;
  }

  /**
   * 使用滑动窗口
   * @param s
   * @return
   */
  public int slidWindow(String s){
    return 1;
  }
}
