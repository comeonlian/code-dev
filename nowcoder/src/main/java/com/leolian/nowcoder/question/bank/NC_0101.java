package com.leolian.nowcoder.question.bank;

/**
 * NC 101 : 缺失数字
 * <p>
 * 题目描述
 * 从0,1,2,...,n这n+1个数中选择n个数，找出这n个数中缺失的那个数，要求O(n)尽可能小。
 * <p>
 * 示例1 :
 * 输入：[0,1,2,3,4,5,7]
 * 返回值：6
 * <p>
 * 示例2 :
 * 输入：[0,2,3]
 * 返回值：1
 */
public class NC_0101 {

    public static void main(String[] args) {
        NC_0101 nc0101 = new NC_0101();

        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(nc0101.solve(arr));
    }

    /**
     * 找缺失数字
     *
     * @param a int 整型一维数组 给定的数字串
     * @return int整型
     */
    public int solve(int[] a) {
        if (a.length < 2) {
            return 0;
        }
        int startIndex = 0;
        int endIndex = a.length - 1;
        int startVal = a[startIndex];
        int endVal = a[endIndex];
        if ((startVal - startIndex) == (endVal - endIndex)) {
            if (startVal != 0) { // 处理左边界值
                return 0;
            } else { //处理右边界值
                return endVal + 1;
            }
        } else { // 中间缺失情况
            return search(startIndex, endIndex, a);
        }
    }

    public int search(int startIndex, int endIndex, int[] arr) {
        if (startIndex == (endIndex - 1)) {
            int target = (arr[startIndex] + arr[endIndex]) / 2;
            return target;
        } else {
            int mid = (startIndex + endIndex) / 2;
            int startVal = arr[startIndex];
            int midVal = arr[mid];
            if ((startVal - startIndex) < (midVal - mid)) {
                return search(startIndex, mid, arr);
            } else {
                return search(mid, endIndex, arr);
            }
        }
    }

}
