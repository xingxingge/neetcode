package com.leetcode;

import org.junit.Test;

public class P24_SwapNodesInPairs {

  @Test
  public void test1() {
    ListNode l1 = Wrapper.stringToListNode("[1,2,3,4,5,6,7]");
    Wrapper.prettyPrintLinkedList(swapPairs(l1));

  }

  /**
   * 双指针方法
   * @param head
   * @return
   */
  public ListNode swapPairs(ListNode head) {
    if (head==null || head.next==null)return head;
    ListNode p1 = head;
    ListNode p2 = head.next;
    ListNode newHead = p2;
    ListNode pre = null;
    while (p1 != null && p2 != null) {
      p1.next = p2.next;
      p2.next = p1;
      if (pre != null) pre.next = p2;
      pre = p1;
      p1 = p1.next;
      if (p1 != null) {
        p2 = p1.next;
      }
    }
    return newHead;
  }
}
