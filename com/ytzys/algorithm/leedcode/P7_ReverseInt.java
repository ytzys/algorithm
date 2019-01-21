package com.ytzys.algorithm.leedcode;

import org.junit.Test;

public class P7_ReverseInt {

    /**
     * 相对于 reverse 方法，使用了 ListNode 链表存储各位数字
     * 以空间换时间，节省了重复的除法和取模运算
     */
    @Test
    public void test() {
        System.out.println(reverse2(-2147483641));
    }

    private int reverse3(int x) {
        int result = 0;
        int border1 = Integer.MAX_VALUE / 10;
        int border2 = Integer.MIN_VALUE / 10;
        while (x != 0) {
            if (result > border1 || result < border2) {
                return 0;
            }
            result = result * 10 + x % 10;
            x /= 10;
        }
        return result;
    }

    private int reverse2(int x) {
        int result = 0;
        int border = Integer.MAX_VALUE / 10;
        while (x != 0) {
            if (x > 0 ? result > border : -result > border) {
                return 0;
            }
            result = result * 10 + x % 10;
            x /= 10;
        }
        return result;
    }

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
