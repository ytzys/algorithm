package com.ytzys.algorithm.leedcode;

import org.junit.Test;

/**
 * Created by ZhangYisu on 2019/1/20.
 */
public class P0035_SearchInsertPosition {
    @Test
    public void test() {
        System.out.println(searchInsert(new int[]{1, 2, 3, 5}, 6));
    }

    public int searchInsert(int[] nums, int target) {
        int index = 0;
        for (; index < nums.length; index++) {
            if (nums[index] >= target) {
                return index;
            }
        }
        return index;
    }
}
