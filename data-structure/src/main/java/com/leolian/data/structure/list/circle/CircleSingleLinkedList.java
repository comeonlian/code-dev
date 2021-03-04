package com.leolian.data.structure.list.circle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lian
 * @description: 循环单向链表
 * @date 2020/10/17 17:04
 */
public class CircleSingleLinkedList {
    private Boy first = null;


    /**
     * 构建一个循环单向链表
     *
     * @param nums
     */
    public void add(int nums) {
        if (nums < 1) {
            System.out.println("nums 值不正确");
            return;
        }
        Boy currentBoy = null;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);
                currentBoy = first;
            } else {
                currentBoy.setNext(boy);
                boy.setNext(first);
                currentBoy = boy;
            }
        }
    }


    /**
     * 打印循环单向链表
     */
    public void list() {
        if (first == null) {
            System.out.println("没有任何节点数据！");
            return;
        }
        Boy currentBoy = first;
        while (true) {
            System.out.printf("小孩的编号是: %d \n", currentBoy.getNo());
            if (currentBoy.getNext() == first) {
                break;
            }
            currentBoy = currentBoy.getNext();
        }
    }


    /**
     * 解决约瑟夫问题
     *
     * @param nums    节点总个数
     * @param startNo 开始报数的第k个节点
     * @param countNo 出圈的第m个节点
     */
    public void josephu(int nums, int startNo, int countNo) {
        if (startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误， 请重新输入");
            return;
        }
        // 先构建环形链表
        add(nums);
        list();
        // 初始化helper指针
        Boy helper = first;
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        // 移动first helper指针k-1次
        for (int i = 1; i < startNo; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        // 开始报数移 first helper移动m-1
        List<Integer> list = new ArrayList<>();
        int moveCount = countNo - 1;
        while (true) {
            if (helper == first) {
                break;
            }
            for (int i = 0; i < moveCount; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            // 节点出圈
            list.add(first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        list.add(first.getNo());
        System.out.println("出圈顺序: " + list);
    }


}
