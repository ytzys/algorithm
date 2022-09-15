package com.ytzys.algorithm.leedcode;

import org.junit.Test;

import java.util.Stack;

public class P0020_ValidParentheses {
    @Test
    public void test() {
        System.out.println(isValid("()["));
    }

    /**
     * 继续优化
     *
     * @param s
     * @return
     */
    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        for (char cur : s.toCharArray()) {
            if (cur == '(' || cur == '[' || cur == '{') {
                stack.push(cur);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            char last = stack.pop();
            if ((cur == ')' && last == '(')
                    || (cur == ']' && last == '[')
                    || (cur == '}' && last == '{')) {
                continue;
            }
            return false;
        }
        return stack.isEmpty();
    }

    /**
     * 用 char 的比较，取代 String 的 equal 操作，优化比较性能
     *
     * @param s
     * @return
     */
    public boolean isValid1(String s) {
        Stack<Character> stack = new Stack<>();
        int index = 0;
        while (index < s.length()) {
            char cur = s.charAt(index);
            if (cur == "(".charAt(0) || cur == "[".charAt(0) || cur == "{".charAt(0)) {
                stack.push(cur);
            } else if ((cur == ")".charAt(0) && stack.size() > 0 && stack.peek() == "(".charAt(0))
                    || (cur == "]".charAt(0) && stack.size() > 0 && stack.peek() == "[".charAt(0))
                    || (cur == "}".charAt(0) && stack.size() > 0 && stack.peek() == "{".charAt(0))) {
                stack.pop();
            } else {
                return false;
            }
            index++;
        }
        if (stack.size() == 0)
            return true;
        else
            return false;
    }

    public boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        int index = 0;
        while (index < s.length()) {
            String cur = s.substring(index, index + 1);
            if (cur.equals("(") || cur.equals("[") || cur.equals("{")) {
                stack.push(cur);
            } else if ((cur.equals(")") && stack.size() > 0 && "(".equals(stack.peek()))
                    || (cur.equals("]") && stack.size() > 0 && "[".equals(stack.peek()))
                    || (cur.equals("}") && stack.size() > 0 && "{".equals(stack.peek()))) {
                stack.pop();
            } else {
                return false;
            }
            index++;
        }
        if (stack.size() == 0)
            return true;
        else
            return false;
    }
}
