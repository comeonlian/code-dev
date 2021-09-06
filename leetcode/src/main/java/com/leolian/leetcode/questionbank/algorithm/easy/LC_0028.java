package com.leolian.leetcode.questionbank.algorithm.easy;

/**
 * LC 28 :  实现 strStr()
 * 实现 strStr() 函数。
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。
 * 如果不存在，则返回 -1 。
 * 说明：
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 * 提示：
 * 0 <= haystack.length, needle.length <= 5 * 104
 * haystack 和 needle 仅由小写英文字符组成
 * <p>
 * 示例1
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 * <p>
 * 示例2
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 * <p>
 * 示例3
 * 输入：haystack = "", needle = ""
 * 输出：0
 */
public class LC_0028 {

    public static void main(String[] args) {
        LC_0028 lc0028 = new LC_0028();

        String haystack = "hello";
        String needle = "ll";
        System.out.println(lc0028.strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {
        if (null == needle || needle.length() == 0) {
            return 0;
        }
        return haystack.indexOf(needle);
    }
}
