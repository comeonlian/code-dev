package com.leolian.data.structure.recursion;

import java.util.Arrays;

/**
 * 八皇后问题，是一个古老而著名的问题，是回溯算法的典型案例。该问题是国际西洋棋棋手马克斯·贝瑟尔于
 * 1848 年提出：在 8×8 格的国际象棋上摆放八个皇后，使其不能互相攻击，即：任意两个皇后都不能处于同一行、
 * 同一列或同一斜线上，问有多少种摆法(92)
 */
public class EightQueen {
    // 皇后个数
    private int max = 8;

    // 定义数组 array, 保存皇后放置位置的结果,比如 arr = {0 , 4, 7, 5, 2, 6, 1, 3}
    //对应 arr 下标 表示第几行，即第几个皇后，arr[i] = val , val 表示第 i+1 个皇后，放在第 i+1 行的第 val+1 列
    private int[] array = new int[max];

    // 多少个解法
    private int count = 0;


    public static void main(String[] args) {
        EightQueen eightQueen = new EightQueen();

//        int n = 8; //
//
//        int row = 1;
//        int col = 0b10000000;
//        int left = 0;
//        int right = 0;
//
//        eightQueen.solveQueen(n, row, col, left, right);
//        System.out.println(eightQueen.count);

        eightQueen.check(0);
        System.out.printf("一共有%d 解法", eightQueen.count);
    }

    /**
     * 放置第n个皇后，表示第n行
     *
     * @param n
     */
    public void check(int n) {
        if (n >= max) {
            count++;
            System.out.println(Arrays.toString(array));
            return;
        }
        // 皇后放置的列有哪些
        for (int i = 0; i < max; i++) {
            array[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
        }
    }


    /**
     * 判断第n个皇后与之前的n-1个皇后是否在同一列或者同一斜线上
     *
     * @param n
     * @return
     */
    public boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }


    /**
     * @param row   第N行
     * @param col
     * @param left
     * @param right
     */
    public void solveQueen(int n, int row, int col, int left, int right) {
        if (row >= n) {
            count++;
            return;
        }
        int bits = (~(col | left | right)) & ((1 << n) - 1);
//        System.out.println("(~(col | left | right)) & ((1 << n) - 1) =  " + Integer.toBinaryString(bits));
        while (bits > 0) {
            int p = bits & -bits;
//            System.out.println("bits & -bits = " + Integer.toBinaryString(p));
            // 紧接着在下一行继续放皇后
            solveQueen(n, row + 1, col | p, (left | p) << 1, (right | p) >> 1);
//            System.out.println("col | p = " + Integer.toBinaryString(col | p));
//            System.out.println("(left | p) << 1 = " + Integer.toBinaryString((left | p) << 1));
//            System.out.println("(right | p) >> 1 = " + Integer.toBinaryString((right | p) >> 1));

            // 当前行最右边格子已经选完了，将其置成 0，代表这个格子已遍历过
            bits = bits & (bits - 1);
//            System.out.println("bits & (bits - 1) = " + Integer.toBinaryString(bits));
//            break;
        }

    }


}
