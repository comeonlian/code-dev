package com.leolian.nowcoder.question.book.sword.finger.offer;

/**
 * JZ 49 : 把字符串转换成整数
 * <p>
 * 题目描述
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 输入描述：
 * 输入一个字符串,包括数字字母符号,可以为空
 * 返回值描述：
 * 如果是合法的数值表达则返回该数字，否则返回0
 * <p>
 * 示例1
 * 输入："+2147483647"
 * 返回值：2147483647
 * <p>
 * 示例2
 * 输入："1a33"
 * 返回值：0
 */
public class JZ_049 {

    public static void main(String[] args) {
        JZ_049 jz049 = new JZ_049();

        String str = "-2147483647";
        System.out.println(jz049.StrToInt(str));
    }

    public int StrToInt(String str) {
        if (null == str || str.length() == 0) {
            return 0;
        }
        int negative = 1;
        long val = 0L;
        int pow = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            if (i == 0 && (ch == '+' || ch == '-')) {
                if (ch == '-') {
                    negative = -1;
                }
                continue;
            }
            if (ch < 48 || ch > 57) {
                return 0;
            }
            int chVal = ch - 48;
            val += chVal * Math.pow(10, pow);
            pow++;
        }
        if (val > Integer.MAX_VALUE) {
            return 0;
        }
        int res = (int) (negative * val);
        return res;
    }

}
