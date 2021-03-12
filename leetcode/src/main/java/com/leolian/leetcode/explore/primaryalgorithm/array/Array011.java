package com.leolian.leetcode.explore.primaryalgorithm.array;

/**
 * LC 旋转图像
 * <p>
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * <p>
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * <p>
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * <p>
 * 示例 2：
 * 输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 * <p>
 * 示例 3：
 * 输入：matrix = [[1]]
 * 输出：[[1]]
 * <p>
 * 示例 4：
 * 输入：matrix = [[1,2],[3,4]]
 * 输出：[[3,1],[4,2]]
 * <p>
 * 提示：
 * matrix.length == n
 * matrix[i].length == n
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 */
public class Array011 {


    public static void main(String[] args) {
        Array011 array011 = new Array011();

        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        array011.rotate(matrix);

        array011.println(matrix);
    }


    /**
     * https://leetcode.jp/leetcode-48-rotate-image-%E8%A7%A3%E9%A2%98%E6%80%9D%E8%B7%AF%E5%88%86%E6%9E%90/
     * <p>
     * 最外圈所有相同颜色的格子都存在4个，他们处于对称的位置上，按照顺时针移动每一个格子到下一个相同颜色位置后，
     * 图像就会完成90度旋转。在矩阵的每一圈中，他都存在4条边，注意，我们不能将第一个格子到最后一个格子区间看做一条边，
     * 这样的话，四条边会在四个顶角出现重合
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int rowLen = matrix.length;
        for (int row = 0; row < rowLen / 2; row++) {
            int colLen = matrix[row].length;
            for (int col = row; col < colLen - row - 1; col++) {
                // 四个点交换: 上、右、下、左
                int tr = row, tc = col;
                int rr = tc, rc = colLen - tr - 1;
                int br, bc;
                int lr, lc;
            }
        }
    }


    /**
     * @param matrix
     */
    public void println(int[][] matrix) {
        for (int[] array : matrix) {
            for (int i : array) {
                System.out.println(i + " ");
            }
            System.out.println();
        }
    }

}
