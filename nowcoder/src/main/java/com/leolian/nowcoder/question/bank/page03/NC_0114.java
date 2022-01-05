package com.leolian.nowcoder.question.bank.page03;

/**
 * NC 114 : 旋转字符串
 * <p>
 * 题目描述
 * 字符串旋转:
 * 给定两字符串A和B，如果能将A从中间某个位置分割为左右两部分字符串（都不为空串），
 * 并将左边的字符串移动到右边字符串后面组成新的字符串可以变为字符串B时返回true。
 * 例如：如果A=‘youzan’，B=‘zanyou’，A按‘you’‘zan’切割换位后得到‘zanyou’和B相同返回true。
 * <p>
 * 示例1
 * 输入："youzan","zanyou"
 * 返回值：true
 * 示例2
 * 输入："youzan","zyouan"
 * 返回值：false
 */
public class NC_0114 {

    public static void main(String[] args) {
        NC_0114 nc0114 = new NC_0114();

        String a = "youzan";
        String b = "zyouan";
        System.out.println(nc0114.solve(a, b));
    }

    /**
     * 旋转字符串
     *
     * @param A string字符串
     * @param B string字符串
     * @return bool布尔型
     */
    public boolean solve(String A, String B) {
        if (null == A || null == B) {
            return false;
        }
        if (A.length() == 0 && B.length() == 0) {
            return true;
        }
        if (A.length() == 0 || B.length() == 0) {
            return false;
        }
        if (A.length() != B.length()) {
            return false;
        }
        if (A.equals(B)) {
            return true;
        }
        A = A + A;
        if (A.contains(B)) {
            return true;
        }
        return false;
    }

}
