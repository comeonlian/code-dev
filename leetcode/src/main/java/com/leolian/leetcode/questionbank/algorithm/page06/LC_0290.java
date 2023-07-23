package com.leolian.leetcode.questionbank.algorithm.page06;

import java.util.HashMap;

/**
 * LC 290 : 单词规律
 * 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
 * 提示:
 * 1 <= pattern.length <= 300
 * pattern只包含小写英文字母
 * 1 <= s.length <= 3000
 * s只包含小写英文字母和' '
 * s不包含 任何前导或尾随对空格
 * s中每个单词都被 单个空格 分隔
 * <p>
 * 示例1
 * 输入: pattern = "abba", s = "dog cat cat dog"
 * 输出: true
 * 示例2
 * 输入:pattern = "abba", s = "dog cat cat fish"
 * 输出: false
 * 示例3
 * 输入: pattern = "aaaa", s = "dog cat cat dog"
 * 输出: false
 */
public class LC_0290 {

    public static void main(String[] args) {
        LC_0290 lc0290 = new LC_0290();

        String pattern = "aaaa";
        String s = "dog cat cat dog";
        System.out.println(lc0290.wordPattern(pattern, s));
    }

    public boolean wordPattern(String pattern, String s) {
        if (pattern == null || pattern.length() == 0) {
            return s == null || s.length() == 0;
        }
        if (s == null || s.length() == 0) {
            return false;
        }
        StringBuilder builder = new StringBuilder();
        HashMap<String, Character> wordMapCh = new HashMap<>();
        HashMap<Character, String> ch2MapWord = new HashMap<>();
        String[] array = s.split(" ");
        for (int i = 0; i < array.length; i++) {
            if (i >= pattern.length()) {
                return false;
            }
            
            String word = array[i];
            char ch = pattern.charAt(i);
            
            if(wordMapCh.containsKey(word)){
                char chVal = wordMapCh.get(word);
                if (ch != chVal) {
                    return false;
                }
            } else if (ch2MapWord.containsKey(ch)) {
                String wordVal = ch2MapWord.get(ch);
                if (!word.equals(wordVal)) {
                    return false;
                }
            }
            builder.append(ch);
            wordMapCh.put(word, ch);
            ch2MapWord.put(ch, word);
        }
        return pattern.equals(builder.toString());
    }
    
    /*
    执行用时：1 ms, 在所有 Java 提交中击败了55.13%的用户
    内存消耗：39.3 MB, 在所有 Java 提交中击败了71.57%的用户
    通过测试用例：41 / 41
    */
}
