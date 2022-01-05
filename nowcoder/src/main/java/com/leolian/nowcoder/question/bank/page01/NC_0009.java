package com.leolian.nowcoder.question.bank.page01;

/**
 * NC 9 : 二叉树中是否存在节点和为指定值的路径
 * <p>
 * 题目描述
 * 给定一个二叉树和一个值 sum，判断是否有从根节点到叶子节点的节点值之和等于 sum 的路径，
 * 例如：
 * 给出如下的二叉树，sum=22
 * 返回true，因为存在一条路径 5→4→11→2 的节点值之和为 22
 * <p>
 * 示例1
 * 输入：{1,2},0
 * 返回值：false
 * <p>
 * 示例2
 * 输入：{1,2},3
 * 返回值：true
 */
public class NC_0009 {

    public static void main(String[] args) {
        NC_0009 nc_0009 = new NC_0009();


    }

    /**
     * @param root TreeNode类
     * @param sum  int整型
     * @return bool布尔型
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (null == root && sum == 0) {
            return false;
        }
        if (null == root) {
            return false;
        }
        if (root.val != 0 && sum == 0) {
            return false;
        }
        return checkSum(root, 0, sum);
    }

    public boolean checkSum(TreeNode root, int curSum, int targetSum) {
        if (null == root) {
            return false;
        }
        curSum = curSum + root.val;
        if (null == root.left && null == root.right && curSum == targetSum) {
            return true;
        }
        return checkSum(root.left, curSum, targetSum) || checkSum(root.right, curSum, targetSum);
    }


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

}
