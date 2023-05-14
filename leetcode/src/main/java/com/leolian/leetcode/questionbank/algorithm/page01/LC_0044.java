package com.leolian.leetcode.questionbank.algorithm.page01;

/**
 * LC 44 : 通配符匹配
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 * 提示：
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 * <p>
 * 示例1
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * <p>
 * 示例2
 * 输入:
 * s = "aa"
 * p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 * <p>
 * 示例3
 * 输入:
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 * <p>
 * 示例4
 * 输入:
 * s = "adceb"
 * p = "*a*b"
 * 输出: true
 * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 * <p>
 * 示例5
 * 输入:
 * s = "acdcb"
 * p = "a*c?b"
 * 输出: false
 */
public class LC_0044 {

    public static void main(String[] args) {
        LC_0044 lc0044 = new LC_0044();

        // "abcabczzzde"
        // "*abc???de*"
        // "aaaa"
        // "***a"
        String s = "c";
        String p = "*?*";
        System.out.println(lc0044.isMatch(s, p));
    }

    public boolean isMatch(String s, String p) {
        if ((s == null || s.length() == 0) && (p == null || p.length() == 0)) {
            return true;
        }
        if (p == null || p.length() == 0) {
            return false;
        }
        if (s == null || s.length() == 0) {
            int r2 = 0;
            while (r2 < p.length()) {
                if (p.charAt(r2) != '*') {
                    return false;
                }
                r2++;
            }
            return true;
        }
        int r1 = 0, r2 = 0;
        while (r1 < s.length() && r2 < p.length()) {
            char ch1 = s.charAt(r1);
            char ch2 = p.charAt(r2);

            if (ch2 == '?') {
                r1++;
                r2++;
            } else if (ch2 == '*') {
                if (r2 + 1 == p.length()) {
                    return true;
                }
                
                while (p.charAt(r2 + 1) == '*') {
                    r2++;
                    if (r2 + 1 == p.length()) {
                        return true;
                    }
                }
                char ch2Next = p.charAt(r2 + 1);

                if (ch2Next == '?') {
                    r1++;
                    r2 = r2 + 1 + 1;
                    continue;
                }
                
                int index = s.lastIndexOf(ch2Next);
                if (index == -1) {
                    index = r1;
                }
                ch1 = s.charAt(index);
                if (ch1 == ch2Next) {
                    r2 = r2 + 1 + 1;
                }
                r1 = index + 1;
            } else {
                if (ch1 != ch2) {
                    return false;
                }
                r1++;
                r2++;
            }
        }
        while (r2 < p.length()) {
            if (p.charAt(r2) != '*') {
                return false;
            }
            r2++;
        }
        return r1 == s.length() && r2 == p.length();
    }

}
