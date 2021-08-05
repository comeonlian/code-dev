package com.leolian.nowcoder.question.book.sword.finger.offer;

/**
 * JZ 31 : 整数中1出现的次数（从1到n整数中1出现的次数）
 * <p>
 * 题目描述
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数
 * 例如，1 ~ 13中包含1的数字有1、10、11、12、13因此共出现6次
 * <p>
 * 示例1
 * 输入：13
 * 返回值：6
 * 说明：
 */
public class JZ_031 {

    public static void main(String[] args) {
        JZ_031 jz031 = new JZ_031();

        int n = 13;
        System.out.println(jz031.NumberOf1Between1AndN_Solution(n));
    }

    public int NumberOf1Between1AndN_Solution(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= 9) {
            return 1;
        }
        int start = 1;
        int end = n;
        int count = 0;
        while (start < end) {
            count += cal(start);
            count += cal(end);
            start++;
            end--;
        }
        if (start == end) {
            count += cal(start);
        }
        return count;
    }

    public int cal(int k) {
        int count = 0;
        do {
            if ((k % 10) == 1) {
                count++;
            }
            k /= 10;
        } while (k > 0);
        return count;
    }

}
