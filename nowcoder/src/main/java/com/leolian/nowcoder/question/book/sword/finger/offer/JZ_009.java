package com.leolian.nowcoder.question.book.sword.finger.offer;

/**
 * JZ 9 : 跳台阶扩展问题
 * <p>
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶(n为正整数)总共有多少种跳法。
 * <p>
 * 示例1
 * 输入：3
 * 返回值：4
 */
public class JZ_009 {

    public static void main(String[] args) {
        JZ_009 jz009 = new JZ_009();

        int target = 5;
        System.out.println(jz009.jumpFloorII(target));
    }

    public int jumpFloorII(int target) {
        if (target == 0) {
            return 0;
        }
        int count = 1;
        while ((--target) > 0) {
            count = count << 1;
        }
        return count;
    }

}
