package com.leolian.leetcode.questionbank.algorithm.easy;

import java.util.Arrays;

/**
 * LC 338 : 比特位计数
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 * 提示：
 * 0 <= n <= 10^5
 * 进阶：
 * 很容易就能实现时间复杂度为 O(n log n) 的解决方案，你可以在线性时间复杂度 O(n) 内用一趟扫描解决此问题吗？
 * 你能不使用任何内置函数解决此问题吗？（如，C++ 中的 __builtin_popcount ）
 * <p>
 * 示例1
 * 输入：n = 2
 * 输出：[0,1,1]
 * 解释：
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * <p>
 * 示例2
 * 输入：n = 5
 * 输出：[0,1,1,2,1,2]
 * 解释：
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 */
public class LC_0338 {

    public static void main(String[] args) {
        LC_0338 lc0338 = new LC_0338();

        int n = 2;
        System.out.println(Arrays.toString(lc0338.countBits(n)));
    }

    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int count = 0;
            int x = i;
            while (x > 0) {
                x &= (x - 1);
                count++;
            }
            res[i] = count;
        }
        return res;
    }
    
    /*
    执行用时：1 ms, 在所有 Java 提交中击败了99.92%的用户
    内存消耗：45 MB, 在所有 Java 提交中击败了5.09%的用户
    通过测试用例：15 / 15
    */
    
//    public int[] countBits(int n) {
//        int[] res = new int[n + 1];
//        for (int i = 0; i <= n; i++) {
//            int count = 0;
//            int x = i;
//            while (x > 0) {
//                int val = (x & 1);
//                if (val == 1) {
//                    count++;
//                }
//                x >>>= 1;
//            }
//            res[i] = count;
//        }
//        return res;
//    }

    /*
    执行用时：5 ms, 在所有 Java 提交中击败了15.80%的用户
    内存消耗：45.6 MB, 在所有 Java 提交中击败了5.01%的用户
    通过测试用例：15 / 15
    */
}
