package com.leolian.nowcoder.question.bank.page01;

import java.util.ArrayList;

/**
 * NC 5 : 二叉树根节点到叶子节点的所有路径和
 * <p>
 * 题目描述
 * 给定一个仅包含数字 0−9 的二叉树，每一条从根节点到叶子节点的路径都可以用一个数字表示。
 * 例如根节点到叶子节点的一条路径是 1→2→3,那么这条路径就用 123 来代替。
 * 找出根节点到叶子节点的所有路径表示的数字之和
 * 例如：https://uploadfiles.nowcoder.com/images/20200807/999991351_1596786228797_BC85E8592A231E74E5338EBA1CFB2D20
 * 这颗二叉树一共有两条路径，
 * 根节点到叶子节点的路径 1→2 用数字 12 代替
 * 根节点到叶子节点的路径 1→3 用数字 13 代替
 * 所以答案为 12+13=25
 * <p>
 * 示例1
 * 输入：{1,0}
 * 返回值：10
 * <p>
 * 示例2
 * 输入：{1,#,9}
 * 返回值：19
 */
public class NC_0005 {

    public static void main(String[] args) {
        NC_0005 nc0005 = new NC_0005();

        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(7);
        root.left = left;
        root.right = right;

        TreeNode leftleft = new TreeNode(1);
        TreeNode leftright = new TreeNode(2);
        left.left = leftleft;
        left.right = leftright;

        System.out.println(nc0005.sumNumbers(root));
    }

    private ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
    private ArrayList<Integer> path = new ArrayList<>();

    public int sumNumbers(TreeNode root) {
        if (null == root) {
            return 0;
        }
        if (null == root.left && null == root.right) {
            return root.val;
        }
        getPaths(root);
        int sum = 0, len = 0;
        for (ArrayList<Integer> list : paths) {
            len = list.size();
            if (len > 1) {
                int val = 0;
                for (int i = 0; i < len; i++) {
                    int mod = list.get(i);
                    val += Math.pow(10, len - i - 1) * mod;
                }
                sum += val;
            }
        }
        return sum;
    }

    public void getPaths(TreeNode root) {
        path.add(root.val);
        if (null == root.left && null == root.right) {
            paths.add(new ArrayList<>(path));
        }
        if (null != root.left)
            getPaths(root.left);
        if (null != root.right)
            getPaths(root.right);
        if (path.size() > 0) {
            path.remove(path.size() - 1);
        }
    }

    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
