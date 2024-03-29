package com.leolian.leetcode.questionbank.algorithm.page09;


/**
 * LC 402 : 移掉 K 位数字
 * 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。
 * 请你以字符串形式返回这个最小的数字。
 * 提示：
 * 1 <= k <= num.length <= 10^5
 * num 仅由若干位数字（0 - 9）组成
 * 除了 0 本身之外，num 不含任何前导零
 * <p>
 * 示例1
 * 输入：num = "1432219", k = 3
 * 输出："1219"
 * 解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
 * <p>
 * 示例2
 * 输入：num = "10200", k = 1
 * 输出："200"
 * 解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * <p>
 * 示例3
 * 输入：num = "10", k = 2
 * 输出："0"
 * 解释：从原数字移除所有的数字，剩余为空就是 0 。
 */
public class LC_0402 {

    public static void main(String[] args) {
        LC_0402 lc0402 = new LC_0402();

        String s = "1432219";
        int k = 3;

        System.out.println(lc0402.removeKdigits(s, k));
    }

    public String removeKdigits(String num, int k) {
        if (num == null || num.length() == 0 || k == 0) {
            return num;
        }
        if (k >= num.length()) {
            return "0";
        }
        
        return num;
    }

    /*
    
     */

}
