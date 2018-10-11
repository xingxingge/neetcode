package com.leetcode;

public class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }

  public void display() {
    ListNode l = this;
    while (l != null) {
      System.out.print(l.val);
      l = l.next;
      if (l != null) {
        System.out.print(",");
      }else{
        System.out.println("");
      }
    }

  }
}
