package com.leolian.nowcoder.question.bank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * NC 11 : 将升序数组转化为平衡二叉搜索树
 * <p>
 * 题目描述
 * 给出一个升序排序的数组，将其转化为平衡二叉搜索树（BST）
 * <p>
 * 示例1
 * 输入：[-1,0,1,2]
 * 返回值：{1,0,2,-1}
 */
public class NC_0011 {

    public static void main(String[] args) {
        NC_0011 nc0011 = new NC_0011();

        int[] num = new int[]{-1,0,1,2};
        TreeNode treeNode = nc0011.sortedArrayToBST(num);
        nc0011.levelPrint(treeNode);
        System.out.println();
    }

    public TreeNode sortedArrayToBST(int[] num) {
        if (null == num || num.length == 0) {
            return null;
        }
        if (num.length == 1) {
            return new TreeNode(num[0]);
        }
        return build(num, 0, num.length - 1);
    }

    public TreeNode build(int[] num, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end + 1) / 2;
        TreeNode root = new TreeNode(num[mid]);
        // 递归构建左子树
        TreeNode left = build(num, start, mid - 1);
        TreeNode right = build(num, mid + 1, end);
        root.left = left;
        root.right = right;
        return root;
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public void print(TreeNode root) {
        if (null == root)
            return;
        print(root.left);
        System.out.print(root.val + " ");
        print(root.right);
    }

    public void levelPrint(TreeNode root) {
        if (null == root) {
            return;
        }
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.remove();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        System.out.println(list);
    }

}
