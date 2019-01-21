package com.ytzys.algorithm.leedcode;

import org.junit.Test;

/**
 * Created by ZhangYisu on 2019/1/21.
 */
public class P58_LengthOfLastWord {
    @Test
    public void test() {
        System.out.println(lengthOfLastWord1("hello worlxd "));
    }

    public int lengthOfLastWord2(String s) {
        int lastNoneSpaceIndex = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ' && lastNoneSpaceIndex == -1) {
                lastNoneSpaceIndex = i;
            } else if (s.charAt(i) == ' ' && lastNoneSpaceIndex != -1)
                return lastNoneSpaceIndex - i;
        }
        if (lastNoneSpaceIndex == -1)
            return 0;
        else
            return lastNoneSpaceIndex + 1;
    }

    /**
     * This method is slower than lengthOfLastWord! Can you beleive that?
     * I think it's because in the method lengthOfLastWord, there are two comparations
     * at most in every loop, but in this method, there are four. So we can say that,
     * so called opitmization doesn't work all the time.
     *
     * @param s
     * @return
     */
    public int lengthOfLastWord1(String s) {
        int lastNoneSpaceIndex = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ' && lastNoneSpaceIndex == -1) {
                lastNoneSpaceIndex = i;
            }
            if (s.charAt(i) == ' ' && lastNoneSpaceIndex != -1)
                return lastNoneSpaceIndex - i;
        }
        if (lastNoneSpaceIndex == -1)
            return 0;
        else
            return lastNoneSpaceIndex + 1;
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
