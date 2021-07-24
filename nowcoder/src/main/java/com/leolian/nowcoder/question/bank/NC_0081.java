package com.leolian.nowcoder.question.bank;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * NC 81 : 二叉搜索树的第k个结点
 * <p>
 * 题目描述
 * 给定一棵二叉搜索树，请找出其中的第k小的TreeNode结点。
 * <p>
 * 示例1:
 * 输入：{5,3,7,2,4,6,8},3
 * 返回值：4
 * 说明：
 * 按结点数值大小顺序第三小结点的值为4
 */
public class NC_0081 {

    public static void main(String[] args) {
        NC_0081 nc0081 = new NC_0081();

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

        int k = 3;
        System.out.println(nc0081.KthNode(root, k).val);
    }

    public TreeNode KthNode(TreeNode pRoot, int k) {
        if (null == pRoot) {
            return null;
        }
        if (k <= 0) {
            return null;
        }
        AtomicInteger count = new AtomicInteger(1);
        return search(pRoot, k, count);
    }

    public TreeNode search(TreeNode root, int k, AtomicInteger count) {
        TreeNode res = null;
        if (root.left != null) {
            res = search(root.left, k, count);
            if (null != res) {
                return res;
            }
        }
        if (count.getAndIncrement() == k) {
            return root;
        }
        if (root.right != null) {
            res = search(root.right, k, count);
            if (null != res) {
                return res;
            }
        }
        return res;
    }
    
/*
    public TreeNode KthNode(TreeNode pRoot, int k) {
        if (null == pRoot) {
            return null;
        }
        if (k <= 0) {
            return null;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        search(pRoot, linkedList);
        if (k > linkedList.size()) {
            return null;
        }
        int count = 0;
        for (TreeNode treeNode : linkedList) {
            if (count == k) {
                return treeNode;
            }
            count++;
        }
        return null;
    }

    public void search(TreeNode root, List<TreeNode> list) {
        if (root.left != null) {
            search(root.left, list);
        }
        list.add(root);
        if (root.right != null) {
            search(root.right, list);
        }
    }
*/

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
