package com.leolian.leetcode.questionbank.algorithm.page02;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 94 : 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * 提示：
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 * <p>
 * 示例1
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * <p>
 * 示例2
 * 输入：root = []
 * 输出：[]
 * <p>
 * 示例3
 * 输入：root = [1]
 * 输出：[1]
 * <p>
 * 示例4
 * 输入：root = [1,2]
 * 输出：[2,1]
 * <p>
 * 示例5
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 */
public class LC_0094 {

    public static void main(String[] args) {
        LC_0094 lc0094 = new LC_0094();

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (null == root) {
            return list;
        }
        inorder(root, list);
        return list;
    }

    public void inorder(TreeNode root, ArrayList<Integer> list) {
        if (root.left != null) {
            inorder(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            inorder(root.right, list);
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
