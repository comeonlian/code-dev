package com.leolian.nowcoder.question.book.sword.finger.offer;

import java.util.ArrayList;

/**
 * JZ 26 : 二叉搜索树与双向链表
 * <p>
 * 题目描述
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。如下图所示
 * https://uploadfiles.nowcoder.com/images/20210605/557336_1622886924427/E1F1270919D292C9F48F51975FD07CE2
 * 注意:
 * 1.要求不能创建任何新的结点，只能调整树中结点指针的指向。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继
 * 2.返回链表中的第一个节点的指针
 * 3.函数返回的TreeNode，有左右指针，其实可以看成一个双向链表的数据结构
 * 4.你不用输出或者处理，示例中输出里面的英文，比如"From left to right are:"这样的，程序会根据你的返回值自动打印输出
 * 示例:
 * 输入: {10,6,14,4,8,12,16}
 * 输出:From left to right are:4,6,8,10,12,14,16;From right to left are:16,14,12,10,8,6,4;
 * 解析:
 * 输入就是一棵二叉树，如上图，输出的时候会将这个双向链表从左到右输出，以及
 * 从右到左输出，确保答案的正确
 * <p>
 * 示例1
 * 输入：{10,6,14,4,8,12,16}
 * 返回值：From left to right are:4,6,8,10,12,14,16;From right to left are:16,14,12,10,8,6,4;
 * <p>
 * 示例2
 * 输入：{5,4,#,3,#,2,#,1}
 * 返回值：From left to right are:1,2,3,4,5;From right to left are:5,4,3,2,1;
 * 说明：
 * 5
 * /
 * 4
 * /
 * 3
 * /
 * 2
 * /
 * 1
 * 树的形状如上图
 */
public class JZ_026 {

    public static void main(String[] args) {
        JZ_026 jz026 = new JZ_026();

        /*TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(6);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);

        TreeNode node11 = new TreeNode(14);
        TreeNode node22 = new TreeNode(12);
        TreeNode node33 = new TreeNode(16);

        root.left = node1;
        root.right = node11;

        node1.left = node2;
        node1.right = node3;

        node11.left = node22;
        node11.right = node33;*/

        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(1);

        root.left = node1;
        node1.left = node2;
        node2.left = node3;
        node3.left = node4;
        
        jz026.print(root);
        System.out.println();
        TreeNode node = jz026.Convert(root);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.right;
        }
    }

    public void print(TreeNode root) {
        if (null == root) {
            return;
        }
        print(root.left);
        System.out.print(root.val + " ");
        print(root.right);
    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (null == pRootOfTree) {
            return null;
        }
        if (null == pRootOfTree.left && null == pRootOfTree.right) {
            return pRootOfTree;
        }
        ArrayList<TreeNode> list = new ArrayList<>();
        mid(pRootOfTree, list);
        TreeNode pre, cur, next;
        for (int i = 0; i < list.size(); i++) {
            cur = list.get(i);
            if (i == 0) {
                next = list.get(i + 1);
                cur.left = null;
                cur.right = next;
            } else if (i == list.size() - 1) {
                pre = list.get(i - 1);
                cur.left = pre;
                cur.right = null;
            } else {
                pre = list.get(i - 1);
                next = list.get(i + 1);
                cur.left = pre;
                cur.right = next;
            }
        }
        return list.get(0);
    }

    public void mid(TreeNode root, ArrayList<TreeNode> list) {
        if (null == root) {
            return;
        }
        mid(root.left, list);
        list.add(root);
        mid(root.right, list);
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
