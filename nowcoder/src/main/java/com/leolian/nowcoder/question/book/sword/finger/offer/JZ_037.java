package com.leolian.nowcoder.question.book.sword.finger.offer;

/**
 * JZ 37 : 数字在升序数组中出现的次数
 * <p>
 * 题目描述
 * 统计一个数字在升序数组中出现的次数。
 * <p>
 * 示例1
 * 输入：[1,2,3,3,3,3,4,5],3
 * 返回值：4
 */
public class JZ_037 {

    public static void main(String[] args) {
        JZ_037 jz037 = new JZ_037();

        int[] array = new int[]{1,3,3,3,3,4,5};
        int k = 2;
        System.out.println(jz037.GetNumberOfK(array, k));
    }

    public int GetNumberOfK(int[] array, int k) {
        if (null == array || array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            if (array[0] == k) {
                return 1;
            }
            return 0;
        }
        int start = 0;
        int end = array.length - 1;
        int startVal = array[start];
        int endVal = array[end];
        if (k < startVal || k > endVal) {
            return 0;
        }
        boolean exist = false;
        int mid = (start + end) / 2;
        int count = 0;
        while (start < end) {
            mid = (start + end) / 2;
            int midVal = array[mid];
            if (midVal == k) {
                count++;
                exist = true;
                break;
            } else if (midVal > k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (!exist) {
            return 0;
        }
        int midTmp = mid;
        while ((--midTmp) >= 0) {
            if (array[midTmp] == k) {
                count++;
            }
        }
        midTmp = mid;
        while ((++midTmp) < array.length) {
            if (array[midTmp] == k) {
                count++;
            }
        }
        return count;
    }

}
