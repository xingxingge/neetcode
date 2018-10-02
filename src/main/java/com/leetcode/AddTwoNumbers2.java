package com.leetcode;

import org.junit.Test;

/**
 *
 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，
 它们的每个节点只存储单个数字。将两数相加返回一个新的链表。

 你可以假设除了数字 0 之外，这两个数字都不会以零开头。

 示例：

 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出：7 -> 0 -> 8
 原因：342 + 465 = 807
 */
public class AddTwoNumbers2 {

  @Test
  public void test() {
    ListNode l1 = new ListNode(9);
    ListNode l2 = new ListNode(9);
    ListNode l3 = new ListNode(9);
    ListNode l4 = new ListNode(9);

    ListNode r1 = new ListNode(9);
    ListNode r2 = new ListNode(9);
    ListNode r3 = new ListNode(9);
    ListNode r4 = new ListNode(8);
    l1.next = l2;
    l2.next = l3;
    l3.next = l4;
    r1.next = r2;
    r2.next = r3;
    r3.next = r4;

    ListNode listNode = addTwoNumbers2(l1, r1);

    while (listNode != null) {
      System.out.println(listNode.val);
      listNode = listNode.next;
    }
  }

  /**
   * 复杂度分析

   时间复杂度：O(max(m,n))，假设 m 和 n 分别表示 l1 和 l2 的长度，上面的算法最多重复 max(m,n) 次。

   空间复杂度：O(max(m,n))， 新列表的长度最多为 max(m,n)+1。
   * @param l1
   * @param l2
   * @return
   */

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode headNode = new ListNode(0);
    ListNode currentNode = headNode;
    ListNode l = l1;
    ListNode r = l2;
    int carry = 0;//当前位置的进位
    while (l != null || r != null) {
      int x = (l == null ? 0 : l.val);
      int y = (r == null ? 0 : r.val);
      int sum = x + y + carry;//加上进位的总和
      carry = sum / 10; //进位
      currentNode.next = new ListNode(sum % 10);//下一位
      currentNode = currentNode.next;
      if (l != null) l = l.next;
      if (r != null) r = r.next;
    }
    if (carry>0){
      currentNode.next=new ListNode(carry);
    }
    return headNode.next;
  }

  public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;

    ListNode l = l1;
    ListNode r = l2;
    ListNode firstNode = new ListNode(0);
    ListNode currentNode = firstNode;
    int carry = 0;//当前位置的进位
    while (true) {

      int x = (l == null ? 0 : l.val);
      int y = (r == null ? 0 : r.val);
      int sum = x + y + carry;//加上进位的总和
      int currentValue = sum % 10;//当前节点
      carry = sum / 10; //进位
      currentNode.val = currentValue;

      l = (l == null ? null : l.next);
      r = (r == null ? null : r.next);
      if (l == null && r == null) {
        if (carry > 0) {
          currentNode.next = new ListNode(carry);
        } else {
          currentNode.next = null;
        }
        break;
      } else {
        currentNode.next = new ListNode(0);
        currentNode = currentNode.next;
      }
    }


    return firstNode;
  }
}


