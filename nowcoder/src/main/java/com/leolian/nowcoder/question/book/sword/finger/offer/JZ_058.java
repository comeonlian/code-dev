package com.leolian.nowcoder.question.book.sword.finger.offer;

/**
 * JZ 58 : 对称的二叉树
 * <p>
 * 题目描述
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * <p>
 * 示例1
 * 输入：{8,6,6,5,7,7,5}
 * 返回值：true
 * <p>
 * 示例2
 * 输入：{8,6,9,5,7,7,5}
 * 返回值：false
 */
public class JZ_058 {

    public static void main(String[] args) {
        JZ_058 jz058 = new JZ_058();

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

        System.out.println(jz058.isSymmetrical(root));
    }

    public boolean isSymmetrical(TreeNode pRoot) {
        if (null == pRoot) {
            return true;
        }
        if (pRoot.left == null && pRoot.right == null) {
            return true;
        }
        return checkSymmetrical(pRoot.left, pRoot.right);
    }

    public boolean checkSymmetrical(TreeNode left, TreeNode right) {
        if (null == left && null == right) {
            return true;
        }
        if (null == left || null == right) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return checkSymmetrical(left.left, right.right) && checkSymmetrical(left.right, right.left);
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
