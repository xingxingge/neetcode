package com.topsec.tsm.datastructure;

import com.topsec.tsm.datastructure.list.SLNode;

public abstract class ListUtils {
  /**
   * 检查两个链表是否相交，并获取相交的元素
   *
   * @return Approach 3: Two Pointers
   * Maintain two pointers pApA and pBpB initialized at the head of A and B,
   * respectively. Then let them both traverse through the lists, one node at a time.
   * When pApA reaches the end of a list, then redirect it to the head of B (yes, B, that's right.);
   * similarly when pBpB reaches the end of a list, redirect it the head of A.
   * If at any point pApA meets pBpB, then pApA/pBpB is the intersection node.
   * To see why the above trick would work, consider the following two lists:
   * A = {1,3,5,7,9,11} and B = {2,4,9,11}, which are intersected at node '9'.
   * Since B.length (=4) < A.length (=6), pBpB would reach the end of the merged list first,
   * because pBpB traverses exactly 2 nodes less than pApA does. By redirecting pBpB to head A,
   * and pApA to head B, we now ask pBpB to travel exactly 2 more nodes than pApA would.
   * So in the second iteration, they are guaranteed to reach the intersection node at the same time.
   *
   * If two lists have intersection, then their last nodes must be the same one.
   * So when pApA/pBpB reaches the end of a list, record the last element of A/B respectively.
   * If the two last elements are not the same one, then the two lists have no intersections.
   * Complexity Analysis
   *
   * Time complexity : O(m+n)O(m+n).
   *
   * Space complexity : O(1)O(1).
   */
  public static <E> SLNode<E> getIntersectionNode(SLNode<E> headA, SLNode<E> headB) {
    if (headA == null || headB == null) {
      return null;
    }
    SLNode<E> p1 = headA;
    SLNode<E> p2 = headB;
    if (p1 == p2) return p1;
    while (true) {
      p1 = p1.getNext();
      p2 = p2.getNext();

      if (p1 == null && p2 == null) return null;
      if (p1 == null) {
        p1 = headB;
      }
      if (p2 == null) {
        p2 = headA;
      }
      if (p1 == p2) return p1;
    }
  }

}
