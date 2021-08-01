package com.leolian.nowcoder.question.book.sword.finger.offer;

import java.util.Arrays;

/**
 * JZ 51 : 构建乘积数组
 * <p>
 * 题目描述
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 * （注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 * 对于A长度为1的情况，B无意义，故而无法构建，因此该情况不会存在。
 * <p>
 * 示例1
 * 输入：[1,2,3,4,5]
 * 返回值：[120,60,40,30,24]
 */
public class JZ_051 {

    public static void main(String[] args) {
        JZ_051 jz051 = new JZ_051();

        int[] A = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(jz051.multiply(A)));
    }

    public int[] multiply(int[] A) {
        if (null == A || A.length < 2) {
            return null;
        }
        int len = A.length;
        int[] resArr = new int[len];
        for (int i = 0; i < len; i++) {
            int multi = 1;
            for (int j = 0; j < len; j++) {
                if (j != i) {
                    multi = multi * A[j];
                }
            }
            resArr[i] = multi;
        }
        return resArr;
    }

}
