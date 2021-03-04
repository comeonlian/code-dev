package com.leolian.leetcode.explore.primaryalgorithm.array;

import java.util.Arrays;

/**
 * LC 移动零:
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * <p>
 * 输入: [4,2,4,0,0,3,0,5,1,0]
 * 输出: [4,2,4,3,5,1,0,0,0,0]
 * <p>
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class Array008 {

    public static void main(String[] args) {
        Array008 array008 = new Array008();

        int[] array = new int[]{4, 2, 4, 0, 0, 3, 0, 5, 1, 0};
//        array008.moveZeroes(array);

        array008.moveZeroes2(array);

        System.out.println("Result array: " + Arrays.toString(array));
    }


    /**
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] == 0 && nums[j + 1] != 0) {
                    nums[j] = nums[j + 1];
                    nums[j + 1] = 0;
                }
            }
        }
    }
    /*
    执行结果：通过
    执行用时：94 ms, 在所有 Java 提交中击败了5.20%的用户
    内存消耗：39 MB, 在所有 Java 提交中击败了18.37%的用户
    */


    /**
     * 两次遍历
     * 我们创建两个指针i和j，第一次遍历的时候指针j用来记录当前有多少非0元素。即遍历的时候每遇到一个非0元素就将其往数组左边挪，
     * 第一次遍历完后，j指针的下标就指向了最后一个非0元素下标。
     * 第二次遍历的时候，起始位置就从j开始到结束，将剩下的这段区域内的元素全部置为0。
     * <p>
     * 一次遍历
     * 这里参考了快速排序的思想，快速排序首先要确定一个待分割的元素做中间点x，然后把所有小于等于x的元素放到x的左边，大于x的元素放到其右边。
     * 这里我们可以用0当做这个中间点，把不等于0(注意题目没说不能有负数)的放到中间点的左边，等于0的放到其右边。
     * 这的中间点就是0本身，所以实现起来比快速排序简单很多，我们使用两个指针i和j，只要nums[i]!=0，我们就交换nums[i]和nums[j]
     *
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        if (null == nums) {
            return;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
//        System.out.println(Arrays.toString(nums));
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
    /*
    执行结果：通过
    执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
    内存消耗：38.8 MB, 在所有 Java 提交中击败了42.40%的用户
    */

}
