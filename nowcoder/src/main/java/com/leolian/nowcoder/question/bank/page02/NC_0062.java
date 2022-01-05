package com.leolian.nowcoder.question.bank.page02;

/**
 * NC 61 : 平衡二叉树
 * <p>
 * 题目描述
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
 * 平衡二叉树（Balanced Binary Tree），具有以下性质：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
 * 注：我们约定空树是平衡二叉树。
 * <p>
 * 示例1:
 * 输入：{1,2,3,4,5,6,7}
 * 返回值：true
 */
public class NC_0062 {

    public static void main(String[] args) {
        NC_0062 nc0062 = new NC_0062();
        
    }

    /**
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        return depth(root) != -1;
    }

    public int depth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int leftDepth = depth(root.left);
        if (leftDepth == -1) { // 如果左子树的不平衡，直接返回
            return -1;
        }
        int rightDepth = depth(root.right);
        if (rightDepth == -1) { // 如果右子树的不平衡，直接返回
            return -1;
        }
        if (Math.abs(leftDepth - rightDepth) > 1) { // 子树不平衡
            return -1;
        }
        return 1 + Math.max(leftDepth, rightDepth); // 返回子树的深度
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
