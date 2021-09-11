package com.leolian.leetcode.questionbank.algorithm.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 144 : 二叉树的前序遍历
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * 提示：
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 * <p>
 * 示例1
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
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
 * 输出：[1,2]
 */
public class LC_0144 {

    public static void main(String[] args) {
        LC_0144 lc0144 = new LC_0144();

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (null == root) {
            return list;
        }
        preorder(root, list);
        return list;
    }

    public void preorder(TreeNode root, ArrayList<Integer> list) {
        list.add(root.val);
        if (null != root.left) {
            preorder(root.left, list);
        }
        if (null != root.right) {
            preorder(root.right, list);
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
