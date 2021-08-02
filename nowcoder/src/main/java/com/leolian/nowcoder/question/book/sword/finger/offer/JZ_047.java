package com.leolian.nowcoder.question.book.sword.finger.offer;

/**
 * JZ 47 : 求1+2+3+...+n
 * <p>
 * 题目描述
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * <p>
 * 示例1
 * 输入：5
 * 返回值：15
 */
public class JZ_047 {

    public static void main(String[] args) {
        JZ_047 jz047 = new JZ_047();

        int n = 5;
        System.out.println(jz047.Sum_Solution(n));
    }

    public int Sum_Solution(int n) {
        if (n == 1) {
            return 1;
        }
        return n + Sum_Solution(n - 1);
    }

}
