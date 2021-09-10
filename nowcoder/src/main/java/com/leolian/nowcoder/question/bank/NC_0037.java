package com.leolian.nowcoder.question.bank;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * NC 37 : 合并区间
 * <p>
 * 题目描述
 * 给出一组区间，请合并所有重叠的区间。
 * 请保证合并后的区间按区间起点升序排列。
 * <p>
 * 示例1
 * 输入：[[10,30],[20,60],[80,100],[150,180]]
 * 返回值：[[10,60],[80,100],[150,180]]
 */
public class NC_0037 {

    public static void main(String[] args) {
        NC_0037 nc0037 = new NC_0037();

        ArrayList<Interval> intervals = new ArrayList<>();
        Interval val1 = new Interval(1, 4);
        Interval val2 = new Interval(2, 3);
        Interval val3 = new Interval(80, 160);
        Interval val4 = new Interval(150, 180);
        intervals.add(val1);
        intervals.add(val2);
        intervals.add(val3);
        intervals.add(val4);

        System.out.println(nc0037.merge(intervals));
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if (null == intervals || intervals.size() == 0) {
            return new ArrayList<>();
        }
        if (intervals.size() == 1) {
            return intervals;
        }
        intervals.sort(Comparator.comparingInt(v -> v.start));
        ArrayList<Interval> res = new ArrayList<>();
        Interval first = intervals.get(0);
        int preStart = first.start;
        int preEnd = first.end;
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (cur.start > preEnd) {
                res.add(new Interval(preStart, preEnd));
                preStart = cur.start;
                preEnd = cur.end;
            } else if (cur.end > preEnd) {
                preEnd = cur.end;
            }
        }
        res.add(new Interval(preStart, preEnd));
        return res;
    }

    private static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return "[" +
                    "start=" + start +
                    ", end=" + end +
                    ']';
        }
    }
}
