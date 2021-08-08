package com.leolian.nowcoder.question.bank;

/**
 * NC 156 : 数组中只出现一次的数（其它数出现k次）
 * <p>
 * 题目描述
 * 给定一个长度为 n 的整型数组 arr 和一个整数 k(k>1) 。
 * 已知 arr 中只有 1 个数出现一次，其他的数都出现 k 次。
 * 请返回只出现了 1 次的数。
 * 要求时间复杂度 O(32n) 空间复杂度 O(1)
 * <p>
 * 示例1
 * 输入：[5,4,1,1,5,1,5],3
 * 返回值：4
 */
public class NC_0156 {

    public static void main(String[] args) {
        NC_0156 nc0156 = new NC_0156();

        int[] arr = new int[]{5, 4, 1, 1, 5, 1, 5};
        int k = 3;
        System.out.println(nc0156.foundOnceNumber(arr, k));
    }

    public int foundOnceNumber(int[] arr, int k) {
        if (null == arr || arr.length == 0 || k == 0) {
            return 0;
        }
        int[] bits = new int[32];
        for (int i = 0; i < bits.length; i++) {
            int bitSum = 0;
            for (int num : arr) {
                bitSum = bitSum + (num >> i &1);
            }
            bits[i] = bitSum;
        }
        int res = 0;
        for (int i = 0; i < bits.length; i++) {
            int bitSum = bits[i];
            if ((bitSum % k) != 0) {
                res = res + (1 << i);
            }
        }
        return res;
    }

}
