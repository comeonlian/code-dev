package com.leolian.data.structure.list.single;

/**
 * @author Lian
 * @description:
 * @date 2020/7/19 21:31
 */
public class SingleLinkedListMain {

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        InterviewAnswer interviewAnswer = new InterviewAnswer();

        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");

        // singleLinkedList.add(heroNode1);
        // singleLinkedList.add(heroNode2);
        // singleLinkedList.add(heroNode3);
        // singleLinkedList.add(heroNode4);

        // add by order
        System.out.println("===================== add ======================");
        singleLinkedList.addByOrder(heroNode1);
        singleLinkedList.addByOrder(heroNode3);
        singleLinkedList.addByOrder(heroNode2);
        singleLinkedList.addByOrder(heroNode4);
        singleLinkedList.list();
        System.out.println("===================== update ======================");

        // update
        HeroNode heroNode = new HeroNode(7, "小宋", "及时雨~~");
        //singleLinkedList.update(heroNode);
        singleLinkedList.list();
        System.out.println("===================== delete ======================");

        // delete
        //singleLinkedList.del(8);
        singleLinkedList.list();

        // head node
        HeroNode head = singleLinkedList.getHead();

        // size
        System.out.println("===================== size ======================");
        int size = interviewAnswer.getSingleLinkedListSize(head);
        System.out.println("List size: " + size);

        // last k node
        System.out.println("===================== last k node ======================");
        HeroNode reverseKNode = interviewAnswer.getSingleLinkedListReverseKNode(head, 3);
        System.out.println(reverseKNode);

        // reverse signle linked list
        System.out.println("===================== reverse linked list ======================");
        SingleLinkedList reverseSingleLinkedList = interviewAnswer.reverseSingleLinkedList(head);
        reverseSingleLinkedList.list();

    }

}
