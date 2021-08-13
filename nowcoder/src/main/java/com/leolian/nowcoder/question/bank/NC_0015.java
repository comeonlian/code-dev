package com.leolian.nowcoder.question.bank;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * NC 15 : 求二叉树的层序遍历
 * <p>
 * 题目描述
 * 给定一个二叉树，返回该二叉树层序遍历的结果，（从左到右，一层一层地遍历）
 * 例如：
 * 给定的二叉树是{3,9,20,#,#,15,7}
 * 该二叉树层序遍历的结果是
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * 示例1
 * 输入：{1,2}
 * 返回值：[[1],[2]]
 * 示例2
 * 输入：{1,2,3,4,#,#,5}
 * 返回值：[[1],[2,3],[4,5]]
 */
public class NC_0015 {

    public static void main(String[] args) {
        NC_0015 nc0015 = new NC_0015();

        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(4);

        TreeNode node11 = new TreeNode(7);
        TreeNode node22 = new TreeNode(6);
        TreeNode node33 = new TreeNode(8);

        root.left = node1;
        root.right = node11;

        node1.left = node2;
        node1.right = node3;

        node11.left = node22;
        node11.right = node33;

        ArrayList<ArrayList<Integer>> res = nc0015.levelOrder(root);
        for (ArrayList<Integer> list : res) {
            System.out.println(list);
        }
    }

    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        if (null == root) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.removeFirst();
                list.add(node.val);
                if (null != node.left) {
                    queue.add(node.left);
                }
                if (null != node.right) {
                    queue.add(node.right);
                }
            }
            result.add(list);
        }
        return result;
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
