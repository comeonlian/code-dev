package com.leolian.leetcode.questionbank.algorithm.page17;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * LC 821 : 字符的最短距离
 * 给你一个字符串 s 和一个字符 c ，且 c 是 s 中出现过的字符。
 * 返回一个整数数组 answer ，其中 answer.length == s.length 且 answer[i] 是 s 中从下标 i 到离它 最近 的字符 c 的 距离 。
 * 两个下标 i 和 j 之间的 距离 为 abs(i - j) ，其中 abs 是绝对值函数。
 * 提示：
 * 1 <= s.length <= 104
 * s[i] 和 c 均为小写英文字母
 * 题目数据保证 c 在 s 中至少出现一次
 * <p>
 * 示例1
 * 输入：s = "loveleetcode", c = "e"
 * 输出：[3,2,1,0,1,0,0,1,2,2,1,0]
 * 解释：字符 'e' 出现在下标 3、5、6 和 11 处（下标从 0 开始计数）。
 * 距下标 0 最近的 'e' 出现在下标 3 ，所以距离为 abs(0 - 3) = 3 。
 * 距下标 1 最近的 'e' 出现在下标 3 ，所以距离为 abs(1 - 3) = 2 。
 * 对于下标 4 ，出现在下标 3 和下标 5 处的 'e' 都离它最近，但距离是一样的 abs(4 - 3) == abs(4 - 5) = 1 。
 * 距下标 8 最近的 'e' 出现在下标 6 ，所以距离为 abs(8 - 6) = 2 。
 * <p>
 * 示例2
 * 输入：s = "aaab", c = "b"
 * 输出：[3,2,1,0]
 */
public class LC_0821 {

    public static void main(String[] args) {
        LC_0821 lc0821 = new LC_0821();

        String s = "loveleetcode";
        char c = 'e';
        System.out.println(Arrays.toString(lc0821.shortestToChar(s, c)));
    }

    public int[] shortestToChar(String s, char c) {
        if (null == s || s.length() == 0) {
            return new int[0];
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (c == s.charAt(i)) {
                list.add(i);
            }
        }
        if (list.size() == 0) {
            return new int[0];
        }
        int[] res = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int val = calLen(i, list);
            res[i] = val;
        }
        return res;
    }

    public int calLen(int i, ArrayList<Integer> list) {
        if (i < list.get(0)) {
            return list.get(0) - i;
        } else if (i > list.get(list.size() - 1)) {
            return i - list.get(list.size() - 1);
        } else {
            int start = 0;
            int end = list.size() - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (list.get(mid) == i) {
                    return 0;
                } else if (list.get(mid) > i) {
                    end = mid - 1;
                } else {
                    start = start + 1;
                }
            }
            return Math.min(Math.abs(list.get(start) - i), Math.abs(list.get(end) - i));
        }
    }
}
