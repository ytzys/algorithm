package com.ytzys.algorithm.leedcode;

import org.junit.Test;

public class P53_MaximumSubarray {
    @Test
    public void test1() {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        assert (maxSubArray1(arr) == 6);
        System.out.println(maxSubArray1(arr));
    }

    @Test
    public void test2() {
        int[] arr = {1, 2, -1, -2, 2, 1, -2, 1};
        assert (maxSubArray1(arr) == 3);
        System.out.println(maxSubArray1(arr));
    }

    @Test
    public void test3() {
        int[] arr = {0};
        assert (maxSubArray1(arr) == 0);
        System.out.println(maxSubArray1(arr));
    }

    @Test
    public void test4() {
        int[] arr = {-2, 1, 0};
        assert (maxSubArray1(arr) == 1);
        System.out.println(maxSubArray1(arr));
    }

    @Test
    public void test5() {
        int[] arr = {-1};
        assert (maxSubArray1(arr) == -1);
        System.out.println(maxSubArray1(arr));
    }

    @Test
    public void test6() {
        int[] arr = {1, -2, 0};
        assert (maxSubArray1(arr) == 1);
        System.out.println(maxSubArray1(arr));
    }

    @Test
    public void test7() {
        int[] arr = {2, 0, -3, 2, 1, 0, 1, -2};
        assert (maxSubArray1(arr) == 4);
        System.out.println(maxSubArray1(arr));
    }

    @Test
    public void test8() {
        int[] arr = {2, -1, -1, 2, 0, -3, 3};
        assert (maxSubArray1(arr) == 3);
        System.out.println(maxSubArray1(arr));
    }

    public int maxSubArray1(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        boolean ltr = true;
        while (i < j) {
            if (nums[i] <= 0 && nums[j] > 0) {
                i++;
                continue;
            }
            if (nums[j] <= 0 && nums[i] > 0) {
                j--;
                continue;
            }
            if (nums[i] <= 0 && nums[j] <= 0) {
                if (nums[i] < nums[j]) {
                    i++;
                } else {
                    j--;
                }
                continue;
            }
            int m = 1;
            int tmp1 = 0;
            int tmp2 = 0;
            if (ltr) {
                tmp1 = nums[i];
                tmp2 = 0;
                while (i + m < nums.length && nums[i + m] >= 0) {
                    tmp1 += nums[i + m];
                    m++;
                }
                while (i + m < nums.length && nums[i + m] < 0) {
                    tmp2 += nums[i + m];
                    m++;
                }
                if (tmp1 + tmp2 < 0) {
                    i = i + m;
                } else {
                    ltr = false;
                }
            } else {
                m = 1;
                tmp1 = nums[j];
                tmp2 = 0;
                while (j - m >= i && nums[j - m] >= 0) {
                    tmp1 += nums[j - m];
                    m++;
                }
                while (j - m >= i && nums[j - m] < 0) {
                    tmp2 += nums[j - m];
                    m++;
                }
                if (tmp1 + tmp2 < 0) {
                    j = j - m;
                } else {
                    break;
                }
            }
        }
        int result = 0;
        for (int k = i; k <= j; k++) {
            result += nums[k];

        }
        return result;
    }

    /**
     * It seems that this solution is only adapt to the sutuation in which there are both
     * positive and negative numbers in the array.
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (true) {
            if (nums[i] < 0) {
                i++;
                continue;
            }
            int m = 1;
            int tmp1 = nums[i], tmp2 = 0;
            while (i + m < nums.length && nums[i + m] > 0) {
                tmp1 += nums[i + m];
                m++;
            }
            while (i + m < nums.length && nums[i + m] < 0) {
                tmp2 += nums[i + m];
                m++;
            }
            if (tmp1 + tmp2 < 0) {
                i = i + m;
            } else {
                break;
            }
        }
        while (i <= j) {
            if (nums[j] < 0) {
                j--;
                continue;
            }
            int m = 1;
            int tmp1 = nums[j], tmp2 = 0;
            while (j - m >= i && nums[j - m] > 0) {
                tmp1 += nums[j - m];
                m++;
            }
            while (j - m >= i && nums[j - m] < 0) {
                tmp2 += nums[j - m];
                m++;
            }
            if (tmp1 + tmp2 < 0) {
                j = j - m;
            } else {
                break;
            }
        }
        int result = 0;
        for (int k = i; k <= j; k++) {
            result += nums[k];

        }
        return result;
    }
}
