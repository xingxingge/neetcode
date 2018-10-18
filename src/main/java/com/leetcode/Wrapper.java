package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Wrapper {
  public static void mai(String[] args){
	System.out.println("ff");
	printArray( new int[]{1,2});
  }
  public static int[] stringToIntegerArray(String input) {
    input = input.trim();
    input = input.substring(1, input.length() - 1);
    if (input.length() == 0) {
      return new int[0];
    }

    String[] parts = input.split(",");
    int[] output = new int[parts.length];
    for (int index = 0; index < parts.length; index++) {
      String part = parts[index].trim();
      output[index] = Integer.parseInt(part);
    }
    return output;
  }

  public static ListNode stringToListNode(String input) {
    // Generate array from the input
    int[] nodeValues = stringToIntegerArray(input);

    // Now convert that list into linked list
    ListNode dummyRoot = new ListNode(0);
    ListNode ptr = dummyRoot;
    for (int item : nodeValues) {
      ptr.next = new ListNode(item);
      ptr = ptr.next;
    }
    return dummyRoot.next;
  }

  public static void printArray(int[] nums) {
    if (nums == null) {
      System.out.println(nums);
      return;
    }
    System.out.print("[");
    for (int i = 0; i < nums.length; i++) {
      System.out.print(nums[i]);
      if (i != nums.length - 1) {
        System.out.print(",");
      }

    }
    System.out.println("]");
  }

  public static void prettyPrintLinkedList(ListNode node) {
    while (node != null && node.next != null) {
      System.out.print(node.val + "->");
      node = node.next;
    }

    if (node != null) {
      System.out.println(node.val);
    } else {
      System.out.println("Empty LinkedList");
    }
  }


  /**
   * 二叉树
   */
  public static String treeNodeToString(TreeNode root) {
    if (root == null) {
      return "[]";
    }

    String output = "";
    Queue<TreeNode> nodeQueue = new LinkedList<>();
    nodeQueue.add(root);
    while (!nodeQueue.isEmpty()) {
      TreeNode node = nodeQueue.remove();

      if (node == null) {
        output += "null, ";
        continue;
      }

      output += String.valueOf(node.val) + ", ";
      nodeQueue.add(node.left);
      nodeQueue.add(node.right);
    }
    return "[" + output.substring(0, output.length() - 2) + "]";
  }

  public static TreeNode stringToTreeNode(String input) {
    input = input.trim();
    input = input.substring(1, input.length() - 1);
    if (input.length() == 0) {
      return null;
    }

    String[] parts = input.split(",");
    String item = parts[0];
    TreeNode root = new TreeNode(Integer.parseInt(item));
    Queue<TreeNode> nodeQueue = new LinkedList<>();
    nodeQueue.add(root);

    int index = 1;
    while (!nodeQueue.isEmpty()) {
      TreeNode node = nodeQueue.remove();

      if (index == parts.length) {
        break;
      }

      item = parts[index++];
      item = item.trim();
      if (!item.equals("null")) {
        int leftNumber = Integer.parseInt(item);
        node.left = new TreeNode(leftNumber);
        nodeQueue.add(node.left);
      }

      if (index == parts.length) {
        break;
      }

      item = parts[index++];
      item = item.trim();
      if (!item.equals("null")) {
        int rightNumber = Integer.parseInt(item);
        node.right = new TreeNode(rightNumber);
        nodeQueue.add(node.right);
      }
    }
    return root;
  }

  public static void prettyPrintTree(TreeNode node, String prefix, boolean isLeft) {
    if (node == null) {
      System.out.println("Empty tree");
      return;
    }

    if (node.right != null) {
      prettyPrintTree(node.right, prefix + (isLeft ? "│   " : "    "), false);
    }

    System.out.println(prefix + (isLeft ? "└── " : "┌── ") + node.val);

    if (node.left != null) {
      prettyPrintTree(node.left, prefix + (isLeft ? "    " : "│   "), true);
    }
  }

  public static void prettyPrintTree(TreeNode node) {
    prettyPrintTree(node, "", true);
  }

}
