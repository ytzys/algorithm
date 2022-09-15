package com.ytzys.algorithm.leedcode;

import org.junit.Test;

public class P0026_RemoveDuplicatesFromSortedArray {
    @Test
    public void test() {
        int[] arr = new int[]{1, 1, 2};
        int tmp = removeDuplicates(arr);
        System.out.println(tmp);
        for (int i = 0; i < tmp; i++) {
            System.out.println(arr[i]);
        }
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int curNum = nums[0];
        int curCerticatingIndex = 0;
        int index = 1;
        while (index < nums.length) {
            int tmp = nums[index];
            if (tmp != curNum) {
                curCerticatingIndex++;
                nums[curCerticatingIndex] = tmp;
                curNum = tmp;
            }
            index++;
        }
        return curCerticatingIndex + 1;
    }
}
