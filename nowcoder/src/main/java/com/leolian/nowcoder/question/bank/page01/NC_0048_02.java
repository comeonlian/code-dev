package com.leolian.nowcoder.question.bank.page01;

/**
 * NC 48 : 在转动过的有序数组中寻找目标值
 * <p>
 * 给出一个转动过的有序数组，你事先不知道该数组转动了多少
 * (例如,0 1 2 4 5 6 7可能变为4 5 6 7 0 1 2).
 * 在数组中搜索给出的目标值，如果能在数组中找到，返回它的索引，否则返回-1。
 * 假设数组中不存在重复项。
 * <p>
 * 示例1 :
 * 输入
 * [1],0
 * 返回值
 * -1
 * 示例2 :
 * 输入
 * [3,2,1],1
 * 返回值
 * 2
 */
public class NC_0048_02 {

    public static void main(String[] args) {
        NC_0048_02 nc0048 = new NC_0048_02();

        int[] arr = new int[]{
                3, 2, 1
        };
        int target = 0;

        int search = nc0048.search(arr, target);
        System.out.println(search);
    }

    /**
     * @param A      int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public int search(int[] A, int target) {
        // write code here
        // TODO
        return -1;
    }

}
