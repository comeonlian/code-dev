package com.leolian.nowcoder.question.bank;

/**
 * NC 160 : 二分查找-I
 * <p>
 * 题目描述
 * 请实现无重复数字的升序数组的二分查找
 * 给定一个 元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1
 * <p>
 * 示例1
 * 输入：[-1,0,3,4,6,10,13,14],13
 * 返回值：6
 * 说明：
 * 13 出现在nums中并且下标为 6
 * <p>
 * 示例2
 * 输入：[],3
 * 返回值：-1
 * 说明：
 * nums为空，返回-1
 * <p>
 * 示例3
 * 输入：[-1,0,3,4,6,10,13,14],2
 * 返回值：-1
 * 说明：
 * 2 不存在nums中因此返回 -1
 */
public class NC_0160 {

    public static void main(String[] args) {
        NC_0160 nc0160 = new NC_0160();

        int[] nums = new int[]{-1, 0, 3, 4, 6, 10, 13, 14};
        int target = 2;
        System.out.println(nc0160.search(nums, target));
    }


    /**
     * @param nums   int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public int search(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return -1;
        }
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        return binary(nums, target, 0, nums.length - 1);
    }

    public int binary(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (target == nums[mid]) {
            return mid;
        } else if (target < nums[mid]) {
            return binary(nums, target, start, mid - 1);
        } else if (target > nums[mid]) {
            return binary(nums, target, mid + 1, end);
        }
        return -1;
    }

}
