package com.leolian.data.structure.list.circle;

import java.util.ArrayList;
import java.util.List;

/**
 * 设编号为 1，2，… n 的 n 个人围坐一圈，约定编号为 k（1<=k<=n）的人从 1 开始报数，数到
 * m 的那个人出列，它的下一位又从 1 开始报数，数到 m 的那个人又出列，依次类推，直到所有人出列为止，由此
 * 产生一个出队编号的序列
 */
public class Joseph {

    public static void main(String[] args) {
        Joseph joseph = new Joseph();

        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        joseph.josephu(circleSingleLinkedList, 5, 2, 2);
    }


    /**
     * 解决约瑟夫问题
     *
     * @param nums    节点总个数
     * @param startNo 开始报数的第k个节点
     * @param countNo 出圈的第m个节点
     */
    public void josephu(CircleSingleLinkedList circleSingleLinkedList, int nums, int startNo, int countNo) {
        if (startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误， 请重新输入");
            return;
        }
        // 先构建环形链表
        circleSingleLinkedList.add(nums);
        circleSingleLinkedList.list();
        // 初始化helper指针
        Boy first = circleSingleLinkedList.getFirst();
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
