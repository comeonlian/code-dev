package com.leolian.nowcoder.question.book.sword.finger.offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * JZ 60 : 把二叉树打印成多行
 * <p>
 * 题目描述
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * 例如：
 * 给定的二叉树是{1,2,3,#,#,4,5}
 * https://uploadfiles.nowcoder.com/images/20210717/557336_1626492068888/41FDD435F0BA63A57E274747DE377E05
 * 该二叉树多行打印层序遍历的结果是
 * [
 * [1],
 * [2,3],
 * [4,5]
 * ]
 * <p>
 * 示例1
 * 输入：{1,2,3,#,#,4,5}
 * 返回值：[[1],[2,3],[4,5]]
 * <p>
 * 示例2
 * 输入：{8,6,10,5,7,9,11}
 * 返回值：[[8],[6,10],[5,7,9,11]]
 * <p>
 * 输入：{1,2,3,4,5}
 * 返回值：[[1],[2,3],[4,5]]
 */
public class JZ_060 {

    public static void main(String[] args) {
        JZ_060 jz060 = new JZ_060();

        TreeNode root = new TreeNode(8);
        TreeNode left = new TreeNode(6);
        TreeNode right = new TreeNode(6);

        root.left = left;
        root.right = right;

        TreeNode leftLeft = new TreeNode(5);
        TreeNode leftRight = new TreeNode(7);
        TreeNode leftLeftLeft = new TreeNode(3);
        TreeNode leftLeftRight = new TreeNode(4);
        left.left = leftLeft;
        left.right = leftRight;
        leftLeft.left = leftLeftLeft;
        leftLeft.right = leftLeftRight;

        TreeNode rightLeft = new TreeNode(7);
        TreeNode rightRight = new TreeNode(5);
        TreeNode rightRightLeft = new TreeNode(4);
        TreeNode rightRightRight = new TreeNode(1);
        right.left = rightLeft;
        right.right = rightRight;
        rightRight.left = rightRightLeft;
        rightRight.right = rightRightRight;

        System.out.println(jz060.Print(root));
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (null == pRoot) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
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
            res.add(list);
        }
        return res;
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
