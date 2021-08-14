package com.leolian.leetcode.questionbank.algorithm.easy;

/**
 * LC 125 : 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 提示：
 * 1 <= s.length <= 2 * 105
 * 字符串 s 由 ASCII 字符组成
 * <p>
 * 示例1
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 * <p>
 * 示例2
 * 输入: "race a car"
 * 输出: false
 * 解释："raceacar" 不是回文串
 */
public class LC_0125 {

    public static void main(String[] args) {
        LC_0125 lc0125 = new LC_0125();

        String s = "A man, a plan, a canal: Panama";
        System.out.println(lc0125.isPalindrome(s));
    }

    public boolean isPalindrome(String s) {
        if (s.trim().length() == 0) {
            return true;
        }
        int start = 0, end = s.length() - 1;
        while (start <= end) {
            int startCh = s.charAt(start);
            if ((startCh >= 48 && startCh <= 57) ||
                    (startCh >= 97 && startCh <= 122) ||
                    (startCh >= 65 && startCh <= 90)) {
                if (startCh >= 65 && startCh <= 90) {
                    startCh = startCh + 32;
                }
            } else {
                start++;
                continue;
            }
            int endCh = s.charAt(end);
            if ((endCh >= 48 && endCh <= 57) ||
                    (endCh >= 97 && endCh <= 122) ||
                    (endCh >= 65 && endCh <= 90)) {
                if (endCh >= 65 && endCh <= 90) {
                    endCh = endCh + 32;
                }
            } else {
                end--;
                continue;
            }
            if (startCh != endCh) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
