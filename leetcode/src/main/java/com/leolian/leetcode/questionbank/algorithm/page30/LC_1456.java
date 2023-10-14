package com.leolian.leetcode.questionbank.algorithm.page30;

/**
 * LC 1456 : 定长子串中元音的最大数目
 * 给你字符串 s 和整数 k 。
 * 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
 * 英文中的 元音字母 为（a, e, i, o, u）。
 * 提示：
 * 1 <= s.length <= 10^5
 * s 由小写英文字母组成
 * 1 <= k <= s.length
 * <p>
 * 示例1
 * 输入：s = "abciiidef", k = 3
 * 输出：3
 * 解释：子字符串 "iii" 包含 3 个元音字母。
 * <p>
 * 示例2
 * 输入：s = "aeiou", k = 2
 * 输出：2
 * 解释：任意长度为 2 的子字符串都包含 2 个元音字母。
 * <p>
 * 示例3
 * 输入：s = "leetcode", k = 3
 * 输出：2
 * 解释："lee"、"eet" 和 "ode" 都包含 2 个元音字母。
 * <p>
 * 示例4
 * 输入：s = "rhythms", k = 4
 * 输出：0
 * 解释：字符串 s 中不含任何元音字母。
 * <p>
 * 示例5
 * 输入：s = "tryhard", k = 4
 * 输出：1
 */
public class LC_1456 {

    public static void main(String[] args) {
        LC_1456 lc1732 = new LC_1456();

        int[] gain = new int[]{-5, 1, 5, 0, -7};
        System.out.println(lc1732.largestAltitude(gain));
    }

    public int largestAltitude(int[] gain) {
        if (gain == null || gain.length == 0) {
            return 0;
        }
        if (gain.length == 1) {
            return Math.max(0, gain[0]);
        }
        int sum = gain[0];
        int maxSum = Math.max(sum, 0);
        for (int i = 1; i < gain.length; i++) {
            sum += gain[i];
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }
    
    /*
    时间：0ms，击败 100.00% 使用 Java 的用户
    内存：38.10MB，击败 58.97% 使用 Java 的用户
    */

}
