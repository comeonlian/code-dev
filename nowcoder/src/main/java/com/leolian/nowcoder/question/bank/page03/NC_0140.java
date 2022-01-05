package com.leolian.nowcoder.question.bank.page03;

import java.util.Arrays;

/**
 * NC 140 : 排序
 * <p>
 * 描述
 * 给定一个数组，请你编写一个函数，返回该数组排序后的形式。
 * <p>
 * 示例1
 * 输入：[5,2,3,1,4]
 * 返回值：[1,2,3,4,5]
 * <p>
 * 示例2
 * 输入：[5,1,6,2,5]
 * 返回值：[1,2,5,5,6]
 * <p>
 * 备注：
 * 数组的长度不大于100000，数组中每个数的绝对值不超过10^9
 */
public class NC_0140 {

    public static void main(String[] args) {
        NC_0140 nc0140 = new NC_0140();

        int[] array = new int[]{5, 1, 6, 2, 5};
        int[] res = nc0140.MySort(array);
        System.out.println(Arrays.toString(res));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 将给定数组排序
     *
     * @param arr int整型一维数组 待排序的数组
     * @return int整型一维数组
     */
    public int[] MySort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int[] temp = new int[arr.length];
        sort(arr, left, right, temp);
        return arr;
    }

    public void sort(int[] arr, int left, int right, int[] temp) {
        int mid = (left + right) / 2;
        if (left < right) {
            // 向左递归分解
            sort(arr, left, mid, temp);
            // 向右递归分解
            sort(arr, mid + 1, right, temp);
        }
        merge(arr, left, mid, right, temp);
    }

    /**
     * @param arr
     * @param left
     * @param mid
     * @param right
     * @param temp
     */
    public void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int leftTemp = left;
        int rightTemp = mid + 1;
        int tempIndex = 0;
        while (leftTemp <= mid && rightTemp <= right) {
            if (arr[leftTemp] < arr[rightTemp]) {
                temp[tempIndex] = arr[leftTemp];
                tempIndex += 1;
                leftTemp += 1;
            } else {
                temp[tempIndex] = arr[rightTemp];
                tempIndex += 1;
                rightTemp += 1;
            }
        }
        while (leftTemp <= mid) {
            temp[tempIndex] = arr[leftTemp];
            tempIndex += 1;
            leftTemp += 1;
        }
        while (rightTemp <= right) {
            temp[tempIndex] = arr[rightTemp];
            tempIndex += 1;
            rightTemp += 1;
        }
        // 拷贝回原数组
        tempIndex = 0;
        int leftTempIndex = left;
        while (leftTempIndex <= right) {
            arr[leftTempIndex] = temp[tempIndex];
            leftTempIndex += 1;
            tempIndex += 1;
        }
    }
    
    /*
    运行时间：665ms
    超过58.37% 用Java提交的代码
    占用内存：54668KB
    超过15.57%用Java提交的代码
    */

}
