package com.leetcode;

import org.junit.Test;

public class P21_MergeTwoSortedLists {
  @Test
  public void test() {
    ListNode l1 = new ListNode(1);
    ListNode l2 = new ListNode(2);
    ListNode l3 = new ListNode(2);
    ListNode l4 = new ListNode(4);

    ListNode r1 = new ListNode(1);
    ListNode r2 = new ListNode(3);
    ListNode r3 = new ListNode(3);
    ListNode r4 = new ListNode(4);
    l1.next = l2;
    l2.next = l3;
    l3.next = l4;

    r1.next = r2;
    r2.next = r3;
    r3.next = r4;

    mergeTwoLists2(l1, r1).display();
  }

  @Test
  public void test2() {
    ListNode l1 = new ListNode(3);
    ListNode r1 = new ListNode(1);
    mergeTwoLists2(l1, r1).display();
  }

  @Test
  public void test3() {
    ListNode l1 = new ListNode(1);
    ListNode l2 = new ListNode(3);
    l1.next = l2;
    ListNode r1 = new ListNode(0);
    mergeTwoLists2(l1, r1).display();
  }


  /**
   * 递归写法
   */
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;
    if (l1.val < l2.val) {
      l1.next = mergeTwoLists(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeTwoLists(l1, l2.next);
      return l2;
    }
  }

  /**
   * 根据问题描述写法
   */
  public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;
    ListNode h;
    //initialize the first node
    if (l1.val < l2.val) {
      h = l1;
      l1 = l1.next;
    } else {
      h = l2;
      l2 = l2.next;
    }
    ListNode curr = h;//current node
    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        while (l1 != null && l1.val <= l2.val) {
          curr.next = l1;
          curr = curr.next;
          l1 = l1.next;
        }
      } else {
        while (l2 != null && l2.val <= l1.val) {
          curr.next = l2;
          curr = curr.next;
          l2 = l2.next;
        }
      }
    }
    if (l1 == null) curr.next = l2;
    if (l2 == null) curr.next = l1;
    return h;
  }
}
