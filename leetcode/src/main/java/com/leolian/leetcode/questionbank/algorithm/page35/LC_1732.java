package com.leolian.leetcode.questionbank.algorithm.page35;

/**
 * LC 1732 : 找到最高海拔
 * 有一个自行车手打算进行一场公路骑行，这条路线总共由 n + 1 个不同海拔的点组成。自行车手从海拔为 0 的点 0 开始骑行。
 * 给你一个长度为 n 的整数数组 gain ，其中 gain[i] 是点 i 和点 i + 1 的 净海拔高度差（0 <= i < n）。请你返回 最高点的海拔 。
 * 提示：
 * n == gain.length
 * 1 <= n <= 100
 * -100 <= gain[i] <= 100
 * <p>
 * 示例1
 * 输入：gain = [-5,1,5,0,-7]
 * 输出：1
 * 解释：海拔高度依次为 [0,-5,-4,1,1,-6] 。最高海拔为 1 。
 * <p>
 * 示例2
 * 输入：gain = [-4,-3,-2,-1,4,3,2]
 * 输出：0
 * 解释：海拔高度依次为 [0,-4,-7,-9,-10,-6,-3,-1] 。最高海拔为 0 。
 */
public class LC_1732 {

    public static void main(String[] args) {
        LC_1732 lc1732 = new LC_1732();

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
