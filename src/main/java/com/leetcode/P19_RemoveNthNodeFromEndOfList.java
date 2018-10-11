package com.leetcode;

import org.junit.Test;

/**
 * 移除倒数第几个元素
 */
public class P19_RemoveNthNodeFromEndOfList {
  @Test
  public void test1() {
    ListNode l1 = new ListNode(1);
    ListNode l2 = new ListNode(2);
    ListNode l3 = new ListNode(3);
    ListNode l4 = new ListNode(4);
    ListNode l5 = new ListNode(5);
    ListNode l6 = new ListNode(6);
    l1.next = l2;
    l2.next = l3;
    l3.next = l4;
    l4.next = l5;
    l5.next = l6;
    ListNode listNode = removeNthFromEnd(l1, 1);
    listNode.display();
  }

  public ListNode removeNthFromEnd(ListNode head, int n) {
    if (n <= 0) return head;
    ListNode h = head;
    ListNode[] nodes = new ListNode[n + 1];
    int size = 0;
    int end = 0;
    while (head != null) {
      end = size % (n + 1);
      nodes[end] = head;
      size++;
      head = head.next;
    }
    if (size < n) {
      return h;
    }
    if (size == n) {
      return h.next;
    }
    int index = 0;
    if (end < n) index = end + 1;
    ListNode pre = nodes[index];
    ListNode t = pre.next;
    pre.next = t.next;
    t.next = null;
    return h;

  }
}
