package com.leolian.leetcode.questionbank.algorithm.page36;

/**
 * LC 1768 : 交替合并字符串
 * 给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。如果一个字符串比另一个字符串长，
 * 就将多出来的字母追加到合并后字符串的末尾。
 * 返回 合并后的字符串 。
 * 提示：
 * 1 <= word1.length, word2.length <= 100
 * word1 和 word2 由小写英文字母组成
 * <p>
 * 示例1
 * 输入：word1 = "abc", word2 = "pqr"
 * 输出："apbqcr"
 * 解释：字符串合并情况如下所示：
 * word1：  a   b   c
 * word2：    p   q   r
 * 合并后：  a p b q c r
 * <p>
 * 示例2
 * 输入：word1 = "ab", word2 = "pqrs"
 * 输出："apbqrs"
 * 解释：注意，word2 比 word1 长，"rs" 需要追加到合并后字符串的末尾。
 * word1：  a   b 
 * word2：    p   q   r   s
 * 合并后：  a p b q   r   s
 * <p>
 * 示例3
 * 输入：word1 = "abcd", word2 = "pq"
 * 输出："apbqcd"
 * 解释：注意，word1 比 word2 长，"cd" 需要追加到合并后字符串的末尾。
 * word1：  a   b   c   d
 * word2：    p   q 
 * 合并后：  a p b q c   d
 */
public class LC_1768 {

    public static void main(String[] args) {
        LC_1768 lc1768 = new LC_1768();

        String word1 = "abcd";
        String word2 = "pq";
        System.out.println(lc1768.mergeAlternately(word1, word2));
    }

    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int len = Math.max(len1, len2);
        int index = 0;
        StringBuilder builder = new StringBuilder();
        while (index < len) {
            if (index < len1) {
                builder.append(word1.charAt(index));
            }
            if (index < len2) {
                builder.append(word2.charAt(index));
            }
            index++;
        }
        return builder.toString();
    }
    
    /*
    时间：1ms， 击败 49.22% 使用 Java 的用户
    内存：38.49MB，击败 91.43%使用 Java 的用户
    */
    
}
