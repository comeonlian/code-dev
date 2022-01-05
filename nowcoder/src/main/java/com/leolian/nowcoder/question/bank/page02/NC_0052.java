package com.leolian.nowcoder.question.bank.page02;

import java.util.Stack;

/**
 * NC 52 : 括号序列
 * <p>
 * 给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
 * 括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
 * <p>
 * 示例1:
 * 输入："["
 * 返回值：false
 * <p>
 * 示例2:
 * 输入："[]"
 * 返回值：true
 */
public class NC_0052 {

    public static void main(String[] args) {
        NC_0052 nc0052 = new NC_0052();
        // (( ([]) ()[]{} (] ([)]
        String s = "{[()]}";
        System.out.println(nc0052.isValid(s));
    }

    /**
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean isValid(String s) {
        if (null == s || s.length() == 0) {
            return false;
        }
        if ((s.length() % 2) != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.size() == 0 || c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }
            Character peek = stack.peek();
            if (c == ')' && peek != '(')
                return false;
            if (c == ']' && peek != '[')
                return false;
            if (c == '}' && peek != '{')
                return false;
            stack.pop();
        }
        return stack.size() <= 0;
    }

}
