package com.leolian.nowcoder.question.bank;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * NC 54 : 数组中相加和为0的三元组
 * <p>
 * 给出一个有n个元素的数组S，S中是否有元素a,b,c满足a+b+c=0？找出数组S中所有满足条件的三元组。
 * 注意：
 * 三元组（a、b、c）中的元素必须按非降序排列。（即a≤b≤c）
 * 解集中不能包含重复的三元组。
 * 例如，给定的数组 S = {-10 0 10 20 -10 -40},解集为(-10, 0, 10) (-10, -10, 20)
 * <p>
 * 示例1 :
 * 输入
 * [-2,0,1,1,2]
 * 返回值
 * [[-2,0,2],[-2,1,1]]
 */
public class NC_0054 {

    public static void main(String[] args) {
        NC_0054 nc0054 = new NC_0054();

        // -2,0,1,1,2
        // -10, 0, 10, 20, -10, -40
        // -2,0,0,2,2
        // -4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6
        int[] num = new int[]{
                -4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6
        };

        ArrayList<ArrayList<Integer>> arrayLists = nc0054.threeSum(num);
        System.out.println(arrayLists);
    }

    /**
     * 程序员代码面试指南：IT名企算法与数据结构题目最优解》
     * 第8章：不重复打印排序数组中相加和为给定值的所有二元组和三元组
     * <p>
     * 三元组的问题类似于二元组的求解过程。
     * 例如：
     * arr=[-8，-4，-3，0，1，2，4，5，8，9]，k =10。
     * ● 当三元组的第⼀个值为-8时，寻找-8后面的⼦数组中所有相加
     * 为18的不重复二元组。
     * ● 当三元组的第⼀个值为-4时，寻找-4后面的⼦数组中所有相加
     * 为14的不重复二元组。
     * ● 当三元组的第⼀个值为-3时，寻找-3后面的⼦数组中所有相加
     * 为13的不重复二元组。
     * 依此类推。
     * 如何不重复打印相同的三元组呢？首先要保证每次寻找过程开始前，
     * 选定的三元组中第⼀个值不重复，其次就是和原问题的打印检查⼀样，要保证不重复打印二元组。
     * 利用排序后的数组的特点，打印⼆元组的过程可以用⼀个左指针
     * 和⼀个右指针不断向中间压缩的⽅式实现，具体过程为：
     * 1．设置变量left=0，right=arr.length-1。
     * 2．⽐较arr[left]+arr[right]的值(sum)与k 的⼤⼩：
     * ● 如果sum等于k ，打印“arr[left]，arr[right]”，则left++，right--。
     * ● 如果sum大于k ，right--。
     * ● 如果sum小于k ，left++。
     * 3．如果left<right，则⼀直重复步骤2，否则过程结束。
     * 那么如何保证不重复打印相同的二元组呢？只需在打印时增加⼀
     * 个检查即可，检查arr[left]是否与它前⼀个值arr[left-1]相等，如果相等
     * 就不打印。具体解释为：因为整体过程是从两头向中间压缩的过程，
     * 如果arr[left]+arr[right]==k，⼜有arr[left]==arr[left-1]，那么之前⼀定已
     * 经打印过这个二元组，此时⽆须重复打印。比如arr=[1，1，1，9]，
     * k=10。⾸先打印arr[0]和arr[3]的组合，接下来就不再重复打印1和9这个二元组。
     *
     * @param num
     * @return
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        if (num.length < 3) {
            return new ArrayList<>();
        }
        // 让数组有序
        Arrays.sort(num);
        int sum, left, right;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
            int first = num[i];
            if ((i - 1) >= 0 && first == num[i - 1]) {
                continue;
            }
            if (first > 0) {
                break;
            }
            sum = -first;
            left = i + 1;
            right = num.length - 1;
            while (left < right) {
                int sumTemp = num[left] + num[right];
                if (sumTemp > sum) {
                    right -= 1;
                } else if (sumTemp < sum) {
                    left += 1;
                } else {
                    if ((left - 1) == i) {
                        ArrayList<Integer> tuple = new ArrayList<>();
                        tuple.add(first);
                        tuple.add(num[left]);
                        tuple.add(num[right]);
                        list.add(tuple);
                    } else if (num[left] != num[left - 1]) {
                        ArrayList<Integer> tuple = new ArrayList<>();
                        tuple.add(first);
                        tuple.add(num[left]);
                        tuple.add(num[right]);
                        list.add(tuple);
                    }
                    left++;
                    right--;
                }
            }
        }
        return list;
    }

}
