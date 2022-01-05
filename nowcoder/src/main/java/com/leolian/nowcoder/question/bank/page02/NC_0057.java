package com.leolian.nowcoder.question.bank.page02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * NC 57 : 反转数字
 * <p>
 * 题目描述
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 你有注意到翻转后的整数可能溢出吗？因为给出的是32位整数，则其数值范围为[−2^31, 2^31 − 1]。
 * 翻转可能会导致溢出，如果反转后的结果会溢出就返回 0。
 * <p>
 * 示例1 :
 * 输入：12
 * 返回值：21
 * <p>
 * 示例2 :
 * 输入：-123
 * 返回值：-321
 * <p>
 * 示例3 :
 * 输入：10
 * 返回值：1
 * <p>
 * 示例4 :
 * 输入：1147483649
 * 返回值：0
 */
public class NC_0057 {

    public static void main(String[] args) {
        NC_0057 nc0057 = new NC_0057();

        int x = 2123000;
        System.out.println(nc0057.reverse(x));
    }

    /**
     * @param x int整型
     * @return int整型
     */
    public int reverse(int x) {
        if (x < 10 && x > 0) {
            return x;
        }
        String str = String.valueOf(Math.abs(x));
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            list.add(ch);
        }
        Collections.reverse(list);
        String reverse = "";
        for (Character ch : list) {
            reverse = reverse + ch;
        }
        long val = Long.parseLong(reverse);
        if (val > Integer.MAX_VALUE) {
            return 0;
        } else {
            int intVal = (int) val;
            if (x < 0) {
                return -1 * intVal;
            }
            return intVal;
        }
    }

}
