package com.kuranado.problems;

/**
 * 面试题22. 链表中倒数第k个节点
 *
 * @version 1.0.0
 * @author: Xinling Jing
 * @date: 2020-04-02 21:44
 */
public class Test22 {

    public static void main(String[] args) {

        // Test Sample 1 4 -> 5
        //ListNode head = new ListNode(1);
        //head.next = new ListNode(2);
        //head.next.next = new ListNode(3);
        //head.next.next.next = new ListNode(4);
        //head.next.next.next.next = new ListNode(5);
        //ListNode result = getKthFromEnd(head, 2);
        // Test Sample 2 1 - 2 - 3 - 4 -> 5
        //ListNode result = getKthFromEnd(head, 5);
        // Test Sample 3 1 - 2 - 3 - 4 -> 5
        //ListNode result = getKthFromEnd(head, 6);
        // Test Sample 4 1
        //ListNode head = new ListNode(1);
        //ListNode result = getKthFromEnd(head, 1);
        // Test Sample 5 1
        //ListNode head = new ListNode(1);
        //head.next = new ListNode(2);
        //ListNode result = getKthFromEnd(head, 1);
        // Test Sample 6 null
        ListNode head = null;
        ListNode result = getKthFromEnd(head, 1);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public static ListNode getKthFromEnd(ListNode head, int k) {

        if (head == null) {
            return null;
        }

        ListNode first = head;
        ListNode sec = head;

        for (int i = 0; i < k; i++) {
            first = first.next;
            if (first == null) {
                return head;
            }
        }

        while (first != null) {
            first = first.next;
            sec = sec.next;
        }

        return sec;
    }

    static class ListNode {

        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
