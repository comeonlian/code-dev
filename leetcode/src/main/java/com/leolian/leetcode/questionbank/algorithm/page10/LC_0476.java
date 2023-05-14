package com.leolian.leetcode.questionbank.algorithm.page10;

/**
 * LC 475 : 数字的补数
 * 给你一个 正 整数 num ，输出它的补数。补数是对该数的二进制表示取反。
 * 提示：
 * 给定的整数 num 保证在 32 位带符号整数的范围内。
 * num >= 1
 * 你可以假定二进制数不包含前导零位。
 * 本题与 1009 https://leetcode-cn.com/problems/complement-of-base-10-integer/ 相同
 * <p>
 * 示例1
 * 输入：num = 5
 * 输出：2
 * 解释：5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
 * <p>
 * 示例2
 * 输入：num = 1
 * 输出：0
 * 解释：1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。
 */
public class LC_0476 {

    public static void main(String[] args) {
        LC_0476 lc0476 = new LC_0476();

        int num = 13;
         System.out.println(lc0476.findComplement(num));
    }
    
    public int findComplement(int num) {
        int x = num, y = 0;
        while (num > 0) {
            num >>= 1;
            y = (y << 1) + 1;
        }
        return x ^ y;
    }
    /*
    public int findComplement(int num) {
        String s = Integer.toBinaryString(num);
        int sum = 0;
        for (int i = s.length() - 1; i >=0 ; i--) {
            int val = (s.charAt(i) - 48) == 0 ? 1 : 0;
            sum += val * Math.pow(2, s.length() - i - 1);
        }
        return sum;
    }
    */
}
