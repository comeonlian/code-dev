package com.leolian.leetcode.questionbank.algorithm.page03;

import java.util.LinkedList;

/**
 * LC 101 : 对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * 提示：
 * 树中节点数目在范围 [1, 1000] 内
 * -100 <= Node.val <= 100
 * 进阶：你可以运用递归和迭代两种方法解决这个问题吗？
 * <p>
 * 示例1
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * https://assets.leetcode.com/uploads/2021/02/19/symtree1.jpg
 * <p>
 * 示例2
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 * https://assets.leetcode.com/uploads/2021/02/19/symtree2.jpg
 */
public class LC_0101 {

    public static void main(String[] args) {
        LC_0101 lc0101 = new LC_0101();

        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(2);

        root.left = left;
        root.right = right;

        TreeNode leftLeft = new TreeNode(3);
        TreeNode leftRight = new TreeNode(4);

        left.left = leftLeft;
        left.right = leftRight;

        TreeNode rightLeft = new TreeNode(4);
        TreeNode rightRight = new TreeNode(2);

        right.left = rightLeft;
        right.right = rightRight;

        System.out.println(lc0101.isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return true;
        }
        if (null == root.left && null == root.right) {
            return true;
        }
        if (null == root.left) {
            return false;
        }
        if (null == root.right) {
            return false;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (queue.size() > 0) {
            TreeNode node1 = queue.pop();
            TreeNode node2 = queue.pop();
            if (node1.val != node2.val) {
                return false;
            }
            if (node1.left != null && node2.right != null) {
                queue.add(node1.left);
                queue.add(node2.right);
            } else if(node1.left == null && node2.right == null){
            } else {
                return false;
            }
            if (node1.right != null && node2.left != null) {
                queue.add(node1.right);
                queue.add(node2.left);
            } else if(node1.right == null && node2.left == null){
            } else {
                return false;
            }
        }
        return true;
    }
    
    /*
    执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
    内存消耗：39.7 MB, 在所有 Java 提交中击败了5.06%的用户
    通过测试用例：197 / 197
    */
    
/*
    public boolean isSymmetric(TreeNode root) {
        if (null == root.left && null == root.right) {
            return true;
        }
        if (null == root.left) {
            return false;
        }
        if (null == root.right) {
            return false;
        }
        return symmetric(root.left, root.right);
    }

    private boolean symmetric(TreeNode left, TreeNode right) {
        if (null == left && null == right) {
            return true;
        }
        if (null == left) {
            return false;
        }
        if (null == right) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return symmetric(left.left, right.right) && symmetric(left.right, right.left);
    }
*/
    
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
    
    /*
    执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
    内存消耗：39.8 MB, 在所有 Java 提交中击败了5.06%的用户
    通过测试用例：197 / 197
    */
}
