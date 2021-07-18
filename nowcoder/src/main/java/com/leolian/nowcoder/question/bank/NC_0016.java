package com.leolian.nowcoder.question.bank;

import java.util.LinkedList;
import java.util.Queue;

/**
 * NC 16 : 判断二叉树是否对称
 * <p>
 * 题目描述
 * 给定一棵二叉树，判断其是否是自身的镜像（即：是否对称）
 * 例如：下面这棵二叉树是对称的
 * 1
 * /  \
 * 2    2
 * / \    / \
 * 3 4  4  3
 * 下面这棵二叉树不对称。
 * 1
 * / \
 * 2   2
 * \    \
 * 3    3
 * 备注：
 * 希望你可以用递归和迭代两种方法解决这个问题
 * <p>
 * 示例1 :
 * 输入：{1,2,2}
 * 返回值：true
 * <p>
 * 示例2 :
 * 输入：{1,2,3,3,#,2,#}
 * 返回值：false
 */
public class NC_0016 {

    public static void main(String[] args) {
        NC_0016 nc0016 = new NC_0016();


    }

    /**
     * 递归解法
     * 判断二叉树是否是对称，需要从子节点开始比较，两个子节点的值必须相同，
     * 并且左子节点的右子节点（如果有）必须等于右子节点的左子节点，左子节点的左子节点必须等于右子节点的右子节点
     *
     * @param root TreeNode类
     * @return bool布尔型
     */
    public boolean isSymmetricRecursion(TreeNode root) {
        if (null == root) {
            return true;
        }
        return isSymmetricHelper(root.left, root.right);
    }

    /**
     * 递归左右子节点
     *
     * @param left
     * @param right
     * @return
     */
    public boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (null == left && null == right) {
            return true;
        }
        if (null == left || null == right || left.val != right.val) {
            return false;
        }
        return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
    }

    /**
     * 非递归解法
     * 利用队列，左右两个对称节点入队出队
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            TreeNode leftNode = queue.poll();
            TreeNode rightNode = queue.poll();
            if (null == leftNode && null == rightNode) {
                continue;
            }
            if (null == leftNode || null == rightNode || leftNode.val != rightNode.val) {
                return false;
            }
            queue.add(leftNode.left);
            queue.add(rightNode.right);
            queue.add(leftNode.right);
            queue.add(rightNode.left);
        }
        return true;
    }


    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

}
