package com.leolian.data.structure.tree;

/**
 * 节点
 */
public class TreeNode {

    private int id;
    private String name;

    private TreeNode left;
    private TreeNode right;

    public TreeNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        System.out.println(this);
        if (null != left) {
            left.preOrder();
        }
        if (null != right) {
            right.preOrder();
        }
    }

    /**
     * 中序遍历
     */
    public void midOrder() {
        if (null != left) {
            left.midOrder();
        }
        System.out.println(this);
        if (null != right) {
            right.midOrder();
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        if (null != left) {
            left.postOrder();
        }
        if (null != right) {
            right.postOrder();
        }
        System.out.println(this);
    }

    /**
     * 前序遍历查找
     */
    public TreeNode preOrderSearch(int no) {
        System.out.println("进入前序遍历查找");
        if (id == no) {
            return this;
        }
        TreeNode resNode = null;
        if (null != left) {
            resNode = left.preOrderSearch(no);
        }
        if (null != resNode) {
            return resNode;
        }
        if (null != right) {
            resNode = right.preOrderSearch(no);
        }
        return resNode;
    }

    /**
     * 中序遍历查找
     */
    public TreeNode midOrderSearch(int no) {
        TreeNode resNode = null;
        if (null != left) {
            resNode = left.midOrderSearch(no);
        }
        if (null != resNode) {
            return resNode;
        }
        System.out.println("进入中序遍历查找");
        if (id == no) {
            return this;
        }
        if (null != right) {
            resNode = right.midOrderSearch(no);
        }
        return resNode;
    }

    /**
     * 后序遍历查找
     */
    public TreeNode postOrderSearch(int no) {
        TreeNode resNode = null;
        if (null != left) {
            resNode = left.postOrderSearch(no);
        }
        if (null != resNode) {
            return resNode;
        }
        if (null != right) {
            resNode = right.postOrderSearch(no);
        }
        if (null != resNode) {
            return resNode;
        }
        System.out.println("进入后序遍历查找");
        if (id == no) {
            return this;
        }
        return null;
    }

    /**
     * @param no
     */
    public void delNode(int no) {
        if (null != left && left.getId() == no) {
            left = null;
            return;
        }
        if (null != right && right.getId() == no) {
            right = null;
            return;
        }
        if (null != left) {
            left.delNode(no);
        }
        if (null != right) {
            right.delNode(no);
        }
    }

}
