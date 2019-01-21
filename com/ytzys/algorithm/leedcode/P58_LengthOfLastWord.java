package com.ytzys.algorithm.leedcode;

import org.junit.Test;

/**
 * Created by ZhangYisu on 2019/1/21.
 */
public class P58_LengthOfLastWord {
    @Test
    public void test() {
        System.out.println(lengthOfLastWord("hello worlxd "));
    }

    public int lengthOfLastWord(String s) {
        if (s.length() == 1) {
            if (s.charAt(0) == ' ') {
                return 0;
            } else {
                return 1;
            }
        }
//        int i = s.length() - 1;
//        if (s.charAt(s.length() - 1) == ' ') {
//            i = s.length() - 2;
//        }
        int lastNoneSpaceIndex = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                if (lastNoneSpaceIndex == -1) {
                    lastNoneSpaceIndex = i;
                }
            } else {
                if (lastNoneSpaceIndex != -1)
                    return lastNoneSpaceIndex - i;
            }
        }
        if (lastNoneSpaceIndex == -1)
            return 0;
        else
            return lastNoneSpaceIndex + 1;
    }
}
