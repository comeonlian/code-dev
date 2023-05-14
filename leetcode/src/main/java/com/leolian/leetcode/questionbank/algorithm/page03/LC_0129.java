package com.leolian.leetcode.questionbank.algorithm.page03;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * LC 129 : 求根节点到叶节点数字之和
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * 叶节点 是指没有子节点的节点。
 * 提示：
 * 树中节点的数目在范围 [1, 1000] 内
 * 0 <= Node.val <= 9
 * 树的深度不超过 10
 * <p>
 * 示例1
 * https://assets.leetcode.com/uploads/2021/02/19/num1tree.jpg
 * 输入：root = [1,2,3]
 * 输出：25
 * 解释：
 * 从根到叶子节点路径 1->2 代表数字 12
 * 从根到叶子节点路径 1->3 代表数字 13
 * 因此，数字总和 = 12 + 13 = 25
 * <p>
 * 示例2
 * https://assets.leetcode.com/uploads/2021/02/19/num2tree.jpg
 * 输入：root = [4,9,0,5,1]
 * 输出：1026
 * 解释：
 * 从根到叶子节点路径 4->9->5 代表数字 495
 * 从根到叶子节点路径 4->9->1 代表数字 491
 * 从根到叶子节点路径 4->0 代表数字 40
 * 因此，数字总和 = 495 + 491 + 40 = 1026
 */
public class LC_0129 {

    public static void main(String[] args) {
        LC_0129 lc0129 = new LC_0129();

        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(0);

        root.left = left;
        root.right = right;

        System.out.println(lc0129.sumNumbers(root));
    }

    public int sumNumbers(TreeNode root) {
        if (null == root) {
            return 0;
        }
        if (null == root.left && null == root.right) {
            return root.val;
        }
        StringBuilder builder = new StringBuilder();
        AtomicInteger sum = new AtomicInteger(0);
        sum(root, builder, sum);
        return sum.get();
    }

    private void sum(TreeNode node, StringBuilder builder, AtomicInteger res) {
        if (null == node) {
            return;
        }
        builder.append(node.val);
        if (node.left == null && node.right == null) {
            int num = Integer.parseInt(builder.toString());
            res.addAndGet(num);
        } 
        if (node.left != null) {
            sum(node.left, builder, res);
        }
        if (node.right != null) {
            sum(node.right, builder, res);
        }
        builder.deleteCharAt(builder.length() - 1);
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
    
    /*
    执行用时：1 ms, 在所有 Java 提交中击败了22.40%的用户
    内存消耗：39.3 MB, 在所有 Java 提交中击败了5.03%的用户
    通过测试用例：108 / 108
    */
}
