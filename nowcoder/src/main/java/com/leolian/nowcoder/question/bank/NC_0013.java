package com.leolian.nowcoder.question.bank;

/**
 * NC 13 : 二叉树的最大深度
 * <p>
 * 题目描述
 * 求给定二叉树的最大深度，
 * 最大深度是指树的根结点到最远叶子结点的最长路径上结点的数量。
 * <p>
 * 示例1
 * 输入：{1,2}
 * 返回值：2
 * 示例2
 * 输入：{1,2,3,4,#,#,5}
 * 返回值：3
 */
public class NC_0013 {

    public static void main(String[] args) {
        NC_0013 nc0013 = new NC_0013();

        TreeNode root = new TreeNode(1);
        TreeNode leftNode1 = new TreeNode(2);
        root.left = leftNode1;

        System.out.println(nc0013.maxDepth(root));
    }

    /**
     * @param root TreeNode类
     * @return int整型
     */
    public int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int maxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);
        if (rightMaxDepth > maxDepth) {
            maxDepth = rightMaxDepth;
        }
        return 1 + maxDepth;
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
