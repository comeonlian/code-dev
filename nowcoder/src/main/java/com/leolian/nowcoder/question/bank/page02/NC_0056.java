package com.leolian.nowcoder.question.bank.page02;

/**
 * NC 56 : 回文数字
 * <p>
 * 题目描述
 * 在不使用额外的内存空间的条件下判断一个整数是否是回文数字
 * 提示：
 * 负整数可以是回文吗？（比如-1）
 * 如果你在考虑将数字转化为字符串的话，请注意一下不能使用额外空间的限制
 * 你可以将整数翻转。但是，如果你做过题目“反转数字”，你会知道将整数翻转可能会出现溢出的情况，你怎么处理这个问题？
 * <p>
 * 示例1
 * 输入：121
 * 返回值：true
 */
public class NC_0056 {

    public static void main(String[] args) {
        NC_0056 nc_0056 = new NC_0056();

        int x = 121;
        System.out.println(nc_0056.isPalindrome(x));
    }

    /**
     * @param x int整型
     * @return bool布尔型
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        if (x % 10 == 0) {
            return false;
        }
        int digits = 0, y = x;
        while (y > 0) {
            digits = digits + 1;
            y = y / 10;
        }
        int startPow, endPow;
        for (int i = 0; i < (digits / 2); i++) {
            startPow = (int) Math.pow(10, i);
            endPow = (int) Math.pow(10, (digits - 1 - i));
            if ((x / startPow) % 10 != (x / endPow) % 10) {
                return false;
            }
        }
        return true;
    }

}
