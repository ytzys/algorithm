package com.ytzys.algorithm.leedcode;

import org.junit.Test;

public class P14_LongestCommonPrefix {

    @Test
    public void test() {
        String[] strArr = {"zhangyisu", "zhangyimou", "zhangyixing"};
        System.out.println(longestCommonPrefix(strArr));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            result = commonPrefix(result, strs[i]);
            if (result.equals("")) break;
        }
        return result;
    }

    private String commonPrefix(String result, String str) {
        int index = 0;
        while (index < result.length() && index < str.length()) {
            if (result.charAt(index) == str.charAt(index)) {
                index++;
            } else {
                break;
            }
        }
        return result.substring(0, index);
    }

}
