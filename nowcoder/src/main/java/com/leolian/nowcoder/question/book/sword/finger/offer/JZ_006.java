package com.leolian.nowcoder.question.book.sword.finger.offer;

/**
 * JZ 6 : 旋转数组的最小数字
 * <p>
 * 题目描述
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * <p>
 * 示例1
 * 输入：[3,4,5,1,2]
 * 返回值：1
 */
public class JZ_006 {

    public static void main(String[] args) {
        JZ_006 jz006 = new JZ_006();

        int[] array = new int[]{1, 0, 1, 1, 1};
        System.out.println(jz006.minNumberInRotateArray(array));
    }

    public int minNumberInRotateArray(int[] array) {
        if (null == array || array.length == 0) {
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (array[mid] == array[left] && array[mid] == array[right]) {
                // 处理最坏情况 [1, 0, 1, 1, 1]
                int min = array[0];
                for (int i = 1; i < array.length; i++) {
                    if (array[i] < min) {
                        min = array[i];
                    }
                }
                return min;
            }
            if (array[mid] >= array[left] && array[mid] <= array[right]) {
                // 处理极端情况 [1, 2, 3, 4, 5, 6]
                return array[left];
            }
            if (array[mid] >= array[left]) {
                left = mid;
            } else {
                right = mid;
            }
            if (left == (right - 1)) {
                return array[right];
            }
        }
        return 0;
    }

}
