package com.leolian.nowcoder.question.bank.page02;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * NC 58 : 找到搜索二叉树中两个错误的节点
 * <p>
 * 题目描述
 * 一棵二叉树原本是搜索二叉树，但是其中有两个节点调换了位置，
 * 使得这棵二叉树不再是搜索二叉树，请按升序输出这两个错误节点的值。(每个节点的值各不相同)
 * 备注：
 * 1≤n≤5×10^5
 * <p>
 * 示例1
 * 输入：{1,2,3}
 * 返回值：[1,2]
 */
public class NC_0058 {

    public static void main(String[] args) {
        NC_0058 nc0058 = new NC_0058();

        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);

        root.left = left;
        root.right = right;

        System.out.println(Arrays.toString(nc0058.findError(root)));
    }

    public int[] findError(TreeNode root) {
        if (null == root) {
            return new int[0];
        }
        ArrayList<Integer> list = new ArrayList<>();
        mid(root, list);
        if (list.size() < 2) {
            return new int[0];
        }
        int[] res = new int[2];
        int i, j;
        for (i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                res[1] = list.get(i);
                break;
            }
        }
        for (j = list.size() - 1; j > i; j--) {
            if (list.get(j) < list.get(j - 1)) {
                res[0] = list.get(j);
                break;
            }
        }
        return res;
    }

    public void mid(TreeNode root, ArrayList<Integer> list) {
        if (root.left != null) {
            mid(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            mid(root.right, list);
        }
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
