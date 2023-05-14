package com.leolian.leetcode.questionbank.algorithm.page01;

/**
 * LC 14 : 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 提示：
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 * <p>
 * 示例1
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * <p>
 * 示例2
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 */
public class LC_0014 {

    public static void main(String[] args) {
        LC_0014 lc0014 = new LC_0014();

        String[] strs = new String[]{"dog","racecar","car"};
        System.out.println(lc0014.longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        if (null == strs || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String prefix = strs[0], val;
        int len, index;
        char ch1, ch2;
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < strs.length; i++) {
            val = strs[i];
            len = Math.min(prefix.length(), val.length());
            index = 0;
            while (index < len) {
                ch1 = prefix.charAt(index);
                ch2 = val.charAt(index);
                if (ch1 != ch2) {
                    break;
                }
                builder.append(ch1);
                index++;
            }
            prefix = builder.toString();
            builder.delete(0, builder.length());
        }
        return prefix;
    }
}
