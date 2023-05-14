package com.leolian.leetcode.questionbank.algorithm.easy;

/**
 * LC 459 : 重复的子字符串
 * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
 * 提示：
 * 1 <= s.length <= 10^4
 * s 由小写英文字母组成
 * <p>
 * 示例1
 * 输入: s = "abab"
 * 输出: true
 * 解释: 可由子串 "ab" 重复两次构成。
 * <p>
 * 示例2
 * 输入: s = "aba"
 * 输出: false
 * <p>
 * 示例3
 * 输入: s = "abcabcabcabc"
 * 输出: true
 * 解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
 */
public class LC_0459 {

    public static void main(String[] args) {
        LC_0459 lc0459 = new LC_0459();

        String s = "abaababaab";
        System.out.println(lc0459.repeatedSubstringPattern(s));
    }

    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int len = s.length();
        int middle = len / 2;
        for (int i = 1; i <= middle; i++) {
            if ((len % i) == 0) {
                boolean match = true;
                for (int j = i; j < len; j++) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
    执行用时：10 ms, 在所有 Java 提交中击败了58.65%的用户
    内存消耗：42.8 MB, 在所有 Java 提交中击败了10.87%的用户
    通过测试用例：129 / 129
    */
}
