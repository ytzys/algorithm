package com.ytzys.algorithm.leedcode;

import org.junit.Test;

/**
 * Created by ZhangYisu on 2019/1/19.
 */
public class RemoveElement27 {
    @Test
    public void test() {
        int[] arr = new int[]{2, 2, 1};
        System.out.println(removeElement(arr, 2));
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public int removeElement(int[] nums, int val) {
        int curIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[curIndex] = nums[i];
                curIndex++;
            }
        }
        return curIndex;
    }
}
