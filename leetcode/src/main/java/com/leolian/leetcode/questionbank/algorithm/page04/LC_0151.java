package com.leolian.leetcode.questionbank.algorithm.page04;

/**
 * LC 151 : 反转字符串中的单词
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。
 * 返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 * 提示：
 * 1 <= s.length <= 104
 * s 包含英文大小写字母、数字和空格 ' '
 * s 中 至少存在一个 单词
 * <p>
 * 示例1
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 * <p>
 * 示例2
 * 输入：s = "  hello world  "
 * 输出："world hello"
 * 解释：反转后的字符串中不能存在前导空格和尾随空格。
 * <p>
 * 示例3
 * 输入：s = "a good   example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。
 */
public class LC_0151 {

    public static void main(String[] args) {
        LC_0151 lc0151 = new LC_0151();

        String s = "   a          good   example              ";
        System.out.println(lc0151.reverseWords(s));
    }

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        s = s.trim();
        StringBuilder builder = new StringBuilder();
        for (String str : s.split(" ")) {
            if (str.trim().length() > 0) {
                builder.insert(0, " " + str);
            }
        }
        return builder.substring(1);
    }
    
    /*
    时间：6ms，击败 61.48%使用 Java 的用户
    内存：41.30MB，击败 25.09%使用 Java 的用户
    */

}
