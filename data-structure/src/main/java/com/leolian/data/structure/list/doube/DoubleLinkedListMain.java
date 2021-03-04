package com.leolian.data.structure.list.doube;

/**
 * @author Lian
 * @description:
 * @date 2020/10/17 16:49
 */
public class DoubleLinkedListMain {

    public static void main(String[] args) {
        // 测试
        System.out.println("双向链表的测试");
        // 先创建节点
        HeroNodeDouble hero1 = new HeroNodeDouble(1, "宋江", "及时雨");
        HeroNodeDouble hero2 = new HeroNodeDouble(2, "卢俊义", "玉麒麟");
        HeroNodeDouble hero3 = new HeroNodeDouble(3, "吴用", "智多星");
        HeroNodeDouble hero4 = new HeroNodeDouble(4, "林冲", "豹子头");
        // 创建一个双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);
        doubleLinkedList.list();
        // 修改
        HeroNodeDouble newHeroNode = new HeroNodeDouble(4, "公孙胜", "入云龙");
        doubleLinkedList.update(newHeroNode);
        System.out.println("修改后的链表情况");
        doubleLinkedList.list();
        // 删除
        doubleLinkedList.del(3);
        System.out.println("删除后的链表情况~~");
        doubleLinkedList.list();
    }

}

