package com.leolian.data.structure.recursion;

/**
 * 八皇后问题，是一个古老而著名的问题，是回溯算法的典型案例。该问题是国际西洋棋棋手马克斯·贝瑟尔于
 * 1848 年提出：在 8×8 格的国际象棋上摆放八个皇后，使其不能互相攻击，即：任意两个皇后都不能处于同一行、
 * 同一列或同一斜线上，问有多少种摆法(92)
 */
public class EightQueen {

    private int count = 0;

    public static void main(String[] args) {
        EightQueen eightQueen = new EightQueen();

        int n = 8; // 

        int row = 1;
        int col = 0b10000000;
        int left = 0;
        int right = 0;

        eightQueen.solveQueen(n, row, col, left, right);
        System.out.println(eightQueen.count);
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
