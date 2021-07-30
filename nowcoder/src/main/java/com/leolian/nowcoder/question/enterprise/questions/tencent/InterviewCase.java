package com.leolian.nowcoder.question.enterprise.questions.tencent;

import java.util.LinkedList;
import java.util.List;

/**
 * 已知搜索二叉树根节点root，求p、q节点的最近公共祖先
 * struct TreeNode
 * {
 * TreeNode* left;
 * TreeNode* right;
 * int val;
 * }
 */
public class InterviewCase {
    public static void main(String[] args) {
    }
    private List<TreeNode> pListPath = new LinkedList<>();
    
    private List<TreeNode> qListPath = new LinkedList<>();
    
    public void getTreeNode(TreeNode root, TreeNode p, TreeNode q) {
        if (null != root.left) {
            getTreeNode(root.left, p, q);
        }
        if (null != root.right) {
            getTreeNode(root.right, p, q);
        }
        if (root.val == p.val) {
            pListPath.add(root);
            return;
        } else {
            pListPath.add(root);
        }
        if (root.val == q.val) {
            qListPath.add(root);
        }
    }

    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
    }

}
