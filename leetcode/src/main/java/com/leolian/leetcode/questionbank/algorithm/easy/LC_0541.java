package com.leolian.leetcode.questionbank.algorithm.easy;

/**
 * LC 541 : 反转字符串 II
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符.
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * 提示：
 * 1 <= s.length <= 10^4
 * s 仅由小写英文组成
 * 1 <= k <= 10^4
 * <p>
 * 示例1
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * <p>
 * 示例2
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 */
public class LC_0541 {

    public static void main(String[] args) {
        LC_0541 lc0541 = new LC_0541();

        String s = "abcd";
        int k = 4;
        System.out.println(lc0541.reverseStr(s, k));
    }

    public String reverseStr(String s, int k) {
        if (s == null || s.length() == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        int len = s.length();
        int subLen = 2 * k;
        int count = 0;
        StringBuilder tmpBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (count >= subLen) {
                result.append(tmpBuilder);
                tmpBuilder.delete(0, tmpBuilder.length());
                tmpBuilder.insert(0, ch);
                count = 1;
            } else if (count >= k) {
                tmpBuilder.append(ch);
                count++;
            } else {
                tmpBuilder.insert(0, ch);
                count++;
            }
        }
        if (tmpBuilder.length() > 0) {
            result.append(tmpBuilder);
        }
        return result.toString();
    }
    
    /*
    执行用时：5 ms, 在所有 Java 提交中击败了5.78%的用户
    内存消耗：42.6 MB, 在所有 Java 提交中击败了5.06%的用户
    通过测试用例：60 / 60
    */
    
}
