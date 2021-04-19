package com.leolian.nowcoder.question.bank;

/**
 * NC 65 : 斐波那契数列
 * <p>
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
 * n≤39
 * <p>
 * 示例1 :
 * 输入
 * 4
 * 返回值
 * 3
 */
public class NC_0065 {

    public static void main(String[] args) {
        NC_0065 nc0065 = new NC_0065();

        int n = 0;
        int fibonacci = nc0065.Fibonacci(n);
        System.out.println(fibonacci);
    }

    /**
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

}
