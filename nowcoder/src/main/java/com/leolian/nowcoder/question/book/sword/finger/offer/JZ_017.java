package com.leolian.nowcoder.question.book.sword.finger.offer;

/**
 * JZ 17 : 树的子结构
 * <p>
 * 题目描述
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * <p>
 * 示例1
 * 输入：{8,8,#,9,#,2,#,5},{8,9,#,2}
 * 返回值：true
 */
public class JZ_017 {

	public static void main(String[] args) {
		JZ_017 jz017 = new JZ_017();

		TreeNode root = new TreeNode(8);
		TreeNode left = new TreeNode(6);
		TreeNode right = new TreeNode(10);
		root.left = left;
		root.right = right;

		TreeNode leftLeft = new TreeNode(5);
		TreeNode leftRight = new TreeNode(7);
		TreeNode rightLeft = new TreeNode(9);
		TreeNode rightRight = new TreeNode(11);
		left.left = leftLeft;
		left.right = leftRight;
		right.left = rightLeft;
		right.right = rightRight;

		TreeNode root2 = new TreeNode(6);
		TreeNode left2 = new TreeNode(5);
		TreeNode right2 = new TreeNode(7);
		root2.left = left2;
		root2.right = right2;

		System.out.println(jz017.HasSubtree(root, root2));
	}

	public boolean HasSubtree(TreeNode root1, TreeNode root2) {
		if (null == root1 || null == root2) {
			return false;
		}
		boolean rootRes = subTree(root1, root2);
		boolean leftRes = HasSubtree(root1.left, root2);
		boolean rightRes = HasSubtree(root1.right, root2);
		return rootRes || leftRes || rightRes;
	}

	public boolean subTree(TreeNode root1, TreeNode root2) {
		if (null == root2) { // B树结束
			return true;
		}
		if (null == root1) { // A树结束
			return false;
		}
		if (root1.val != root2.val) {
			return false;
		}
		boolean leftRes = subTree(root1.left, root2.left);
		boolean rightRes = subTree(root1.right, root2.right);
		return leftRes && rightRes;
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
