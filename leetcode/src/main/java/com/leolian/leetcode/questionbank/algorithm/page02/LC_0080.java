package com.leolian.leetcode.questionbank.algorithm.page02;

/**
 * LC 80 : 删除有序数组中的重复项 II
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 提示：
 * 1 <= nums.length <= 3 * 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums 已按升序排列
 * <p>
 * 示例 1:
 * 输入：nums = [1,1,1,2,2,3]
 * 输出：5, nums = [1,1,2,2,3]
 * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。 不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 2:
 * 输入：nums = [0,0,1,1,1,1,2,3,3]
 * 输出：7, nums = [0,0,1,1,2,3,3]
 * 解释：函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。 不需要考虑数组中超出新长度后面的元素。
 */
public class LC_0080 {

    public static void main(String[] args) {
        LC_0080 lc_0080 = new LC_0080();

        int[] nums = new int[]{1, 1, 1, 2, 3, 3};
        System.out.println(lc_0080.removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int totalCount = 0;
        int curVal = 0;
        int valCount = 0;
        int setIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (valCount == 0) {
                curVal = val;
                valCount = 1;
                setIndex++;
                totalCount++;
            } else {
                if (curVal == val) {
                    if (valCount <= 2) {
                        if (valCount < 2) {
                            totalCount++;
                            nums[setIndex++] = curVal;
                        }
                    }
                    valCount++;
                } else {
                    curVal = val;
                    valCount = 1;
                    nums[setIndex++] = curVal;
                    totalCount++;
                }
            }
        }
        return totalCount;
    }

	/*
	执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
    内存消耗：42.5 MB, 在所有 Java 提交中击败了5.13%的用户
    通过测试用例：164 / 164
	*/
}
