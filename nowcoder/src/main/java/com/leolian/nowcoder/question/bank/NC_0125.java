package com.leolian.nowcoder.question.bank;

import java.util.HashMap;

/**
 * NC 125 : 未排序数组中累加和为给定值的最长子数组长度
 * <p>
 * 题目描述
 * 给定一个无序数组arr, 其中元素可正、可负、可0。给定一个整数k，求arr所有连续子数组中累加和为k的最长子数组长度。
 * 保证至少存在一个合法的子数组。
 * 备注：
 * 1⩽N⩽10^5
 * −10^9⩽k⩽10^9
 * −100⩽arri⩽100
 * <p>
 * 示例1
 * 输入：[1,-2,1,1,1],0
 * 返回值：3
 */
public class NC_0125 {

    public static void main(String[] args) {
        NC_0125 nc0125 = new NC_0125();

        int[] arr = new int[]{1, -2, 1, 1, 1};
        int k = 0;
        System.out.println(nc0125.maxlenEqualK(arr, k));
    }

    public int maxlenEqualK(int[] arr, int k) {
        if (null == arr || arr.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0, len = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - k)) {
                len = Math.max(len, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)) {
                map.put(sum , i);
            }
        }
        return len;
    }

//    /**
//     * 暴力解法，时间复杂度o(n^2)，性能太差
//     * 
//     * @param arr int整型一维数组 the array
//     * @param k   int整型 target
//     * @return int整型
//     */
//    public int maxlenEqualK(int[] arr, int k) {
//        if (null == arr || arr.length == 0) {
//            return 0;
//        }
//        int sum = 0, maxLen = 0;
//        for (int i = 0; i < arr.length; i++) {
//            sum = 0;
//            for (int j = i; j < arr.length; j++) {
//                sum = sum + arr[j];
//                if (sum == k) {
//                    int len = j - i + 1;
//                    if (len > maxLen) {
//                        maxLen = len;
//                    }
//                }
//            }
//        }
//        return maxLen;
//    }
}
