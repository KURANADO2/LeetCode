package com.kuranado.problems;

/**
 * 2 两数相加
 *
 * @Author: Xinling Jing
 * @Date: 2020/3/15 17:51
 */
public class Test2 {

    public static void main(String[] args) {

        // Test Sample 1
        //ListNode l1 = new ListNode(2);
        //l1.next = new ListNode(4);
        //l1.next.next = new ListNode(3);
        //ListNode l2 = new ListNode(5);
        //l2.next = new ListNode(6);
        //l2.next.next = new ListNode(4);
        //ListNode result = addTwoNumbers(l1, l2);

        // Test Sample 2
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(6);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(1);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(8);
        ListNode l2 = new ListNode(4);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(3);
        l2.next.next.next = new ListNode(8);
        l2.next.next.next.next = new ListNode(5);
        ListNode result = addTwoNumbers(l1, l2);

        //ListNode l1 = new ListNode(7);
        //ListNode l2 = new ListNode(8);
        //ListNode result = addTwoNumbers(l1, l2);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            l1 = new ListNode(0);
        }
        if (l2 == null) {
            l2 = new ListNode(0);
        }
        int x = l1.val + l2.val;
        ListNode r = new ListNode(x % 10);
        if (l1.next != null || l2.next != null) {
            if (x >= 10) {
                if (l1.next != null) {
                    l1.next.val += 1;
                } else {
                    l2.next.val += 1;
                }
            }
            r.next = addTwoNumbers(l1.next, l2.next);
        } else {
            if (x >= 10) {
                r.next = new ListNode(1);
            }
        }
        return r;
    }

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
