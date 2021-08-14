package com.leolian.nowcoder.question.book.code.interview.guide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * CD 73 : 判断一个数是否是回文数
 * <p>
 * 题目描述
 * 定义回文数的概念如下：
 * 如果一个非负数左右完全对应，则该数是回文数，例如：121,22等。
 * 如果一个负数的绝对值左右完全对应，也是回文数，例如：-121,-22等。
 * 给定一个32位整数num，判断num是否是回文数。
 * [要求]
 * O(log10n)
 * <p>
 * 输入描述：
 * 输入一个整数N.
 * 输出描述：
 * 若N是回文整数输出"Yes"，否则输出"No"
 * <p>
 * 示例1
 * 输入：121
 * 输出：Yes
 * 示例2
 * 输入：-121
 * 输出：Yes
 * 示例3
 * 输入：998244353
 * 输出：No
 * <p>
 * 备注：
 * -10^9 <= N <= 10^9
 */
public class CD_073 {

    public static void main(String[] args) throws IOException {
        CD_073 main = new CD_073();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        System.out.println(solve(n));
    }

    private static String solve(int num) {
        int abs = Math.abs(num);
        ArrayList<Integer> list = new ArrayList<>();
        while (abs > 0) {
            list.add(abs % 10);
            abs = abs / 10;
        }
        int start = 0;
        int end = list.size() - 1;
        while (start <= end) {
            int startVal = list.get(start);
            int endVal = list.get(end);
            if (startVal != endVal) {
                return "No";
            }
            start++;
            end--;
        }
        return "Yes";
    }
}
