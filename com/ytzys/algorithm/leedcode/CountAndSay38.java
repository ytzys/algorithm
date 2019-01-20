package com.ytzys.algorithm.leedcode;

import org.junit.Test;

/**
 * Created by ZhangYisu on 2019/1/20.
 */
public class CountAndSay38 {
    @Test
    public void test() {
        System.out.println(countAndSay(3));
    }

    /**
     * TODO waiting for optimising
     *
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        String[] result = new String[n];
        result[0] = "1";
        for (int i = 1; i < result.length; i++) {
            String target = result[i - 1];
            char curCar = target.charAt(0);
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int j = 1; j < target.length(); j++) {
                if (target.charAt(j) == curCar) {
                    count++;
                } else {
                    sb.append(count).append(curCar);
                    curCar = target.charAt(j);
                    count = 1;
                }
            }
            sb.append(count).append(curCar);
            result[i] = sb.toString();
        }
//        for (String tmp : result) {
//            System.out.println(tmp);
//        }
        return result[n - 1];
    }

}
