package com.leolian.nowcoder.question.bank;

/**
 * NC 134 : 股票(无限次交易)
 * <p>
 * 题目描述
 * 假定你知道某只股票每一天价格的变动。
 * 你最多可以同时持有一只股票。但你可以无限次的交易（买进和卖出均无手续费）。
 * 请设计一个函数，计算你所能获得的最大收益。
 * 备注：
 * 总天数不大于200000。保证股票每一天的价格在[1,100]范围内。
 * <p>
 * 示例1:
 * 输入：[5,4,3,2,1]
 * 返回值：0
 * 说明：
 * 由于每天股票都在跌，因此不进行任何交易最优。最大收益为0。
 * <p>
 * 示例2:
 * 输入：[1,2,3,4,5]
 * 返回值：4
 * 说明：
 * 第一天买进，最后一天卖出最优。中间的当天买进当天卖出不影响最终结果。最大收益为4。
 */
public class NC_0134 {

    public static void main(String[] args) {
        NC_0134 nc0134 = new NC_0134();

        int[] arr = new int[]{2, 4, 10, 57, 30, 82, 90, 12, 5, 13};
        System.out.println(nc0134.maxProfit(arr));
    }


    /**
     * 计算最大收益
     *
     * @param prices int整型一维数组 股票每一天的价格
     * @return int整型
     */
    public int maxProfit(int[] prices) {
        if (null == prices || prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int profits = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profits += (prices[i] - prices[i - 1]);
            }
        }
        return profits;
    }
    
/*
    // 该法性能更优
    public int maxProfit(int[] prices) {
        if (null == prices || prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int profits = 0;
        int buyIndex = 0;
        int buyPrice = prices[buyIndex];
        int j = buyIndex + 1;
        for (; j < prices.length - 1; j++) {
            int curPrice = prices[j];
            if (curPrice <= buyPrice) {
                buyIndex = j;
                buyPrice = prices[buyIndex];
            } else {
                int nextPrice = prices[j + 1];
                if (curPrice > nextPrice) {
                    profits = profits + (curPrice - buyPrice);
                    buyIndex = j + 1;
                    buyPrice = prices[buyIndex];
                }
            }
        }
        int nextPrice = prices[j];
        if ((j == (prices.length - 1)) && (nextPrice > buyPrice)) {
            profits = profits + (nextPrice - buyPrice);
        }
        return profits;
    }
*/

}
