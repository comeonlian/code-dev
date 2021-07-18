package com.leolian.nowcoder.question.bank;

/**
 * NC 34 : 求路径
 * <p>
 * 题目描述
 * 一个机器人在m×n大小的地图的左上角（起点）。
 * 机器人每次向下或向右移动。机器人要到达地图的右下角（终点）。
 * 可以有多少种不同的路径从起点走到终点？
 * 备注：m和n小于等于100,并保证计算结果在int范围内
 * https://uploadfiles.nowcoder.com/images/20201210/999991351_1607596327517/873CB1F2327F70DA0CA0FDC797F894A7
 * <p>
 * 示例1 :
 * 输入：2,1
 * 返回值：1
 * <p>
 * 示例2 :
 * 输入：2,2
 * 返回值：2
 */
public class NC_0034 {

    public static void main(String[] args) {
        NC_0034 nc0034 = new NC_0034();

        int m = 2;
        int n = 1;
        System.out.println(nc0034.uniquePaths(m, n));
    }

    /**
     * 计算从 (0,0) 到 (m-1, n-1) 点的路径
     * 递归求解
     *
     * @param m int整型
     * @param n int整型
     * @return int整型
     */
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }

}
