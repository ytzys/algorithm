package com.ytzys.algorithm.leedcode;

import android.support.annotation.Nullable;

import org.junit.Test;

/**
 * Created by ZhangYisu on 2019/1/12.
 */
public class AddTwoNumbers2 {
    @Test
    public void test() {
        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(6);
        l1.next.next = new ListNode(7);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(7);

        traverse(addTwoNumbers(l1, l2));
    }

    private void traverse(ListNode list) {
        ListNode point = list;
        while (point != null) {
            System.out.println(point.val);
            point = point.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        long sum = getValue(l1) + getValue(l2);
        ListNode result = new ListNode(0); // add a head node
        ListNode pre = result;
        boolean carry = false;
        ListNode point1 = l1;
        ListNode point2 = l2;
        while (point1 != null || point2 != null) {
            if (point1 != null && point2 != null) {
                int first = point1.val;
                int second = point2.val;
                carry = common(pre, carry, first, second);
                point1 = point1.next;
                point2 = point2.next;
            } else if (point1 == null) {
                int first = 0;
                int second = point2.val;
                carry = common(pre, carry, first, second);
                point2 = point2.next;
            } else {
                int first = point1.val;
                int second = 0;
                carry = common(pre, carry, first, second);
                point1 = point1.next;
            }
            pre = pre.next;
        }
        if (carry) {
            pre.next = new ListNode(1);
        }
        result = result.next; // delete the head node
        return result;
    }

    private boolean common(ListNode pre, boolean carry, int first, int second) {
        int tmp;
        if (carry) {
            tmp = first + second + 1;
        } else {
            tmp = first + second;
        }
        if (tmp >= 10) {
            carry = true;
            pre.next = new ListNode(tmp % 10);
        } else {
            carry = false;
            pre.next = new ListNode(tmp);
        }
        return carry;
    }

    //***********think too simply**********//

    @Nullable
    private ListNode getListNode(long sum) {
        if (sum == 0) {
            ListNode tmp = new ListNode((int) sum);
            return tmp;
        }
        ListNode result = null;
        ListNode pre = null;
        while (sum != 0) {
            ListNode tmp = new ListNode((int) (sum % 10));
            if (result == null) {
                result = tmp;
            } else {
                pre.next = tmp;
            }
            pre = tmp;
            sum /= 10;
        }
        return result;
    }

    private long getValue(ListNode list) {
        ListNode point = list;
        long result = 0;
        long base = 1;
        while (point != null) {
            result += point.val * base;
            base *= 10;
            point = point.next;
        }
        return result;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
