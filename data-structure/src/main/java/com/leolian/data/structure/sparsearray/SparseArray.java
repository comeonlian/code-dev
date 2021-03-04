package com.leolian.data.structure.sparsearray;

/**
 * @author 80254155
 * @description:
 * @date 2020/7/5 20:56
 */
public class SparseArray {

    /**
     * 二维数组转成稀疏数组
     *
     * @param originArray
     */
    public int[][] outputSparseArray(int[][] originArray) {
        // 遍历数组，得到非0数据的个数
        int sum = 0;
        int rowSum = 0;
        int colSum = 0;
        for (int[] row : originArray) {
            colSum = 0;
            for (int data : row) {
                if (data != 0) {
                    sum++;
                }
                colSum++;
            }
            rowSum++;
        }

        // 将数组存入二维数组
        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = rowSum; // 原始数组的行数
        sparseArray[0][1] = colSum; // 原始数组的列数
        sparseArray[0][2] = sum; // 原始数组有效数据的个数
        // 遍历二维数组，将有效数据存入稀疏数组
        int count = 0;
        for (int i = 0; i < rowSum; i++) {
            for (int j = 0; j < colSum; j++) {
                if (originArray[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = originArray[i][j];
                }
            }
        }
        return sparseArray;
    }

    /**
     * 稀疏数组转成二维数组
     *
     * @param sparseArray
     */
    public int[][] inputSparseArray(int[][] sparseArray) {
        // 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
        // 在读取稀疏数组后几行的数据，并赋给 原始的二维数组
        int rowSum = sparseArray[0][0];
        int colSum = sparseArray[0][1];
        int[][] originArray = new int[rowSum][colSum];

        // 遍历稀疏数组取出数组赋值给原始数组
        for (int i = 1; i < sparseArray.length; i++) {
            int rowIndex = sparseArray[i][0];
            int colIndex = sparseArray[i][1];
            originArray[rowIndex][colIndex] = sparseArray[i][2];
        }
        return originArray;
    }


    public static void main(String[] args) {
        SparseArray sparseArrayObj = new SparseArray();
        // 构造一个二维数组
        int[][] chessArr = new int[11][11];
        // 0: 表示没有棋子， 1 表示 黑子 2 表蓝子
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[3][3] = 2;
        // 输出原始二维数组
        System.out.println("原始二维数组：");
        for (int[] row : chessArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        // 原始数组转成二维数组
        int[][] sparseArray = sparseArrayObj.outputSparseArray(chessArr);
        System.out.println("稀疏数组：");
        for (int i = 0; i < sparseArray.length; i++) {
            System.out.printf("%d\t%d\t%d\n", sparseArray[i][0], sparseArray[i][1], sparseArray[i][2]);
        }

        // 稀疏数组读出原始数组
        int[][] originArray = sparseArrayObj.inputSparseArray(sparseArray);
        System.out.println("稀疏读取出来的原始数组：");
        for (int[] row : originArray) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }

}
