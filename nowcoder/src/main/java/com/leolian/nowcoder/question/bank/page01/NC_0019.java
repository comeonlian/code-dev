package com.leolian.nowcoder.question.bank.page01;

/**
 * NC 22 : 子数组的最大累加和问题
 * <p>
 * 题目描述
 * 给定一个数组arr，返回子数组的最大累加和
 * 例如，arr = [1, -2, 3, 5, -2, 6, -1]，所有子数组中，[3, 5, -2, 6]可以累加出最大的和12，所以返回12.
 * 题目保证没有全为负数的数据
 * [要求]
 * 时间复杂度为O(n)O(n)，空间复杂度为O(1)O(1)
 * <p>
 * 示例1:
 * 输入：
 * [1, -2, 3, 5, -2, 6, -1]
 * 返回值：
 * 12
 * 备注：
 * 1≤N≤10^5
 * ∣arri∣≤100
 */
public class NC_0019 {

    public static void main(String[] args) {
        NC_0019 nc0019 = new NC_0019();

        int[] arr = new int[]{1, -2, 3, 5, -2, 6, -1};

        int res = nc0019.maxsumofSubarray(arr);
        System.out.println(res);
    }


    /**
     * 2、《程序员代码面试指南：IT名企算法与数据结构题目最优解》
     * 第8章：⼦数组的最⼤累加和问题
     * 如果arr中有正数，从左到右遍历arr，⽤变量cur记录每⼀步的累加 和，遍历到正数cur增加，遍历到负数cur减少。
     * 当cur<0时，说明累加 到当前数出现了⼩于0的结果，那么累加的这⼀部分肯定不能作为产⽣ 最⼤累加和的⼦数组的左边部分，
     * 此时令cur=0，表⽰重新从下⼀个数 开始累加。当cur>=0时，每⼀次累加都可能是最⼤的累加和，
     * 所以， ⽤另外⼀个变量max全程跟踪记录cur出现的最⼤值即可
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxsumofSubarray(int[] arr) {
        if (null == arr || arr.length == 0) {
            return 0;
        }
        int max = 0;
        int curSum = arr[0];
        if (curSum > max) {
            max = curSum;
        }
        for (int i = 1; i < arr.length; i++) {
            curSum = curSum + arr[i];
            if (curSum < 0) {
                curSum = 0;
                continue;
            }
            if (curSum > max) {
                max = curSum;
            }
        }
        return max;
    }

}
