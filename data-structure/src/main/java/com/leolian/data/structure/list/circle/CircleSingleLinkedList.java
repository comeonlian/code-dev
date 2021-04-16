package com.leolian.data.structure.list.circle;

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

    public Boy getFirst() {
        return first;
    }
    
}
