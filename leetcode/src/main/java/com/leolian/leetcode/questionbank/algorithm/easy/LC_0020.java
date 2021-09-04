package com.leolian.leetcode.questionbank.algorithm.easy;

import java.util.Stack;

/**
 * LC 20 : 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 提示：
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 * <p>
 * 示例1
 * 输入：s = "()"
 * 输出：true
 * <p>
 * 示例2
 * 输入：s = "()[]{}"
 * 输出：true
 * <p>
 * 示例3
 * 输入：s = "(]"
 * 输出：false
 * <p>
 * 示例4
 * 输入：s = "([)]"
 * 输出：false
 * <p>
 * 示例5
 * 输入：s = "{[]}"
 * 输出：true
 */
public class LC_0020 {

    public static void main(String[] args) {
        LC_0020 lc0020 = new LC_0020();

        String s = "{]}";
        System.out.println(lc0020.isValid(s));
    }

    public boolean isValid(String s) {
        if (null == s || s.length() == 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            // 不是括号的场景
            if (ch != '(' && ch != ')'
                    && ch != '[' && ch != ']'
                    && ch != '{' && ch != '}') {
                return false;
            }
            // 如果是左括号
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
                continue;
            }
            if (ch == ')') {
                if (stack.size()==0 || stack.peek() != '(')
                    return false;
                stack.pop();
            } else if (ch == ']') {
                if (stack.size()==0 || stack.peek() != '[')
                    return false;
                stack.pop();
            } else{
                if (stack.size()==0 || stack.peek() != '{')
                    return false;
                stack.pop();
            }
        }
        return stack.size() == 0;
    }
}
