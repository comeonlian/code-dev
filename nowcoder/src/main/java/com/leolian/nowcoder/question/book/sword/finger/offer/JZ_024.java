package com.leolian.nowcoder.question.book.sword.finger.offer;

import java.util.ArrayList;

/**
 * JZ 24 : 二叉树中和为某一值的路径
 * <p>
 * 题目描述
 * 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * <p>
 * 示例1
 * 输入：{10,5,12,4,7},22
 * 返回值：[[10,5,7],[10,12]]
 * <p>
 * 示例2
 * 输入：{10,5,12,4,7},15
 * 返回值：[]
 */
public class JZ_024 {

    public static void main(String[] args) {
        JZ_024 jz024 = new JZ_024();

        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(12);

        root.left = node1;
        root.right = node2;

        TreeNode node11 = new TreeNode(4);
        TreeNode node12 = new TreeNode(7);

        node1.left = node11;
        node1.right = node12;

        int target = 22;
        System.out.println(jz024.FindPath(root, target));
    }

    private ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (null == root) {
            return res;
        }
        search(root, target);
        return res;
    }

    public void search(TreeNode root, int target) {
        if (null == root) {
            return;
        }
        list.add(root.val);
        if (root.left == null && root.right == null && root.val == target) {
            res.add(new ArrayList<>(list));
        }
        if (root.left != null) {
            search(root.left, target - root.val);
        }
        if (root.right != null) {
            search(root.right, target - root.val);
        }
        list.remove(list.size() - 1);
    }

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
