package com.leolian.nowcoder.question.book.sword.finger.offer;

/**
 * JZ 67 : 剪绳子
 * <p>
 * 题目描述
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1，m<=n），每段绳子的长度记为k[1],...,k[m]。
 * 请问k[1]x...xk[m]可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 输入描述：
 * 输入一个数n，意义见题面。（2 <= n <= 60）
 * 返回值描述：
 * 输出答案。
 * <p>
 * 示例1
 * 输入：8
 * 返回值：18
 */
public class JZ_067 {

    public static void main(String[] args) {
        JZ_067 jz067 = new JZ_067();

        int target = 8;
        System.out.println(jz067.cutRope(target));
    }

    public int cutRope(int target) {
        if (target < 5) {
            return target;
        }
        int max = 1;
        while (target >= 5) {
            target = target - 3;
            max = max * 3;
        }
        return max * target;
    }

}
