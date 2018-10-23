package com.leetcode;

import java.util.*;

public class P30_SubstringwithConcatenationofAllWords {
  public static void main(String[] xargs) {
    P30_SubstringwithConcatenationofAllWords c = new P30_SubstringwithConcatenationofAllWords();
    System.out.println(c.findSubstring("fobarvbarfobarfofbarfofobarxxddfo", new String[]{"fo", "ba","fo"}));
  }

  public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> indices = new ArrayList<>();
    if (words.length == 0) {
      return indices;
    }
    //Put each word into a HashMap and calculate word frequency
    Map<String, Integer> wordMap = new HashMap<>();
    for (String word : words) {
      wordMap.put(word, getOrDefault(wordMap, word, 0) + 1);
    }
    int wordLength = words[0].length();
    int window = words.length * wordLength;
    for (int i = 0; i < wordLength; i++) {
      //move a word's length each time
      for (int j = i; j + window <= s.length(); j = j + wordLength) {
        //get the subStr
        String subStr = s.substring(j, j + window);
        Map<String, Integer> map = new HashMap<>();
        //start from the last word
        for (int k = words.length - 1; k >= 0; k--) {
          //get the word from subStr
          String word = subStr.substring(k * wordLength, (k + 1) * wordLength);
          int count = getOrDefault(map, word, 0) + 1;
          //if the num of the word is greater than wordMap's, move (k * wordLength) and break
          if (count > getOrDefault(wordMap, word, 0)) {
            j = j + k * wordLength;
            break;
          } else if (k == 0) {
            indices.add(j);
          } else {
            map.put(word, count);
          }
        }
      }

    }
    return indices;
  }

  private int getOrDefault(Map<String, Integer> map, String key, int def) {
    Integer v = map.get(key);
    if (v == null) v = def;
    return v;
  }

  /**
   * 效率比较底下，时间时间复杂度可能为0(n^2)
   */
  public List<Integer> findSubstring2(String s, String[] words) {
    final Map<String, Integer> counts = new HashMap<>();
    for (final String word : words) {
      counts.put(word, getOrDefault(counts, word, 0) + 1);
    }
    final List<Integer> indexes = new ArrayList<>();
    final int n = s.length(), num = words.length, len = words[0].length();
    for (int i = 0; i < n - num * len + 1; i++) {
      final Map<String, Integer> seen = new HashMap<>();
      int j = 0;
      while (j < num) {
        final String word = s.substring(i + j * len, i + (j + 1) * len);
        if (counts.containsKey(word)) {
          seen.put(word, getOrDefault(seen, word, 0) + 1);
          if (seen.get(word) > getOrDefault(counts, word, 0)) {
            break;
          }
        } else {
          break;
        }
        j++;
      }
      if (j == num) {
        indexes.add(i);
      }
    }
    return indexes;
  }
}
