package com.ytzys.algorithm.leedcode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class P0003_LongestSubstringWithoutRepeatingCharacters {

    // 8ms
    public static int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        if (arr.length == 0) {
            return 0;
        }
        int result = 1;
        int start = 0, end = 0;
        while (start < arr.length && end < arr.length) {
            if (start == end) {
                end = start + 1;
            }
            for (int k = start; k < end && end < arr.length; k++) {
                if (arr[end] == arr[k]) {
                    if (end - start > result)
                        result = end - start;
                    start = k + 1;
                    break;
                } else {
                    if (k == end - 1) {
                        end++;
                        if (end == arr.length) {
                            if (end - start > result)
                                result = end - start;
                        }
                        break;
                    }
                }
            }
        }
        return result;
    }

    // 4ms
    public static int lengthOfLongestSubstring2(String s) {
        int[] tab = new int[128];
        Arrays.fill(tab, -1);
        int result = 0;
        int l = 0, r = 0;
        while (r < s.length()) {
            char a = s.charAt(r);
            l = Math.max(tab[a] + 1, l);
            result = Math.max(r - l + 1, result);
            tab[a] = r;
            r++;
        }

        return result;
    }

    public static int lengthOfLongestSubstring3(String s) {
        int[] tab = new int[128];
        int result = 0;
        int l = 0, r = 0;
        while (r < s.length()) {
            char a = s.charAt(r);
            l = Math.max(tab[a], l);
            result = Math.max(r - l + 1, result);
            tab[a] = r + 1;
            r++;
        }

        return result;
    }

    public static void main(String[] args) {
        String a = "abcabcbb";
        System.out.println(lengthOfLongestSubstring3(a));
    }
}
