package com.leolian.leetcode.questionbank.algorithm.page07;

import java.util.HashSet;

/**
 * LC 345 : 反转字符串中的元音字母
 * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
 * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。
 * 提示：
 * 1 <= s.length <= 3 * 105
 * s 由 可打印的 ASCII 字符组成
 * <p>
 * 示例1
 * 输入：s = "hello"
 * 输出："holle"
 * <p>
 * 示例2
 * 输入：s = "leetcode"
 * 输出："leotcede"
 */
public class LC_0345 {

    public static void main(String[] args) {
        LC_0345 lc0345 = new LC_0345();

        String s = "leetcode";
        System.out.println(lc0345.reverseVowels(s));
    }

    public HashSet<Character> set = new HashSet() {{
        add('a');
        add('e');
        add('i');
        add('o');
        add('u');
        add('A');
        add('E');
        add('I');
        add('O');
        add('U');
    }};

    public String reverseVowels(String s) {
        StringBuilder vowelBuilder = new StringBuilder();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (set.contains(ch)) {
                vowelBuilder.insert(0, ch);
            }
        }
        if (vowelBuilder.length() == 0) {
            return s;
        }
        StringBuilder builder = new StringBuilder();
        int index = 0;
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (set.contains(ch)) {
                builder.append(vowelBuilder.charAt(index++));
            } else {
                builder.append(ch);
            }
        }
        return builder.toString();
    }

//    public String reverseVowels(String s) {
//        StringBuilder builder = new StringBuilder(s);
//        int start = 0;
//        int end = s.length() - 1;
//        while (start < end) {
//            char startCh = s.charAt(start);
//            if (!set.contains(startCh)) {
//                start++;
//                continue;
//            }
//            char endCh = s.charAt(end);
//            if (!set.contains(endCh)) {
//                end--;
//                continue;
//            }
//            builder.replace(start, start + 1, String.valueOf(endCh));
//            builder.replace(end, end + 1, String.valueOf(startCh));
//            start++;
//            end--;
//        }
//        return builder.toString();
//    }
    
    /*
    时间：13ms，击败 9.71%使用 Java 的用户
    内存：41.92MB，击败 32.41%使用 Java 的用户
    */

}
