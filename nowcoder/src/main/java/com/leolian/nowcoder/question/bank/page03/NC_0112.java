package com.leolian.nowcoder.question.bank.page03;

/**
 * NC 112 : 进制转换
 * <p>
 * 题目描述
 * 给定一个十进制数M，以及需要转换的进制数N。将十进制数M转化为N进制数
 * 备注：
 * M是32位整数，2<=N<=16.
 * <p>
 * 示例1:
 * 输入: 7,2
 * 返回: "111"
 */
public class NC_0112 {

    public static void main(String[] args) {
        NC_0112 nc0112 = new NC_0112();

        int m = -4;
        int n = 3;
        System.out.println(nc0112.solve(m, n));
    }

    /**
     * 进制转换
     *
     * @param M int整型 给定整数
     * @param N int整型 转换到的进制
     * @return string字符串
     */
    public String solve(int M, int N) {
        int absVal = M;
        if (M < 0) {
            absVal = Math.abs(M);
        }
        String res = Integer.toUnsignedString(absVal, N).toUpperCase();
        if (M < 0) {
            res = "-" + res;
        }
        return res;
    }

}

