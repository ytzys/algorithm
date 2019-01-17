package com.ytzys.algorithm.leedcode;

public class ReverseInt7 {

    private int reverse1(int x) {
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        int negative = 1;
        if (x < 0) {
            x = -x;
            negative = -1;
        }
        ListNode list = null;
        ListNode pre = null;
        int base = 0;
        while (x != 0) {
            if (pre == null) {
                pre = new ListNode(x % 10);
                list = pre;
            } else {
                pre.next = new ListNode(x % 10);
                pre = pre.next;
            }
            x /= 10;
            if (base == 0) {
                base = 1;
            } else {
                base *= 10;
            }
        }
//        ListNode point1 = list;
//        while (point1 != null) {
//            System.out.println(point1.value);
//            point1 = point1.next;
//        }
//        System.out.println(base);
        if (base == 1000000000 && list.value > 2) {
            return 0;
        }
        int result = 0;
        ListNode point = list;
        while (point != null) {
            result += point.value * base;
            if (result < 0) {
                result = 0;
                break;
            }
            base /= 10;
            point = point.next;
        }
        return result * negative;
    }

    private int reverse(int x) {
        int result = 0;
        int base = 1;
        int tmp = x / 10;
        while (tmp != 0) {
            base *= 10;
            tmp /= 10;
        }
        int negative = 1;
        if (x < 0) {
            x = -x;
            negative = -1;
        }
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        while (x != 0) {
            int last = x % 10;
            if (base == 1000000000 && last > 2) {
                result = 0;
                break;
            }
            result += base * last;
            if (result < 0) {
                result = 0;
                break;
            }
            x /= 10;
            base /= 10;
        }
        return result * negative;
    }

    class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }
}
