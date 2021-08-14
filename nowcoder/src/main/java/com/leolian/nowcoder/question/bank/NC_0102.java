package com.leolian.nowcoder.question.bank;

import java.util.Stack;

/**
 * NC 102 : 在二叉树中找到两个节点的最近公共祖先
 * <p>
 * 题目描述
 * 给定一棵二叉树(保证非空)以及这棵树上的两个节点对应的val值 o1 和 o2，请找到 o1 和 o2 的最近公共祖先节点。
 * 注：本题保证二叉树中每个节点的val值均不相同。
 * <p>
 * 示例1
 * 输入：[3,5,1,6,2,0,8,#,#,7,4],5,1
 * 返回值：3
 */
public class NC_0102 {

    public static void main(String[] args) {
        NC_0102 nc0102 = new NC_0102();

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

        int o1 = 2;
        int o2 = 4;
        System.out.println(nc0102.lowestCommonAncestor(root, o1, o2));
    }

    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        if (null == root) {
            return 0;
        }
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        searchPath(root, o1, stack1);
        searchPath(root, o2, stack2);
        int same = 0;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int val1 = stack1.pop();
            int val2 = stack2.pop();
            if (val1 == val2) {
                same = val1;
            } else {
                break;
            }
        }
        return same;
    }

    public boolean searchPath(TreeNode root, int target, Stack<Integer> stack) {
        if (null == root) {
            return false;
        }
        if (root.val == target ||
                searchPath(root.left, target, stack) ||
                searchPath(root.right, target, stack)) {
            stack.push(root.val);
            return true;
        }
        return false;
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
