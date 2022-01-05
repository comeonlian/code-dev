package com.leolian.nowcoder.question.bank.page01;

/**
 * NC 33 : 合并有序链表
 * <p>
 * 描述
 * 将两个有序的链表合并为一个新链表，要求新的链表是通过拼接两个链表的节点来生成的，且合并后新链表依然有序。
 * <p>
 * 示例1
 * 输入：{1},{2}
 * 返回值：{1,2}
 * <p>
 * 示例2
 * 输入：{2},{1}
 * 返回值：{1,2}
 */
public class NC_0033 {

    public static void main(String[] args) {
        NC_0033 nc0033 = new NC_0033();

        ListNode l1 = new ListNode();
        l1.val = 6;
        ListNode l11 = new ListNode();
        l11.val = 16;
        l1.next = l11;

        ListNode l2 = new ListNode();
        l2.val = 8;

        ListNode listNode = nc0033.mergeTwoLists(l1, l2);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    /**
     * @param l1 ListNode类
     * @param l2 ListNode类
     * @return ListNode类
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write code here
        ListNode startResNode = null;
        ListNode resNode = null;
        ListNode startTmp1 = l1;
        ListNode startTmp2 = l2;
        while (startTmp1 != null && startTmp2 != null) {
            if (null == resNode) {
                resNode = new ListNode();
                startResNode = resNode;
            } else {
                ListNode tempNode = new ListNode();
                resNode.next = tempNode;
                resNode = tempNode;
            }
            if (startTmp1.val <= startTmp2.val) {
                resNode.val = startTmp1.val;
                startTmp1 = startTmp1.next;
            } else {
                resNode.val = startTmp2.val;
                startTmp2 = startTmp2.next;
            }
        }
        while (startTmp1 != null) {
            if (null == resNode) {
                resNode = new ListNode();
                startResNode = resNode;
            } else {
                ListNode tempNode = new ListNode();
                resNode.next = tempNode;
                resNode = tempNode;
            }
            resNode.val = startTmp1.val;
            startTmp1 = startTmp1.next;
        }
        while (startTmp2 != null) {
            if (null == resNode) {
                resNode = new ListNode();
                startResNode = resNode;
            } else {
                ListNode tempNode = new ListNode();
                resNode.next = tempNode;
                resNode = tempNode;
            }
            resNode.val = startTmp2.val;
            startTmp2 = startTmp2.next;
        }
        return startResNode;
    }
    /*
    运行时间：52ms
    超过40.84% 用Java提交的代码
    占用内存：11444KB
    超过33.21%用Java提交的代码
    */
}

class ListNode {
    int val;
    ListNode next = null;
}
