package com.leolian.leetcode.questionbank.algorithm.page02;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * LC 57 : 插入区间
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * 提示：
 * 0 <= intervals.length <= 10^4
 * intervals[i].length == 2
 * 0 <=intervals[i][0] <=intervals[i][1] <= 10^5
 * intervals 根据 intervals[i][0] 按 升序 排列
 * newInterval.length == 2
 * 0 <=newInterval[0] <=newInterval[1] <= 10^5
 * <p>
 * 示例1
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * <p>
 * 示例2
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10]重叠。
 * <p>
 * 示例3
 * 输入：intervals = [], newInterval = [5,7]
 * 输出：[[5,7]]
 * <p>
 * 示例4
 * 输入：intervals = [[1,5]], newInterval = [2,3]
 * 输出：[[1,5]]
 * <p>
 * 示例5
 * 输入：intervals = [[1,5]], newInterval = [2,7]
 * 输出：[[1,7]]
 */
public class LC_0057 {

    public static void main(String[] args) {
        LC_0057 lc0055 = new LC_0057();

        // {1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}
        // {1,3},{6,9}
        int[][] intervals = {
                {1,5}
        };
        int[] newInterval = {2, 7};
        int[][] result = lc0055.insert(intervals, newInterval);
        for (int i = 0; i < result.length; i++) {
            System.out.printf(Arrays.toString(result[i]) + " ");
        }
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            int[][] result = new int[1][2];
            result[0] = newInterval;
            return result;
        }
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        int startIndex = -1;
        int endIndex = -1;
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (start <= newStart && newStart <= end) {
                startIndex = i;
            }
            if (start <= newEnd && newEnd <= end) {
                endIndex = i;
            }
        }
        boolean merge = startIndex != endIndex;
        ArrayList<int[]> list = new ArrayList<>();
        int start = -1;
        for (int i = 0; i < intervals.length; i++) {
            if (merge) {
                if (startIndex <= i && i <= endIndex) {
                    if (i == startIndex) {
                        start = Math.min(newStart, intervals[i][0]);
                    }
                    if (i == endIndex) {
                        int[] interval = new int[]{start, Math.max(newEnd, intervals[i][1])};
                        list.add(interval);
                    }
                    continue;
                }
            }
            if (i == startIndex) {
                int[] interval = new int[]{Math.min(newStart, intervals[i][0]),
                        Math.max(newEnd, intervals[i][1])};
                list.add(interval);
                continue;
            }
            list.add(intervals[i]);
        }
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    /*

     */
}
