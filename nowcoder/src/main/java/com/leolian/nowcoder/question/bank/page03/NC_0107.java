package com.leolian.nowcoder.question.bank.page03;

/**
 * NC 107 : 寻找峰值
 * <p>
 * 题目描述
 * 山峰元素是指其值大于或等于左右相邻值的元素。
 * 给定一个输入数组nums，任意两个相邻元素值不相等，数组可能包含多个山峰。
 * 找到索引最大的那个山峰元素并返回其索引。
 * 假设 nums[-1] = nums[n] = -∞。
 * <p>
 * 示例1
 * 输入：[2,4,1,2,7,8,4]
 * 返回值：5
 */
public class NC_0107 {

    public static void main(String[] args) {
        NC_0107 nc0107 = new NC_0107();

        int[] arr = new int[]{2, 4, 1, 2, 7, 8, 4};
        System.out.println(nc0107.solve(arr));
    }

    /**
     * 寻找最后的山峰
     *
     * @param a int整型一维数组
     * @return int整型
     */
    public int solve(int[] a) {
        if (null == a || a.length == 0) {
            return -1;
        }
        if (a.length == 1) {
            return 0;
        }
        int resultIndex = -1;
        if (a[0] >= a[1]) {
            resultIndex = 0;
        }
        int i = 1;
        for (; i < a.length - 1; i++) {
            int left = a[i - 1];
            int cur = a[i];
            int right = a[i + 1];
            if (cur >= right && cur >= left) {
                resultIndex = i;
            }
        }
        if (a[i] > a[i - 1]) {
            resultIndex = i;
        }
        return resultIndex;
    }

}
