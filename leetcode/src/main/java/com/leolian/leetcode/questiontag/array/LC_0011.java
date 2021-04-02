package com.leolian.leetcode.questiontag.array;

/**
 * 11. 盛最多水的容器
 * <p>
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器。
 * <p>
 * 示例 1：
 * https://aliyun-lc-upload.oss-cn-hangzhou.aliyuncs.com/aliyun-lc-upload/uploads/2018/07/25/question_11.jpg
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <p>
 * 示例 2：
 * 输入：height = [1,1]
 * 输出：1
 * <p>
 * 示例 3：
 * 输入：height = [4,3,2,1,4]
 * 输出：16
 * <p>
 * 示例 4：
 * 输入：height = [1,2,1]
 * 输出：2
 * <p>
 * 提示：
 * n = height.length
 * 2 <= n <= 3 * 104
 * 0 <= height[i] <= 3 * 104
 */
public class LC_0011 {

    public static void main(String[] args) {
        LC_0011 object = new LC_0011();

        int[] array = new int[]{
                2, 3, 4, 5, 18, 17, 6
        };

        int maxArea = object.maxArea(array);
        System.out.println(maxArea);
    }


    public int maxArea(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int start = 0;
        int end = height.length - 1;
        int area = 0;
        while (start < end) {
            int hStart = height[start];
            int hEnd = height[end];
            int width = end - start;
            int high = Math.min(hStart, hEnd);
            int areaTmp = width * high;
            if (areaTmp > area) {
                area = areaTmp;
            }
            start++;
        }
        return area;
    }

}
