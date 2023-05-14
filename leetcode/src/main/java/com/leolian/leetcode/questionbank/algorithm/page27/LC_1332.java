package com.leolian.leetcode.questionbank.algorithm.page27;

/**
 * LC 1332 : 删除回文子序列
 * 给你一个字符串 s，它仅由字母 'a' 和 'b' 组成。每一次删除操作都可以从 s 中删除一个回文 子序列。
 * 返回删除给定字符串中所有字符（字符串为空）的最小删除次数。
 * 「子序列」定义：如果一个字符串可以通过删除原字符串某些字符而不改变原字符顺序得到，那么这个字符串就是原字符串的一个子序列。
 * 「回文」定义：如果一个字符串向后和向前读是一致的，那么这个字符串就是一个回文。
 * 提示：
 * 1 <= s.length <= 1000
 * s 仅包含字母 'a'  和 'b'
 * <p>
 * 示例1
 * 输入：s = "ababa"
 * 输出：1
 * 解释：字符串本身就是回文序列，只需要删除一次。
 * <p>
 * 示例2
 * 输输入：s = "abb"
 * 输出：2
 * 解释："abb" -> "bb" -> "". 
 * 先删除回文子序列 "a"，然后再删除 "bb"。
 * <p>
 * 示例3
 * 输入：s = "baabb"
 * 输出：2
 * 解释："baabb" -> "b" -> "". 
 * 先删除回文子序列 "baab"，然后再删除 "b"。
 */
public class LC_1332 {

    public static void main(String[] args) {
        LC_1332 lc1332 = new LC_1332();

        String s = "baabb";
        System.out.println(lc1332.removePalindromeSub(s));
    }
    
    public int removePalindromeSub(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                return 2;
            }
            l++;
            r--;
        }
        return 1;
    }
    
    /*
    执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
    内存消耗：36 MB, 在所有 Java 提交中击败了83.10%的用户
    通过测试用例：48 / 48
    */
}
