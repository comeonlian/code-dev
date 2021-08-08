package com.leolian.nowcoder.question.bank;

import java.util.ArrayList;

/**
 * NC 45 : 实现二叉树先序，中序和后序遍历
 * <p>
 * 题目描述
 * 分别按照二叉树先序，中序和后序打印所有的节点。
 * 备注：
 * n≤10^6
 * <p>
 * 示例1
 * 输入：{1,2,3}
 * 返回值：[[1,2,3],[2,1,3],[2,3,1]]
 */
public class NC_0045 {

    public static void main(String[] args) {
        NC_0045 nc0045 = new NC_0045();

    }

    public int[][] threeOrders(TreeNode root) {
        if (null == root) {
            return new int[3][];
        }
        int[][] arr = new int[3][];
        ArrayList<Integer> list = new ArrayList<>();
        traverse(root, 0, list);
        int[] tmp = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            tmp[i] = list.get(i);
        }
        arr[0] = tmp;
        list = new ArrayList<>();
        traverse(root, 1, list);
        tmp = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            tmp[i] = list.get(i);
        }
        arr[1] = tmp;
        list = new ArrayList<>();
        traverse(root, 2, list);
        tmp = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            tmp[i] = list.get(i);
        }
        arr[2] = tmp;
        return arr;
    }

    public void traverse(TreeNode root, int order, ArrayList<Integer> list) {
        if (order == 0) {
            list.add(root.val);
        }
        if (root.left != null) {
            traverse(root.left, order, list);
        }
        if (order == 1) {
            list.add(root.val);
        }
        if (root.right != null) {
            traverse(root.right, order, list);
        }
        if (order == 2) {
            list.add(root.val);
        }
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

}
