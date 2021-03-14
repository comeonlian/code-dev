package com.leolian.leetcode.explore.primaryalgorithm.string;

/**
 * LC 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 */
public class String005 {

    public static void main(String[] args) {
        String005 string005 = new String005();

        String s = "race a car";
        boolean palindrome = string005.isPalindrome(s);
        System.out.println(palindrome);
    }

    /**
     * 'A' - 'Z' : 65 - 90
     * 'a' - 'z' : 97 - 122
     * '0' - '9' : 48 - 57
     *
     * @param s
     * @return
     */
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

    /*
    执行结果：通过显示详情
    执行用时：2 ms, 在所有 Java 提交中击败了99.89%的用户
    内存消耗：38.4 MB, 在所有 Java 提交中击败了81.67%的用户
    */

}
