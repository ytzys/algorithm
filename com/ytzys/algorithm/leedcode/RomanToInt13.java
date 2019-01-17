package com.ytzys.algorithm.leedcode;

import org.junit.Test;

public class RomanToInt13 {
    @Test
    public void test() {
        System.out.println(romanToInt("MCMXCIV"));
//        System.out.println(romanToInt("III"));
//        System.out.println("z".equals("zys".charAt(0)));
    }

    public int convert(String x) {
        switch (x) {
            case "I":
                return 1;
            case "V":
                return 5;
            case "X":
                return 10;
            case "L":
                return 50;
            case "C":
                return 100;
            case "D":
                return 500;
            case "M":
                return 1000;

            case "IV":
                return 4;
            case "IX":
                return 9;
            case "XL":
                return 40;
            case "XC":
                return 90;
            case "CD":
                return 400;
            case "CM":
                return 900;
            default:
                return 0;
        }
    }

    public int romanToInt(String x) {
        int result = 0;
        for (int i = 0; i < x.length(); i++) {
//            String cur = x.substring(i, i + 1);
//            if (cur.equals("V"))
//                result += 5;
//            if (cur.equals("L"))
//                result += 50;
//            if (cur.equals("D"))
//                result += 500;
//            if (cur.equals("M"))
//                result += 1000;
//            if (cur.equals("I") || cur.equals("X") || cur.equals("C")) {
//                if (i + 1 <= x.length() - 1) {
//                    String next = x.substring(i + 1, i + 2);
//                    if (next.equals("V")) {
//                        result += 4;
//                        i++;
//                        break;
//                    } else if (next.equals("X")) {
//                        result += 9;
//                        i++;
//                        break;
//                    }
//                }
//                result += 1;
//            }
            switch (x.substring(i, i + 1)) {
                case "V":
                    result += 5;
                    break;
                case "L":
                    result += 50;
                    break;
                case "D":
                    result += 500;
                    break;
                case "M":
                    result += 1000;
                    break;
                case "I":
                    if (i + 1 <= x.length() - 1) {
                        String next = x.substring(i + 1, i + 2);
                        if (next.equals("V")) {
                            result += 4;
                            i++;
                            break;
                        } else if (next.equals("X")) {
                            result += 9;
                            i++;
                            break;
                        }
                    }
                    result += 1;
                    break;
                case "X":
                    if (i + 1 <= x.length() - 1) {
                        String next = x.substring(i + 1, i + 2);
                        if (next.equals("L")) {
                            result += 40;
                            i++;
                            break;
                        } else if (next.equals("C")) {
                            result += 90;
                            i++;
                            break;
                        }
                    }
                    result += 10;
                    break;
                case "C":
                    if (i + 1 <= x.length() - 1) {
                        String next = x.substring(i + 1, i + 2);
                        if (next.equals("D")) {
                            result += 400;
                            i++;
                            break;
                        } else if (next.equals("M")) {
                            result += 900;
                            i++;
                            break;
                        }
                    }
                    result += 100;
                    break;
            }
        }
        return result;
    }
}
