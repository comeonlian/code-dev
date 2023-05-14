package com.leolian.leetcode.questionbank.algorithm.page09;

/**
 * LC 434 : 字符串中的单词数
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 * <p>
 * 示例1
 * 输入: "Hello, my name is John"
 * 输出: 5
 * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
 */
public class LC_0434 {

    public static void main(String[] args) {
        LC_0434 lc0434 = new LC_0434();

        String s = ", , , ,        a, eaefa";
        System.out.println(lc0434.countSegments(s));
    }

    public int countSegments(String s) {
        if (null == s || s.length() == 0 || s.trim().length() == 0) {
            return 0;
        }
        int count = 0;
        int start = -1;
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ch == ' ') {
                if(start != -1) {
                    count++;
                    start = -1;
                }
                continue;
            }
            if (start == -1) {
                start = i;
            }
        }
        if(start != -1) {
            count++;
        }
        return count;
    }
}
