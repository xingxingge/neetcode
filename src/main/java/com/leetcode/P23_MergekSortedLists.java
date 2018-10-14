package com.leetcode;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P23_MergekSortedLists {
  ListNode l1 = Wrapper.stringToListNode("[1,3,4,5]");
  ListNode l2 = Wrapper.stringToListNode("[1,2,3,4]");
  ListNode l3 = Wrapper.stringToListNode("[3,3,5,7]");
  ListNode l4 = Wrapper.stringToListNode("[2,2,3,4]");
  ListNode l5 = Wrapper.stringToListNode("[2,2,3,4]");
  ListNode[] listNodes = new ListNode[]{l1, l2, l3, l4, l5};

  @Test
  public void test1() {
    ListNode listNode = mergeKLists(listNodes);
    Wrapper.prettyPrintLinkedList(listNode);
  }

  @Test
  public void test2() {
    ListNode listNode = mergeKLists2(listNodes);
    Wrapper.prettyPrintLinkedList(listNode);
  }

  @Test
  public void test3() {
    ListNode listNode = mergeKLists3(listNodes);
    Wrapper.prettyPrintLinkedList(listNode);
  }

  /**
   * n和n-1各merge
   */
  public ListNode mergeKLists(ListNode[] lists) {
    ListNode l = null;
    for (int i = 0; i < lists.length; i++) {
      l = mergeTwoLists(l, lists[i]);
    }
    return l;
  }

  /**
   * 分治法，先两两合并，再组合
   */
  public ListNode mergeKLists2(ListNode[] lists) {
    return partition(lists, 0, lists.length - 1);
  }

  public ListNode partition(ListNode[] lists, int start, int end) {
    if (start == end) return lists[start];
    if (start < end) {
      int mid = (start + end) / 2;
      ListNode l1 = partition(lists, start, mid);
      ListNode l2 = partition(lists, mid + 1, end);
      return mergeTwoLists(l1, l2);
    } else {
      return null;
    }
  }

  /**
   * 使用java优先级队列
   */
  public ListNode mergeKLists3(ListNode[] lists) {

    if (lists == null || lists.length == 0) {
      return null;
    }

    PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
      @Override
      public int compare(ListNode o1, ListNode o2) {
        return o1.val - o2.val;
      }
    });
    for (ListNode node : lists) {
      if (node != null) {
        queue.add(node);
      }
    }
    ListNode head = new ListNode(0);
    ListNode tail = head;
    while (!queue.isEmpty()) {
      tail.next = queue.poll();
      tail = tail.next;

      if (tail.next != null) {
        queue.add(tail.next);
      }
    }
    return head.next;
  }

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

}
