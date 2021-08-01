package com.leolian.nowcoder.question.book.sword.finger.offer;

/**
 * JZ 1 : 二维数组中的查找
 * <p>
 * 题目描述
 * 在一个二维数组array中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * [
 * [1,2,8,9],
 * [2,4,9,12],
 * [4,7,10,13],
 * [6,8,11,15]
 * ]
 * 给定 target = 7，返回 true。
 * 给定 target = 3，返回 false。
 * 0 <= array.length <= 500
 * 0 <= array[0].length <= 500
 * <p>
 * 示例1
 * 输入：7,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
 * 返回值：true
 * 说明：
 * 存在7，返回true
 * <p>
 * 示例2
 * 输入：3,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
 * 返回值：false
 * 说明：
 * 不存在3，返回false
 */
public class JZ_001 {

    public static void main(String[] args) {
        JZ_001 jz001 = new JZ_001();

        int[][] array = new int[][]{
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        int target = 3;
        System.out.println(jz001.Find(target, array));
    }

    public boolean Find(int target, int[][] array) {
        if (null == array || array.length == 0) {
            return false;
        }
        int len1 = array.length;
        int len2 = array[0].length;
        if (len2 == 0 || target < array[0][0] || target > array[len1 - 1][len2 - 1]) {
            return false;
        }
        int startVal, endVal;
        int startIndex, endIndex, mid;
        for (int i = len1 - 1; i >= 0; i--) {
            int[] sub = array[i];
            startVal = sub[0];
            endVal = sub[sub.length - 1];
            if (target == startVal || target == endVal) {
                return true;
            }
            if (target < startVal || target > endVal) {
                continue;
            }
            startIndex = 0;
            endIndex = sub.length - 1;
            while (startIndex < endIndex) {
                mid = (startIndex + endIndex) / 2;
                if (target == sub[mid]) {
                    return true;
                } else if (target < sub[mid]) {
                    endIndex = mid - 1;
                } else {
                    startIndex = mid + 1;
                }
            }
        }
        return false;
    }

}
