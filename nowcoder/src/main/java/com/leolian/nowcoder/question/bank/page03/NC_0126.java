package com.leolian.nowcoder.question.bank.page03;

/**
 * NC 126 : 换钱的最少货币数
 * <p>
 * 题目描述
 * 给定数组arr，arr中所有的值都为正整数且不重复。每个值代表一种面值的货币，
 * 每种面值的货币可以使用任意张，再给定一个aim，代表要找的钱数，求组成aim的最少货币数。
 * 如果无解，请返回-1.
 * 备注：
 * 0≤n≤1000
 * 0≤aim≤5000
 * <p>
 * 示例1:
 * 输入：[5,2,3],20
 * 返回值：4
 * 示例2:
 * 输入：[5,2,3],0
 * 返回值：0
 * 示例3:
 * 输入：[3,5],2
 * 返回值：-1
 */
public class NC_0126 {

    public static void main(String[] args) {
        NC_0126 nc0126 = new NC_0126();

        int[] arr = new int[]{5, 2, 3};
        int aim = 20;
        System.out.println(nc0126.minMoney(arr, aim));
    }

    /**
     * 最少货币数
     *
     * @param arr int整型一维数组 the array
     * @param aim int整型 the target
     * @return int整型
     */
    public int minMoney(int[] arr, int aim) {
        // TODO
        return 0;
    }

}
