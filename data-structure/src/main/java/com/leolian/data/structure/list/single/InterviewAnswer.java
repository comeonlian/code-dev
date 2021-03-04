package com.leolian.data.structure.list.single;

/**
 * @author 80254155
 * @description:
 * @date 2020/7/20 17:43
 */
public class InterviewAnswer {

    /**
     * 获取链表长度
     *
     * @param heroNode
     * @return
     */
    public int getSingleLinkedListSize(HeroNode heroNode) {
        HeroNode temp = heroNode.next;
        if (null == temp) {
            return 0;
        }
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }


    /**
     * 获取单链表倒数第k个节点
     *
     * @param heroNode
     * @param k
     * @return
     */
    public HeroNode getSingleLinkedListReverseKNode(HeroNode heroNode, int k) {
        int size = getSingleLinkedListSize(heroNode);
        int len = size - k;
        int index = 0;
        HeroNode res = null;
        HeroNode node = heroNode.next;
        while (node != null) {
            if (index == len) {
                res = node;
                break;
            }
            index++;
            node = node.next;
        }
        return res;
    }


    /**
     * 单链表反转
     *
     * @param headNode
     * @return
     */
    public SingleLinkedList reverseSingleLinkedList(HeroNode headNode) {
        SingleLinkedList resList = new SingleLinkedList();
        HeroNode resHead = resList.getHead();
        HeroNode heroNode = headNode.next;
        while (heroNode != null) {
            HeroNode tmpNode = resHead.next;
            HeroNode heroNodeNext = heroNode.next;
            resHead.next = heroNode;
            heroNode.next = tmpNode;
            heroNode = heroNodeNext;
        }
        return resList;
    }


    /**
     * 倒序打印单链表，借助栈实现
     * 
     * @param heroNode
     */
    public void reversePrintSingleLinkedList(HeroNode heroNode) {
        SingleLinkedList singleLinkedList = reverseSingleLinkedList(heroNode);
        singleLinkedList.list();
    }


}
