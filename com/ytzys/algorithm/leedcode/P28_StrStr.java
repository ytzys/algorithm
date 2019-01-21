package com.ytzys.algorithm.leedcode;

import org.junit.Test;

/**
 * Created by ZhangYisu on 2019/1/19.
 */
public class P28_StrStr {
    @Test
    public void test() {
        System.out.println(strStr("134423", "44"));
    }

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.equals("")) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;
            int k = i;
            for (; j < needle.length(); j++, k++) {
                if (haystack.charAt(k) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }
}
