package com.leolian.nowcoder.question.book.sword.finger.offer;

/**
 * JZ 52 : 正则表达式匹配
 * <p>
 * 题目描述
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * <p>
 * 示例1
 * 输入："aaa","a*a"
 * 返回值：true
 */
public class JZ_052 {

    public static void main(String[] args) {
        JZ_052 jz052 = new JZ_052();

        String str = "aaa";
        String pattern = "a*a";
        System.out.println(jz052.match(str, pattern));
    }

    public boolean match(String str, String pattern) {
        if (null == str || str.length() == 0 || null == pattern || pattern.length() == 0) {
            return false;
        }
        int index1 = 0, index2 = 0;
        int strLen = str.length(), patternLen = pattern.length();
        char ch1, ch2;
        while (index1 < strLen && index2 < patternLen) {
            ch1 = str.charAt(index1);
            ch2 = pattern.charAt(index2);
            if (ch1 == ch2 || ch2 == '.') {
                index1++;
                index2++;
                continue;
            }

        }
        return true;
    }

}
