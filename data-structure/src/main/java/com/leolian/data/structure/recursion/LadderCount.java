package com.leolian.data.structure.recursion;

/**
 * n级阶梯，每次走一步或两步，问最多有多少种走法
 */
public class LadderCount {

    public static void main(String[] args) {
        LadderCount ladderCount = new LadderCount();

        int n = 20;
        long count = ladderCount.getLadderCount(n);
        System.out.println(count);
    }

    public long getLadderCount(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return getLadderCount(n - 1) + getLadderCount(n - 2);
    }

}
