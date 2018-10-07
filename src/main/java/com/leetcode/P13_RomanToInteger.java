package com.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * MMMCCXIV
 * 3214
 */
public class P13_RomanToInteger {
  @Test
  public void test(){
    String str="MMMCCXIV";
    System.out.println(romanToInt(str));

  }

  public int romanToInt(String s) {
    Map<Character, Integer> m = new HashMap<>();
    m.put('I',1);
    m.put('V',5);
    m.put('X',10);
    m.put('L',50);
    m.put('C',100);
    m.put('D',500);
    m.put('M',1000);
    int result = 0;

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (i!=s.length()-1 && m.get(c)<m.get(s.charAt(i+1))){
        result+=(m.get(s.charAt(i+1))-m.get(c));
        i++;
      }else{
        result+=m.get(c);
      }
    }
    return result;
  }
}
