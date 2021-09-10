package com.leolian.nowcoder.question.bank;

import java.util.ArrayList;

/**
 * NC 161 : 二叉树的中序遍历
 * 题目描述
 * 给定一个二叉树的根节点root，返回它的中序遍历。
 * 备注：
 * 树中节点数目在范围 [0, 100] 内
 * 树中的节点的值在[-100,100]以内
 * <p>
 * 示例1
 * 输入：{1,2,#,#,3}
 * 返回值：[2,3,1]
 * <p>
 * 示例2
 * 输入：{}
 * 返回值：[]
 * <p>
 * 示例3
 * 输入：{1,2}
 * 返回值：[2,1]
 * <p>
 * 示例4
 * 输入：{1,#,2}
 * 返回值：[1,2]
 */
public class NC_0161 {

    public static void main(String[] args) {
        NC_0161 nc0161 = new NC_0161();


    }

    public int[] inorderTraversal(TreeNode root) {
        if (null == root) {
            return new int[]{};
        }
        if (null == root.left && null == root.right) {
            return new int[]{root.val};
        }
        ArrayList<Integer> list = new ArrayList<>();
        mid(root, list);
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public void mid(TreeNode root, ArrayList<Integer> list) {
        if (null != root.left) {
            mid(root.left, list);
        }
        list.add(root.val);
        if (null != root.right) {
            mid(root.right, list);
        }
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
