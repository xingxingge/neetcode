package com.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given n pairs of parentheses,
 * write a function to generate all combinations of well-formed
 * parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class P22_GenerateParentheses {
  @Test
  public void test1() {
    System.out.println(generateParenthesis2(2));
  }

  public List<String> generateParenthesis(int n) {
    Set<String> r = new HashSet<>();
    if (n >= 2) {
      List<String> result = generateParenthesis(n - 1);
      for (String str : result) {
        for (int i = 0; i <= str.length() / 2; i++) {
          r.add(str.substring(0, i) + "()" + str.substring(i));
        }
      }
    } else {
      r = new HashSet<>();
      r.add("()");
    }

    return new ArrayList<>(r);
  }

  /**
   * Approach 2: Backtracking
   Intuition and Algorithm

   Instead of adding '(' or ')' every time as in Approach 1,
   let's only add them when we know it will remain a valid sequence.
   We can do this by keeping track of the number of opening and closing brackets
   we have placed so far.

   We can start an opening bracket if we still have one (of n) left to place.
   And we can start a closing bracket if it would not exceed the number of opening brackets.
   * @param n
   * @return
   */
  public List<String> generateParenthesis2(int n) {
    List<String> ans = new ArrayList();
    backtrack(ans, "", 0, 0, n);
    return ans;
  }

  public void backtrack(List<String> ans, String cur, int open, int close, int max){
    if (cur.length() == max * 2) {
      ans.add(cur);
      return;
    }

    if (open < max)
      backtrack(ans, cur+"(", open+1, close, max);
    if (close < open)
      backtrack(ans, cur+")", open, close+1, max);
  }
}
