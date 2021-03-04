package com.leolian.data.structure.list.single;

/**
 * @author Lian
 * @description: 单向链表
 * @date 2020/7/19 21:31
 */
public class SingleLinkedList {
    public HeroNode head = null;
    public HeroNode rear = null;

    public SingleLinkedList() {
        this.head = new HeroNode(-1, "", "");
        this.rear = head;
    }

    public HeroNode getHead() {
        return head;
    }

    /**
     * 新增节点
     *
     * @param heroNode
     */
    public void add(HeroNode heroNode) {
        this.head.next = heroNode;
        this.rear = heroNode;
    }

    /**
     * 以排序方式新增节点
     *
     * @param heroNode
     */
    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        while (true) {
            if (null == temp.next) {
                break;
            }
            if (temp.next.no > heroNode.no) {
                break;
            }
            temp = temp.next;
        }
        heroNode.next = temp.next;
        temp.next = heroNode;
    }


    /**
     * 打印链表
     */
    public void list() {
        HeroNode temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    /**
     * 更新链表节点
     *
     * @param heroNode
     */
    public void update(HeroNode heroNode) {
        HeroNode temp = head.next;
        while (temp != null) {
            if (temp.no == heroNode.no) {
                temp.name = heroNode.name;
                temp.nickName = heroNode.nickName;
                break;
            }
            temp = temp.next;
        }
        if (null == temp) {
            System.err.println("未找到需要更新的节点，请检查！");
        }
    }

    /**
     * 删除节点
     *
     * @param no
     */
    public void del(int no) {
        HeroNode temp = head;
        while (true) {
            if (null == temp.next) {
                break;
            }
            if (temp.next.no == no) {
                break;
            }
            temp = temp.next;
        }
        if (null == temp.next) {
            System.err.println("未找到需要删除的节点，请重试！");
        } else {
            temp.next = temp.next.next;
        }
    }

}
