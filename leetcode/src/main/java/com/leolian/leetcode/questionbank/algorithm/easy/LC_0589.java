package com.leolian.leetcode.questionbank.algorithm.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * LC 589 : N 叉树的前序遍历
 * 给定一个 N 叉树，返回其节点值的 前序遍历 。
 * N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 * 提示：
 * N 叉树的高度小于或等于 1000
 * 节点总数在范围 [0, 10^4] 内
 * 进阶：
 * 递归法很简单，你可以使用迭代法完成此题吗?
 * <p>
 * 示例1
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[1,3,5,6,2,4]
 * https://assets.leetcode.com/uploads/2018/10/12/narytreeexample.png
 * <p>
 * 示例2
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[1,2,3,6,7,11,14,4,8,12,5,9,13,10]
 * https://assets.leetcode.com/uploads/2019/11/08/sample_4_964.png
 */
public class LC_0589 {

    public static void main(String[] args) {
        LC_0589 lc0589 = new LC_0589();

        Node root = new Node(1);
        Node node1 = new Node(3);
        Node node2 = new Node(2);
        Node node3 = new Node(4);

        ArrayList<Node> list = new ArrayList<>();
        list.add(node1);
        list.add(node2);
        list.add(node3);

        root.children = list;

        Node node11 = new Node(5);
        Node node12 = new Node(6);
        ArrayList<Node> list1 = new ArrayList<>();
        list1.add(node11);
        list1.add(node12);

        node1.children = list1;

        System.out.println(lc0589.preorder(root));
    }

    public List<Integer> preorder(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (null == root) {
            return new ArrayList<>();
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.add(node.val);
            List<Node> nodes = node.children;
            if (null != nodes && nodes.size() > 0) {
                int end = nodes.size() - 1;
                for (int i = end; i >= 0; i--) {
                    stack.push(nodes.get(i));
                }
            }
        }
        return list;
    }

    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
