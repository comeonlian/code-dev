package com.leolian.leetcode.questionbank.algorithm.easy;

/**
 * LC 53 :  最后一个单词的长度
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中最后一个单词的长度。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * 提示：
 * 1 <= s.length <= 104
 * s 仅有英文字母和空格 ' ' 组成
 * s 中至少存在一个单词
 * <p>
 * 示例1
 * 输入：s = "Hello World"
 * 输出：5
 * <p>
 * 示例2
 * 输入：s = "   fly me   to   the moon  "
 * 输出：4
 * <p>
 * 示例3
 * 输入：s = "luffy is still joyboy"
 * 输出：6
 */
public class LC_0058 {

    public static void main(String[] args) {
        LC_0058 lc0053 = new LC_0058();

        String s = "luffy is still joyboy";
        System.out.println(lc0053.lengthOfLastWord(s));
    }

    public int lengthOfLastWord(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        int count = 0;
        boolean appear = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                if (appear)
                    return count;
                continue;
            }
            if ((ch >= 'a' && ch <= 'z') ||
                    (ch >= 'A' && ch <= 'Z')) {
                count++;
                appear = true;
            }
        }
        return count;
    }
}
