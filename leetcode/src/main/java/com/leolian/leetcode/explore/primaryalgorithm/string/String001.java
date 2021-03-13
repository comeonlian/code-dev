package com.leolian.leetcode.explore.primaryalgorithm.string;

/**
 * LC 反转字符串
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * <p>
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * <p>
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * <p>
 * 示例 1：
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * <p>
 * 示例 2：
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 */
public class String001 {

    public static void main(String[] args) {
        String001 string001 = new String001();

        char[] array = new char[]{'h', 'e', 'l', 'l', 'o'};

        string001.print(array);
        string001.reverseString(array);
        string001.print(array);
    }

    /**
     * @param s
     */
    public void reverseString(char[] s) {
        int start = 0, end = s.length - 1;
        while (start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }

    /*
    执行结果：通过
    执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
    内存消耗：45.2 MB, 在所有 Java 提交中击败了36.13%的用户
    */

    public void print(char[] array) {
        for (char ch : array) {
            System.out.print(ch + " ");
        }
        System.out.println();
    }

}
