package com.leolian.leetcode.questionbank.algorithm.page10;

/**
 * LC 461 : 汉明距离
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 * 提示：
 * 0 <= x, y <= 2^31 - 1
 * <p>
 * 示例1
 * 输入：x = 1, y = 4
 * 输出：2
 * 解释：
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 * 上面的箭头指出了对应二进制位不同的位置。
 * <p>
 * 示例2
 * 输入：x = 3, y = 1
 * 输出：1
 */
public class LC_0461 {

    public static void main(String[] args) {
        LC_0461 lc0461 = new LC_0461();

        int x = 1;
        int y = 3;
        System.out.println(lc0461.hammingDistance(x, y));
    }

    public int hammingDistance(int x, int y) {
        int res = x ^ y;
        int count = 0;
        while (res > 0) {
            if ((res & 1) == 1) {
                count++;
            }
            res >>>= 1;
        }
        return count;
    }
}
