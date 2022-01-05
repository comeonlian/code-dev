package com.leolian.nowcoder.question.bank.page02;

/**
 * NC 98 : 判断t1树中是否有与t2树拓扑结构完全相同的子树
 * <p>
 * 题目描述
 * 给定彼此独立的两棵二叉树，判断 t1 树是否有与 t2 树拓扑结构完全相同的子树。
 * 设 t1 树的边集为 E1，t2 树的边集为 E2，若 E2 等于 E1 ，则表示 t1 树和t2 树的拓扑结构完全相同。
 * 备注：
 * 1≤n≤500000
 * <p>
 * 示例1:
 * 输入：{1,2,3,4,5,6,7,#,8,9},{2,4,5,#,8,9}
 * 返回值：true
 */
public class NC_0098 {

    public static void main(String[] args) {
        NC_0098 nc0098 = new NC_0098();

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

        TreeNode root1 = new TreeNode(3);
        TreeNode node222 = new TreeNode(2);
        TreeNode node333 = new TreeNode(4);

        root1.left = node222;
        root1.right = node333;

        System.out.println(nc0098.isContains(root, root1));
    }

    /**
     * @param root1 TreeNode类
     * @param root2 TreeNode类
     * @return bool布尔型
     */
    public boolean isContains(TreeNode root1, TreeNode root2) {
        if (null == root1 || root1 == root2) {
            return false;
        }
        return include(root1, root2) || isContains(root1.left, root2) || isContains(root1.right, root2);
    }

    public boolean include(TreeNode root1, TreeNode root2) {
        if (null == root1 && null == root2) {
            return true;
        }
        if (null == root1 || null == root2 || root1.val != root2.val) {
            return false;
        }
        return include(root1.left, root2.left) && include(root1.right, root2.right);
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
