package com.leolian.leetcode.questionbank.algorithm.page08;


/**
 * LC 392: 判断子序列
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * 进阶：
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。
 * 在这种情况下，你会怎样改变代码？
 * 提示：
 * 0 <= s.length <= 100
 * 0 <= t.length <= 10^4
 * 两个字符串都只由小写字符组成。
 * <p>
 * 示例1
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 * <p>
 * 示例2
 * 输入：s = "axc", t = "ahbgdc"
 * 输出：false
 */
public class LC_0392 {

    public static void main(String[] args) {
        LC_0392 lc0392 = new LC_0392();

        String s = "axc", t = "ahbgdc";

        System.out.println(lc0392.isSubsequence(s, t));
    }


    public boolean isSubsequence(String s, String t) {
        if (t.length() == 0) {
            return s.length() == 0;
        }
        if (s.length() == 0) {
            return true;
        }
        int sIndex = 0;
        int tIndex = 0;
        while (sIndex < s.length() && tIndex < t.length()) {
            char sChar = s.charAt(sIndex);
            char tChar = t.charAt(tIndex);

            if (sChar == tChar) {
                sIndex++;
            }
            tIndex++;
        }
        return sIndex == s.length();
    }
    
    /*
    执行用时：1 ms, 在所有 Java 提交中击败了88.96%的用户
    内存消耗：39.5 MB, 在所有 Java 提交中击败了65.44%的用户
    通过测试用例：19 / 19
    */
}
