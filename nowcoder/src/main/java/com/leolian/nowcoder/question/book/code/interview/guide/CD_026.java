package com.leolian.nowcoder.question.book.code.interview.guide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * CD 26 : 数组的最大累加和问题
 * <p>
 * 题目描述
 * 给定一个数组arr，返回子数组的最大累加和
 * 例如，arr = [1, -2, 3, 5, -2, 6, -1]，所有子数组中，[3, 5, -2, 6]可以累加出最大的和12，所以返回12.
 * [要求]
 * 时间复杂度为O(n)，空间复杂度为O(1)
 * <p>
 * 输入描述：
 * 第一行一个整数N。表示数组长度
 * 接下来一行N个整数表示数组内的元素
 * 输出描述：
 * 输出一个整数表示答案
 * <p>
 * 示例1
 * 输入：
 * 7
 * 1 -2 3 5 -2 6 -1
 * 输出：
 * 12
 * <p>
 * 备注：
 * 1 <= N <= 10^5
 * -100 ⩽ arri ⩽ 100
 */
public class CD_026 {

    public static void main(String[] args) throws IOException {
        CD_026 main = new CD_026();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        String[] strs = bufferedReader.readLine().trim().split(" ");
        int[] array = Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();
        if (array.length != n) {
            return;
        }
        int res = solve(array);
        System.out.println(res);
    }

    private static int solve(int[] array) {
        int maxSum = Integer.MIN_VALUE;
        int sum = array[0];
        for (int i = 1; i < array.length; i++) {
            int val = array[i];
            sum += val;
            if (sum < val) {
                sum = val;
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

}
