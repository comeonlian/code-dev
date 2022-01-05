package com.leolian.nowcoder.question.bank.page01;

/**
 * NC 30 : 数组中未出现的最小正整数
 * <p>
 * 给定一个无序数组arr，找到数组中未出现的最小正整数
 * 例如arr = [-1, 2, 3, 4]。返回1
 * arr = [1, 2, 3, 4]。返回5
 * [要求]
 * 时间复杂度为O(n)，空间复杂度为O(1)
 * 备注：
 * 1≤N≤10^6
 * ∣arr_i∣≤10^9
 * <p>
 * 示例1
 * 输入：[-1,2,3,4]
 * 返回值：1
 */
public class NC_0030 {

    public static void main(String[] args) {
        NC_0030 nc0030 = new NC_0030();

        int[] arr = new int[]{-1, 2, 3, 4};
        System.out.println(nc0030.minNumberdisappered(arr));
    }

    public int minNumberdisappered(int[] arr) {
        return 0;
    }

}
