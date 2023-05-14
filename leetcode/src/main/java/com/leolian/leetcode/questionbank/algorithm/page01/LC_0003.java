package com.leolian.leetcode.questionbank.algorithm.page01;

import java.util.HashSet;
import java.util.Set;

/**
 *给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LC_0003 {

    public static void main(String[] args) {
        String s = "abcabcbb";
        s = " ";
        int maxLength = lengthOfLongestSubstring(s);
        System.out.println(maxLength);
    }

    /**
     * 执行用时 : 130 ms, 在Longest Substring Without Repeating Characters的Java提交中击败了21.94% 的用户
     * 内存消耗 : 65.4 MB, 在Longest Substring Without Repeating Characters的Java提交中击败了8.34% 的用户
     */
    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        first:
        for (int i = 0; i <= (chars.length - 1); i++) {
            set.add(chars[i]);
            second:
            for (int j = i + 1; j < chars.length; j++) {
                char c = chars[j];
                if (set.contains(c)) {
                    if (set.size() > maxLength) {
                        maxLength = set.size();
                    }
                    set.clear();
                    break second;
                } else {
                    set.add(c);
                }
            }
        }
        if (set.size() > maxLength) {
            maxLength = set.size();
            set.clear();
        }
        return maxLength;
    }

}
