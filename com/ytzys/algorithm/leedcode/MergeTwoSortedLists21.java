package com.ytzys.algorithm.leedcode;

import org.junit.Test;

public class MergeTwoSortedLists21 {
    @Test
    public void test() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(10);
        l1.next.next = new ListNode(12);

        ListNode l2 = new ListNode(-1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(19);

        ListNode result = mergeTwoLists(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode point1 = l1;
        ListNode point2 = l2;
        ListNode result = null;
        ListNode pre = null;
        while (point1 != null || point2 != null) {
            ListNode gotIt = null;
//            if (point1 != null && point2 != null) {
//                if (point1.val <= point2.val) {
//                    gotIt = point1;
//                    point1 = point1.next;
//                } else {
//                    gotIt = point2;
//                    point2 = point2.next;
//                }
//            } else if (point2 == null) {
//                gotIt = point1;
//                point1 = point1.next;
//            } else {
//                gotIt = point2;
//                point2 = point2.next;
//            }
            if ((point1 != null && point2 != null && point1.val <= point2.val)
                    || point2 == null) {
                gotIt = point1;
                point1 = point1.next;
            } else {
                gotIt = point2;
                point2 = point2.next;
            }

            if (pre == null) {
                pre = gotIt;
                result = pre;
            } else {
                pre.next = gotIt;
                pre = pre.next;
            }
        }
        return result;
    }
}
