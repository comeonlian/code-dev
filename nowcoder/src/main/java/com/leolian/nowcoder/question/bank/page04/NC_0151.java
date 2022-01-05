package com.leolian.nowcoder.question.bank.page04;

/**
 * NC 151 : 最大公约数
 * <p>
 * 题目描述
 * 求出两个数的最大公约数，如果有一个自然数a能被自然数b整除，则称a为b的倍数，b为a的约数。
 * 几个自然数公有的约数，叫做这几个自然数的公约数。公约数中最大的一个公约数，称为这几个自然数的最大公约数。
 * 备注：
 * a和b的范围是[1-109]
 * <p>
 * 示例1
 * 输入：3,6
 * 返回值：3
 * <p>
 * 示例2
 * 输入：8,12
 * 返回值：4
 */
public class NC_0151 {

    public static void main(String[] args) {
        NC_0151 nc0151 = new NC_0151();

        int a = 8;
        int b = 12;
        System.out.println(nc0151.gcd(a, b));
    }

    /**
     * 辗转相除法
     *
     * @param a int
     * @param b int
     * @return int
     */
    public int gcd(int a, int b) {
        if ((a % b) == 0) {
            return b;
        }
        return gcd(b, (a % b));
    }

    /**
     * @param a int
     * @param b int
     * @return int
     */
    /*
    public int gcd(int a, int b) {
        int min = Math.min(a, b);
        if (min == 1) {
            return min;
        }
        for (int i = min; i > 0; i--) {
            if ((a % i) == 0 && (b % i) == 0) {
                return i;
            }
        }
        return 0;
    }
*/
}
