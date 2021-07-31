package com.leolian.nowcoder.question.book.sword.finger.offer;

/**
 * JZ 38 : 二叉树的深度
 * <p>
 * 题目描述
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * <p>
 * 示例1
 * 输入：{1,2,3,4,5,#,6,#,#,7}
 * 返回值：4
 */
public class JZ_038 {

    public static void main(String[] args) {
        JZ_038 jz038 = new JZ_038();

        TreeNode root = new TreeNode(8);
        TreeNode node1 = new TreeNode(6);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(7);

        TreeNode node11 = new TreeNode(9);
        TreeNode node22 = new TreeNode(10);

        root.left = node1;
        root.right = node11;

        node1.left = node2;
        node1.right = node3;

        node3.right = node22;

        System.out.println(jz038.TreeDepth(root));
    }

    public int TreeDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int leftDepth = TreeDepth(root.left);
        int rightDepth = TreeDepth(root.right);
        int resDepth = leftDepth + 1;
        if (rightDepth > leftDepth) {
            resDepth = rightDepth + 1;
        }
        return resDepth;
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
