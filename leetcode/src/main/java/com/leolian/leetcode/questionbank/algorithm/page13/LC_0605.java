package com.leolian.leetcode.questionbank.algorithm.page13;

/**
 * LC 605 : 种花问题
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。
 * 可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * 给你一个整数数组 flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。
 * 另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false 。
 * 提示：
 * 1 <= flowerbed.length <= 2 * 10^4
 * flowerbed[i] 为 0 或 1
 * flowerbed 中不存在相邻的两朵花
 * 0 <= n <= flowerbed.length
 * <p>
 * 示例1
 * 输入：flowerbed = [1,0,0,0,1], n = 1
 * 输出：true
 * <p>
 * 示例2
 * 输入：flowerbed = [1,0,0,0,1], n = 2
 * 输出：false
 */
public class LC_0605 {

    public static void main(String[] args) {
        LC_0605 lc0605 = new LC_0605();

        int[] flowerbed = new int[]{1, 0, 0, 0, 0, 0, 0, 1};
        int n = 2;
        System.out.println(lc0605.canPlaceFlowers(flowerbed, n));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || flowerbed.length == 0) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                continue;
            }
            boolean left = (i - 1) < 0 || flowerbed[i - 1] == 0;
            boolean right = (i + 1) >= flowerbed.length || flowerbed[i + 1] == 0;
            if (left && right) {
                flowerbed[i] = 1;
                count++;
            }
        }
        return count >= n;
    }
    
    /*
    时间：1ms，击败 79.26% 使用 Java 的用户
    内存：41.68MB，击败 36.83% 使用 Java 的用户
    */
}
