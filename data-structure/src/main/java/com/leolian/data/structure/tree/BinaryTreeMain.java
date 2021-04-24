package com.leolian.data.structure.tree;

/**
 *
 */
public class BinaryTreeMain {

    public static void main(String[] args) {
        //先需要创建一颗二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建需要的结点
        TreeNode root = new TreeNode(1, "宋江");
        TreeNode node2 = new TreeNode(2, "吴用");
        TreeNode node3 = new TreeNode(3, "卢俊义");
        TreeNode node4 = new TreeNode(4, "林冲");
        TreeNode node5 = new TreeNode(5, "关胜");
        //说明，我们先手动创建该二叉树，后面我们学习递归的方式创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);
        // 测试
//        System.out.println("前序遍历"); // 1,2,3,5,4
//        binaryTree.preOrder();

        // 测试
//        System.out.println("中序遍历"); // 2,1,5,3,4
//        binaryTree.midOrder();

        // 测试
        System.out.println("后序遍历"); // 2,5,4,3,1
        binaryTree.postOrder();

        // 查找ID
        int no = 15;
        //前序遍历
        //前序遍历的次数 ：4
//        System.out.println("前序遍历方式~~~");
//        TreeNode resNode = binaryTree.preOrderSearch(no);
//        if (resNode != null) {
//            System.out.printf("找到了，信息为 no=%d name=%s", resNode.getId(), resNode.getName());
//        } else {
//            System.out.printf("没有找到 no = %d 的英雄", no);
//        }

        //中序遍历查找
        //中序遍历 3 次
//        System.out.println("中序遍历方式~~~");
//        TreeNode resNode = binaryTree.midOrderSearch(no);
//        if (resNode != null) {
//            System.out.printf("找到了，信息为 no=%d name=%s", resNode.getId(), resNode.getName());
//        } else {
//            System.out.printf("没有找到 no = %d 的英雄", no);
//        }

        //后序遍历查找
        //后序遍历查找的次数 2 次
//        System.out.println("后序遍历方式~~~");
//        TreeNode resNode = binaryTree.postOrderSearch(no);
//        if (resNode != null) {
//            System.out.printf("找到了，信息为 no=%d name=%s", resNode.getId(), resNode.getName());
//        } else {
//            System.out.printf("没有找到 no = %d 的英雄", no);
//        }

//        System.out.println("删除前,前序遍历");
//        binaryTree.preOrder(); // 1,2,3,5,4
////        binaryTree.delNode(5);
//        binaryTree.delNode(3);
//        System.out.println("删除后，前序遍历");
//        binaryTree.preOrder(); // 1,2,3,4
    }

}
