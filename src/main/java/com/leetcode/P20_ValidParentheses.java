package com.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class P20_ValidParentheses {
  @Test
  public void test1(){
    System.out.println(isValid("([])"));
    System.out.println(isValid("(((]]]"));

  }
  public boolean isValid(String s) {

    Map<Character, Character> mappings = new HashMap<Character, Character>();

    mappings.put(')', '(');

    mappings.put('}', '{');

    mappings.put(']', '[');

    Stack<Character> stack = new Stack<Character>();

    for (int i = 0; i < s.length(); i++) {

      char c = s.charAt(i);

      if (mappings.containsKey(c)) {

        if (stack.isEmpty()) return false;

        char topElement = stack.pop();

        if (topElement != mappings.get(c)) {

          return false;

        }

      } else {

        stack.push(c);

      }

    }

    return stack.isEmpty();

  }
}
