package com.leolian.nowcoder.question.bank;

/**
 * NC 7 : 买卖股票的最好时机
 * <p>
 * 题目描述
 * 假设你有一个数组，其中第 i 个元素是股票在第 i 天的价格。
 * 你有一次买入和卖出的机会。（只有买入了股票以后才能卖出）。请你设计一个算法来计算可以获得的最大收益。
 * <p>
 * 示例1
 * 输入：[1,4,2]
 * 返回值：3
 * 示例2
 * 输入：[2,4,1]
 * 返回值：2
 */
public class NC_0007 {

    public static void main(String[] args) {
        NC_0007 nc0007 = new NC_0007();

        int[] prices = new int[]{6, 2, 4};
        System.out.println(nc0007.maxProfit(prices));
    }

    /**
     * @param prices int整型一维数组
     * @return int整型
     */
    public int maxProfit(int[] prices) {
        if (null == prices || prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int profits = 0;
        int minPrice = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                profits = Math.max((prices[i] - minPrice), profits);
            }
        }
        return profits;
    }

}
