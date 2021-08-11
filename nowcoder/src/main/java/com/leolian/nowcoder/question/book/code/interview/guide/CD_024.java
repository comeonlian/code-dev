package com.leolian.nowcoder.question.book.code.interview.guide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * CD 24 : 奇数下标都是奇数或者偶数下标都是偶数
 * <p>
 * 题目描述
 * 描述
 * 给定一个长度不小于2的数组arr，实现一个函数调整arr，要么让所有的偶数下标都是偶数，要么让所有的奇数下标都是奇数
 * 注意：
 * 1、数组下标从0开始！
 * 2、本题有special judge，你可以输出任意一组合法解！同时可以证明解一定存在
 * [要求]
 * 时间复杂度为O(n)，额外空间复杂度为O(1)
 * <p>
 * 输入描述：
 * 第一行一个整数N。表示数组长度
 * 接下来一行N个整数表示数组内的数
 * 输出描述：
 * 输出N个整数。表示调整后的数组
 * <p>
 * 示例1
 * 输入：
 * 5
 * 1 2 3 4 5
 * 输出：
 * 2 1 4 3 5
 * 说明：
 * 样例中的输出保证了奇数下标都是奇数
 * <p>
 * 备注：
 * 2 <= N <= 10^5
 * 0 ⩽ arri ⩽10^9
 */
public class CD_024 {

    public static void main(String[] args) throws IOException {
        CD_024 main = new CD_024();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        String[] strs = bufferedReader.readLine().trim().split(" ");
        int[] array = Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();
        solve(array);
        for (int val : array) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    /**
     * @param array
     */
    private static void solve(int[] array) {
        int start = 0;
        int end = array.length - 1;
        while (start < array.length) {
            int startVal = array[start];
            if (((start % 2) == 0 && (startVal % 2) == 0) ||
                    ((start % 2) != 0 && (startVal % 2) != 0)) {
            } else {
                while (end > start) {
                    int endVal = array[end];
                    if (((end % 2) == 0 && (endVal % 2) == 0) ||
                            ((end % 2) != 0 && (endVal % 2) != 0)) {
                    } else {
                        if (((startVal % 2) == 0 && (endVal % 2) == 0) ||
                                ((startVal % 2) != 0 && (endVal % 2) != 0)) {
                        } else {
                            array[start] = endVal;
                            array[end] = startVal;
                            end--;
                            break;
                        }
                    }
                    end--;
                }
            }
            start++;
        }
    }

}
