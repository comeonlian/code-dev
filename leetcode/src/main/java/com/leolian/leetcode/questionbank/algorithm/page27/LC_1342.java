package com.leolian.leetcode.questionbank.algorithm.page27;

/**
 * LC 1342 : 将数字变成 0 的操作次数
 * 给你一个非负整数 num ，请你返回将它变成 0 所需要的步数。 如果当前数字是偶数，你需要把它除以 2 ；否则，减去 1 。
 * 提示：
 * 0 <= num <= 10^6
 * <p>
 * 示例1
 * 输入：num = 14
 * 输出：6
 * 解释：
 * 步骤 1) 14 是偶数，除以 2 得到 7 。
 * 步骤 2） 7 是奇数，减 1 得到 6 。
 * 步骤 3） 6 是偶数，除以 2 得到 3 。
 * 步骤 4） 3 是奇数，减 1 得到 2 。
 * 步骤 5） 2 是偶数，除以 2 得到 1 。
 * 步骤 6） 1 是奇数，减 1 得到 0 。
 * <p>
 * 示例2
 * 输入：num = 8
 * 输出：4
 * 解释：
 * 步骤 1） 8 是偶数，除以 2 得到 4 。
 * 步骤 2） 4 是偶数，除以 2 得到 2 。
 * 步骤 3） 2 是偶数，除以 2 得到 1 。
 * 步骤 4） 1 是奇数，减 1 得到 0 。
 * <p>
 * 示例3
 * 输入：num = 123
 * 输出：12
 */
public class LC_1342 {

    public static void main(String[] args) {
        LC_1342 lc1342 = new LC_1342();

        int num = 8;
        System.out.println(lc1342.numberOfSteps(num));
    }
    
    public int numberOfSteps(int num) {
        int steps = 0;
        while (num > 0) {
            if ((num % 2) == 0) {
                num /= 2;
            } else {
                num -= 1;
            }
            steps++;
        }
        return steps;
    }
    
    /*
    执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
    内存消耗：38.5 MB, 在所有 Java 提交中击败了5.04%的用户
    通过测试用例：204 / 204
    */
    
}
