package com.ytzys.algorithm.leedcode;

import org.junit.Test;

public class P0009_IsPalindrome {
    @Test
    public void test() {
        System.out.println(isPalindrome(123));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        ListNode list = null;
        ListNode pre = null;
//        int count = 0;
        while (x != 0) {
//            count++;
            ListNode node = new ListNode(x % 10);
            if (pre == null) {
                pre = node;
                list = pre;
            } else {
                node.pre = pre;
                pre.next = node;
                pre = node;
            }
            x /= 10;
        }
        ListNode head = list;
        ListNode tail = pre;
//        if (count % 2 == 0) {
//            while (head.pre != tail) {
//                if (head.value != tail.value) {
//                    return false;
//                }
//                head = head.next;
//                tail = tail.pre;
//            }
//            return true;
//        } else {
        while (head != tail && head.pre != tail) {
            if (head.value != tail.value) {
                return false;
            }
            head = head.next;
            tail = tail.pre;
        }
        return true;
//        }
    }

    class ListNode {
        ListNode pre;
        ListNode next;
        int value;

        public ListNode(int value) {
            this.value = value;
        }
    }
}
