package com.kuranado.problems;

/**
 * 206. 反转链表
 *
 * @version 1.0.0
 * @author: Xinling Jing
 * @date: 2020-03-30 21:19
 */
public class Test18 {

    public static void main(String[] args) {
        // Test Sample 1
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        // Test Sample 2
        //ListNode l1 = new ListNode(1);
        //while (l1 != null) {
        //    System.out.println(l1.val);
        //    l1 = l1.next;
        //}
        ListNode result = reverseListNode3(l1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    /**
     * 迭代遍历法-直接更改形参，IDEA 不建议直接更改形参，所以不推荐
     */
    public static ListNode reverseListNode(ListNode currentNode) {

        if (currentNode == null) {
            return null;
        }

        ListNode nextNode = currentNode.next;
        currentNode.next = null;

        while (nextNode != null) {
            ListNode temp = nextNode.next;
            nextNode.next = currentNode;
            currentNode = nextNode;
            nextNode = temp;
        }

        return currentNode;
    }

    /**
     * 迭代遍历法-不更改形参
     */
    public static ListNode reverseListNode2(ListNode currentNode) {

        if (currentNode == null) {
            return null;
        }

        ListNode nextNode = currentNode.next;
        currentNode.next = null;
        ListNode finalNode = currentNode;

        while (nextNode != null) {
            ListNode temp = nextNode.next;
            nextNode.next = finalNode;
            finalNode = nextNode;
            nextNode = temp;
        }

        return finalNode;
    }

    /**
     * 递归法
     */
    public static ListNode reverseListNode3(ListNode currentNode) {

        if (currentNode == null || currentNode.next == null) {
            return currentNode;
        }
        ListNode returnNode = reverseListNode3(currentNode.next);
        currentNode.next.next = currentNode;
        currentNode.next = null;
        return returnNode;
    }

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
