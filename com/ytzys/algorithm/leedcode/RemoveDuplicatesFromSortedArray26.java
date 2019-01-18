package com.ytzys.algorithm.leedcode;

import org.junit.Test;

public class RemoveDuplicatesFromSortedArray26 {
    @Test
    public void test() {
        int[] arr = new int[]{0, 0, 0, 1, 1, 1, 3, 4, 5};
        int tmp = removeDuplicates(arr);
        System.out.println(tmp);
        for (int i = 0; i <= tmp; i++) {

        }
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int curNum = nums[0];
        int curCerticatingIndex = 1;
        int index = 1;
        while (index < nums.length) {
            int tmp = nums[index];
            if (tmp != curNum) {
                nums[curCerticatingIndex] = tmp;
                curCerticatingIndex++;
                curNum = tmp;
            }
            index++;
        }
        return curCerticatingIndex;
    }
}
