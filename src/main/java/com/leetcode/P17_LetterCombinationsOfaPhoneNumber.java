package com.leetcode;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class P17_LetterCombinationsOfaPhoneNumber {
  @Test
  public void test() {
    System.out.println(letterCombinations("3259999"));
  }

  /**
   * 使用队列进行BFS遍历
   * @param digits
   * @return
   */
  public List<String> letterCombinations(String digits) {
    LinkedList<String> ans = new LinkedList<>();

    if (digits.length() == 0)   return ans;

    String[] ref = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    ans.add("");

    while (ans.peek().length() != digits.length()) {
      String remove = ans.poll();
      String map = ref[digits.charAt(remove.length()) - '0'];
      for (int i = 0; i < map.length(); i++)
        ans.addLast(remove + map.charAt(i));
    }

    return ans;
  }

}
