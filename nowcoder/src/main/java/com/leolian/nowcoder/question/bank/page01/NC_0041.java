package com.leolian.nowcoder.question.bank.page01;

import java.util.HashMap;

/**
 * NC 41 : 最长无重复子数组
 * <p>
 * 给定一个数组arr，返回arr的最长无重复元素子数组的长度，无重复指的是所有数字都不相同。
 * 子数组是连续的，比如[1,3,5,7,9]的子数组有[1,3]，[3,5,7]等等，但是[1,3,7]不是子数组
 * 备注：
 * 1≤n≤10^5
 * <p>
 * 示例1
 * 输入：[2,3,4,5]
 * 返回值：4
 * 说明：[2,3,4,5]是最长子数组
 * 示例2
 * 输入：[2,2,3,4,3]
 * 返回值：3
 * 说明：[2,3,4]是最长子数组
 * 示例3
 * 输入：[9]
 * 返回值：1
 * 说明：[2,3,4]是最长子数组
 * 示例4
 * 输入：[1,2,3,1,2,3,2,2]
 * 返回值：3
 * 说明：最长子数组为[1,2,3]
 * 示例5
 * 输入：[2,2,3,4,8,99,3]
 * 返回值：5
 * 说明：最长子数组为[2,3,4,8,99]
 */
public class NC_0041 {

    public static void main(String[] args) {
        NC_0041 nc0041 = new NC_0041();

        int[] arr = new int[]{3, 3, 2, 1, 3, 3, 3, 1};
        System.out.println(nc0041.maxLength(arr));
    }

    public int maxLength(int[] arr) {
        if (null == arr) {
            return 0;
        }
        if (arr.length == 1) {
            return 1;
        }
        int maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>(arr.length);
        for (int start = 0, end = 0; end < arr.length; end++) {
            int val = arr[end];
            if (map.containsKey(val)) {
                maxLen = Math.max(maxLen, end - start);
                start = Math.max(start, map.get(val) + 1);
                map.remove(val);
            } else {
                maxLen = Math.max(maxLen, end - start + 1);
            }
            map.put(val, end);
        }
        return maxLen;
    }

}
