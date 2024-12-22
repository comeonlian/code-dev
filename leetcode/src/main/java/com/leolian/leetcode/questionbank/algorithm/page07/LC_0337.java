package com.leolian.leetcode.questionbank.algorithm.page07;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * LC 337 : 打家劫舍 III
 * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
 * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。
 * 一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
 * 提示：
 * 树的节点数在 [1, 10^4] 范围内
 * 0 <= Node.val <= 10^4
 * <p>
 * 示例1
 * 输入: root = [3,2,3,null,3,null,1]
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7
 * https://assets.leetcode.com/uploads/2021/03/10/rob1-tree.jpg
 * <p>
 * 示例2
 * 输入: root = [3,4,5,1,3,null,1]
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 4 + 5 = 9
 * https://assets.leetcode.com/uploads/2021/03/10/rob2-tree.jpg
 */
public class LC_0337 {

    public static void main(String[] args) {
        LC_0337 lc0337 = new LC_0337();

        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(5);

        root.left = node1;
        root.right = node2;

        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(1);

        node1.left = node3;
        node1.right = node4;
        node2.right = node5;

        System.out.println(lc0337.rob(root));
    }

    private AtomicInteger oddCount = new AtomicInteger(0);
    private AtomicInteger evenCount = new AtomicInteger(0);

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        treeCount(root, 1);
        return Math.max(oddCount.get(), evenCount.get());
    }

    private void treeCount(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        int val = level % 2 == 0 ? evenCount.addAndGet(root.val) : oddCount.addAndGet(root.val);
        treeCount(root.left, level + 1);
        treeCount(root.right, level + 1);
    }

    static class TreeNode {
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
