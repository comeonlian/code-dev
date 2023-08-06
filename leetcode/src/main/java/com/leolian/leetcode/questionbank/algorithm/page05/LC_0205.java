package com.leolian.leetcode.questionbank.algorithm.page05;

import java.util.HashMap;

/**
 * LC 205 : 同构字符串
 * 给定两个字符串s和t，判断它们是否是同构的。
 * 如果s中的字符可以按某种映射关系替换得到t，那么这两个字符串是同构的。
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，
 * 相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 * 提示：
 * 1 <= s.length <= 5 * 10^4
 * t.length == s.length
 * s 和 t 由任意有效的 ASCII 字符组成
 * <p>
 * 示例1
 * 输入：s = "egg", t = "add"
 * 输出：true
 * <p>
 * 示例2
 * 输入：s = "foo", t = "bar"
 * 输出：false
 * <p>
 * 示例3
 * 输入：s = "paper", t = "title"
 * 输出：true
 */
public class LC_0205 {

    public static void main(String[] args) {
        LC_0205 lc0205 = new LC_0205();

        String s = "badc";
        String t = "baba";
        System.out.println(lc0205.isIsomorphic(s, t));
    }

    public boolean isIsomorphic(String s, String t) {
        if (s == null || s.length() == 0) {
            return t == null || t.length() == 0;
        }
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Character> sMap = new HashMap<>();
        HashMap<Character, Character> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (sMap.containsKey(sChar)) {
                Character ch = sMap.get(sChar);
                if (ch != tChar) {
                    return false;
                }
            } else {
                sMap.put(sChar, tChar);
            }
            if (tMap.containsKey(tChar)) {
                Character ch = tMap.get(tChar);
                if (ch != sChar) {
                    return false;
                }
            } else {
                tMap.put(tChar, sChar);
            }
        }
        return true;
    }
    
    /*
    执行用时：16 ms, 在所有 Java 提交中击败了48.67%的用户
    内存消耗：40.3 MB, 在所有 Java 提交中击败了85.12%的用户
    */
}
