package com.leolian.leetcode.questionbank.algorithm.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * LC 145 : 二叉树的后序遍历
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 * 提示：
 * 树中节点的数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 * 进阶：递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * 示例1
 * 输入：root = [1,null,2,3]
 * 输出：[3,2,1]
 * <p>
 * 示例2
 * 输入：root = []
 * 输出：[]
 * <p>
 * 示例3
 * 输入：root = [1]
 * 输出：[1]
 */
public class LC_0145 {

    public static void main(String[] args) {
        LC_0145 lc0145 = new LC_0145();

        
    }
    
    public List<Integer> postorderTraversal(TreeNode root) {
        if (null == root) {
            return new ArrayList<>();
        }
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (stack.size() > 0) {
            TreeNode pop = stack.pop();
            list.add(pop.val);
            if (pop.left != null) {
                stack.push(pop.left);
            }
            if (pop.right != null) {
                stack.push(pop.right);
            }
        }
        
        Collections.reverse(list);
        return list;
    }
    
/*

    public List<Integer> postorderTraversal(TreeNode root) {
        if (null == root) {
            return new ArrayList<>();
        }
        ArrayList<Integer> list = new ArrayList<>();
        postorder(list, root);
        return list;
    }

    public void postorder(ArrayList<Integer> list, TreeNode node) {
        if (null == node) {
            return;
        }
        if (node.left != null) {
            postorder(list, node.left);
        }
        if (node.right != null) {
            postorder(list, node.right);
        }
        list.add(node.val);
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
}
