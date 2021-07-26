package com.leolian.nowcoder.question.bank;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * NC 14 : 按之字形顺序打印二叉树
 * <p>
 * 题目描述
 * 给定一个二叉树，返回该二叉树的之字形层序遍历，（第一层从左向右，下一层从右向左，一直这样交替）
 * 例如：
 * 给定的二叉树是{1,2,3,#,#,4,5}
 * https://uploadfiles.nowcoder.com/images/20210717/557336_1626492068888/41FDD435F0BA63A57E274747DE377E05
 * 该二叉树之字形层序遍历的结果是
 * [
 * [1],
 * [3,2],
 * [4,5]
 * ]
 * <p>
 * 示例1
 * 输入：{1,2,3,#,#,4,5}
 * 返回值：[[1],[3,2],[4,5]]
 * 示例2
 * 输入：{8,6,10,5,7,9,11}
 * 返回值：[[8],[10,6],[5,7,9,11]]
 * 示例3
 * 输入：{1,2,3,4,5}
 * 返回值：[[1],[3,2],[4,5]]
 */
public class NC_0014 {

    public static void main(String[] args) {
        NC_0014 nc0014 = new NC_0014();

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

        ArrayList<ArrayList<Integer>> res = nc0014.Print(root);
        for (ArrayList<Integer> list : res) {
            System.out.println(list);
        }
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (null == pRoot) {
            return new ArrayList<>();
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        boolean reverse = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (reverse) {
                    list.add(0, node.val);
                } else {
                    list.add(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (list.size() > 0) {
                result.add(list);
            }
            reverse = !reverse;
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
