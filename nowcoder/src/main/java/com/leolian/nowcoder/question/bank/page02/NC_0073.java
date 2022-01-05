package com.leolian.nowcoder.question.bank.page02;

import java.util.Arrays;

/**
 * NC 73 : 数组中出现次数超过一半的数字
 * <p>
 * 题目描述
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组[1,2,3,2,2,2,5,4,2]。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。1<=数组长度<=50000
 * <p>
 * 示例1:
 * 输入: [1,2,3,2,2,2,5,4,2]
 * 返回: 2
 * <p>
 * 示例2:
 * 输入：[3,3,3,3,2,2,2]
 * 返回值：3
 * <p>
 * 示例3:
 * 输入：[1]
 * 返回值：1
 */
public class NC_0073 {

    public static void main(String[] args) {
        NC_0073 nc0073 = new NC_0073();

        int[] arr = new int[]{1,2,3,2,2,2,5,4,2};
        System.out.println(nc0073.MoreThanHalfNum_Solution(arr));
    }

    /**
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int[] array) {
        if (null == array) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        Arrays.sort(array);
        int mid = array.length / 2;
        return array[mid];
    }

    /**
     * 性能较差
     *
     * @param array
     * @return
     */
//    public int MoreThanHalfNum_Solution(int[] array) {
//        if (null == array) {
//            return 0;
//        }
//        if (array.length == 1) {
//            return array[0];
//        }
//        HashMap<Integer, Integer> map = new HashMap<>(array.length);
//        for (int key : array) {
//            if (map.containsKey(key)) {
//                Integer val = map.get(key) + 1;
//                map.remove(key);
//                map.put(key, val);
//            } else {
//                map.put(key, 1);
//            }
//        }
//        int arrHalf = array.length / 2;
//        int maxKey = 0;
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            Integer val = entry.getValue();
//            if (val > arrHalf) {
//                maxKey = entry.getKey();
//                break;
//            }
//        }
//        return maxKey;
//    }

}

