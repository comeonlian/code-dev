package com.leolian.nowcoder.question.book.sword.finger.offer;

/**
 * JZ 23 : 二叉搜索树的后序遍历序列
 * <p>
 * 题目描述
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true,否则返回false。
 * 假设输入的数组的任意两个数字都互不相同。（ps：我们约定空树不是二叉搜索树）
 * <p>
 * 示例1
 * 输入：[4,8,6,12,16,14,10]
 * 返回值：true
 */
public class JZ_023 {

    public static void main(String[] args) {
        JZ_023 jz023 = new JZ_023();
        int[] sequence = new int[]{5,4,3,2,1};
        System.out.println(jz023.VerifySequenceOfBST(sequence));
    }

    public boolean VerifySequenceOfBST(int[] sequence) {
        if (null == sequence || sequence.length == 0) {
            return false;
        }
        if (sequence.length == 1) {
            return true;
        }
        return verify(sequence, 0, sequence.length - 1);
    }

    public boolean verify(int[] sequence, int start, int end) {
        if (start >= end) {
            return true;
        }
        int index = end;
        while (index > start && sequence[index - 1] > sequence[end]) {
            index--;
        }
        for (int i = start; i < index - 1; i++) {
            if (sequence[i] > sequence[end]) {
                return false;
            }
        }
        boolean left = verify(sequence, start, index - 1);
        boolean right = verify(sequence, index, end - 1);
        return left && right;
    }

}
