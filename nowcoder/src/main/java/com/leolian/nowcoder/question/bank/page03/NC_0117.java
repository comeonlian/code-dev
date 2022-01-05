package com.leolian.nowcoder.question.bank.page03;


/**
 * NC 117 : 合并二叉树
 * <p>
 * 题目描述
 * 已知两颗二叉树，将它们合并成一颗二叉树。合并规则是：都存在的结点，就将结点值加起来，否则空的位置就由另一个树的结点来代替。
 * 例如：
 * 两颗二叉树是:
 * Tree 1  
 *      1   
 *     / \   
 *    3   2
 *   /      
 *  5   
 *
 * Tree 2
 *    2
 *   / \
 *  1   3
 *   \   \
 *    4   7
 *
 * 合并后的树为
 *     3
 *    / \
 *   4   5
 *  / \    \
 * 5  4    7
 * <p>
 * 示例1:
 * 输入：{1,3,2,5},{2,1,3,#,4,#,7}
 * 返回值：{3,4,5,5,4,#,7}
 */
public class NC_0117 {

    public static void main(String[] args) {
        NC_0117 nc0117 = new NC_0117();

        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.left = node3;

        TreeNode root1 = new TreeNode(2);
        TreeNode node11 = new TreeNode(1);
        TreeNode node22 = new TreeNode(3);
        TreeNode node33 = new TreeNode(4);
        TreeNode node44 = new TreeNode(7);

        root1.left = node11;
        root1.right = node22;
        node11.right = node33;
        node22.right = node44;

        TreeNode treeNode = nc0117.mergeTrees(root, root1);
        nc0117.print(treeNode);
    }

    /**
     * 中序打印二叉树
     *
     * @param root
     */
    public void print(TreeNode root) {
        if (null == root) {
            return;
        }
        if (root.left != null) {
            print(root.left);
        }
        System.out.print(root.val + " ");
        if (root.right != null) {
            print(root.right);
        }
    }

    /**
     * @param t1 TreeNode类
     * @param t2 TreeNode类
     * @return TreeNode类
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (null == t1 && null == t2) {
            return null;
        }
        if (null == t1) {
            return t2;
        }
        if (null == t2) {
            return t1;
        }
        TreeNode treeNode = new TreeNode(t1.val + t2.val);
        TreeNode left = mergeTrees(t1.left, t2.left);
        TreeNode right = mergeTrees(t1.right, t2.right);
        treeNode.left = left;
        treeNode.right = right;
        return treeNode;
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
