package com.leolian.nowcoder.question.book.sword.finger.offer;

/**
 * JZ 4 : 重建二叉树
 * <p>
 * 题目描述
 * 给定某二叉树的前序遍历和中序遍历，请重建出该二叉树并返回它的头结点。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建出如下图所示。
 * https://uploadfiles.nowcoder.com/images/20210717/557336_1626504921458/776B0E5E0FAD11A6F15004B29DA5E628
 * 提示:
 * 1.0 <= pre.length <= 2000
 * 2.vin.length == pre.length
 * 3.-10000 <= pre[i], vin[i] <= 10000
 * 4.pre 和 vin 均无重复元素
 * 5.vin出现的元素均出现在 pre里
 * 6.只需要返回根结点，系统会自动输出整颗树做答案对比
 * <p>
 * 示例1
 * 输入：[1,2,4,7,3,5,6,8],[4,7,2,1,5,3,8,6]
 * 返回值：{1,2,3,4,#,5,6,#,7,#,#,8}
 * 说明：
 * 返回根节点，系统会输出整颗二叉树对比结果
 * <p>
 * 示例2
 * 输入：[1],[1]
 * 返回值：{1}
 * <p>
 * 示例3
 * 输入：[1,2,3,4,5,6,7],[3,2,4,1,6,5,7]
 * 返回值：{1,2,5,3,4,6,7}
 */
public class JZ_004 {

    public static void main(String[] args) {
        JZ_004 jz004 = new JZ_004();

        int[] pre = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode res = jz004.reConstructBinaryTree(pre, in);
        jz004.print(res);
    }

    public void print(TreeNode root) {
        if (null == root) {
            return;
        }
        print(root.left);
        System.out.print(root.val + " ");
        print(root.right);
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (null == pre || pre.length == 0 || null == in || in.length == 0) {
            return null;
        }
        return constructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    public TreeNode constructBinaryTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int rootVal = pre[preStart];
        int rootIndex = inStart;
        for (; rootIndex <= inEnd; rootIndex++) {
            if (rootVal == in[rootIndex]) {
                break;
            }
        }
        int len = rootIndex - inStart;
        TreeNode root = new TreeNode(rootVal);
        TreeNode left = constructBinaryTree(pre, preStart + 1, preStart + len, in, inStart, rootIndex - 1);
        TreeNode right = constructBinaryTree(pre, preStart + len + 1, preEnd, in, rootIndex + 1, inEnd);
        root.left = left;
        root.right = right;
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
