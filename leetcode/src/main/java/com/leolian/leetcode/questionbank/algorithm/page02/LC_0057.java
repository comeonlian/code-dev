package com.leolian.leetcode.questionbank.algorithm.page02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.concurrent.atomic.AtomicInteger;

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

        // {1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}  {4,8}
        // {1,3},{6,9}   {2,5}
        // {1, 5}   {0, 3}
        int[][] intervals = {
                {1, 5}
        };
        int[] newInterval = {6, 8};
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

        Node head = new Node(-1, null);
        Node current = head;
        for (int[] interval : intervals) {
            Node start = new Node(interval[0], Flag.START);
            Node end = new Node(interval[1], Flag.END);
            start.next = end;

            current.next = start;
            current = end;
        }

        int newStart = newInterval[0];
        int newEnd = newInterval[1];

        Node pre = head;
        current = head.next;
        boolean insert = false;
        while (current != null) {
            if (newStart <= current.value) {
                Node newStartNode = new Node(newStart, Flag.NEW_START);
                pre.next = newStartNode;
                newStartNode.next = current;
                insert = true;
                break;
            }
            pre = current;
            current = current.next;
        }
        if (!insert) {
            pre.next = new Node(newStart, Flag.NEW_START);
        }
        
        pre = head;
        current = head.next;
        boolean insertEnd = false;
        while (current != null) {
            if (newEnd < current.value) {
                Node newEndNode = new Node(newEnd, Flag.NEW_END);
                pre.next = newEndNode;
                newEndNode.next = current;
                insertEnd = true;
                break;
            }
            pre = current;
            current = current.next;
        }
        if (!insertEnd) {
            pre.next = new Node(newEnd, Flag.NEW_END);
        }

        ArrayList<int[]> list = new ArrayList<>();
        EnumMap<Flag, AtomicInteger> map = new EnumMap<>(Flag.class);
        current = head.next;
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        while (current != null) {
            Flag flag = current.flag;
            if (flag == Flag.START || flag == Flag.NEW_START) {
                if (map.containsKey(flag)) {
                    map.get(flag).incrementAndGet();
                } else {
                    map.put(flag, new AtomicInteger(1));
                }
                start = Math.min(start, current.value);
            }
            if (flag == Flag.END || flag == Flag.NEW_END) {
                if (flag == Flag.END && map.containsKey(Flag.START)) {
                    int count = map.get(Flag.START).decrementAndGet();
                    if (count == 0) {
                        map.remove(Flag.START);
                    }
                }
                if (flag == Flag.NEW_END && map.containsKey(Flag.NEW_START)) {
                    int count = map.get(Flag.NEW_START).decrementAndGet();
                    if (count == 0) {
                        map.remove(Flag.NEW_START);
                    }
                }
                end = Math.max(end, current.value);
                if (map.size() == 0) {
                    list.add(new int[]{start, end});
                    start = Integer.MAX_VALUE;
                    end = Integer.MIN_VALUE;
                }
            }
            current = current.next;
        }

        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static class Node {
        int value;
        Flag flag;
        Node next;

        public Node() {
        }

        public Node(int value, Flag flag) {
            this.value = value;
            this.flag = flag;
        }
    }

    public enum Flag {
        START,
        END,
        NEW_START,
        NEW_END;
    }

    /*
    执行用时：2 ms, 在所有 Java 提交中击败了25.58%的用户
    内存消耗：42.9 MB, 在所有 Java 提交中击败了59.54%的用户
     */
}
