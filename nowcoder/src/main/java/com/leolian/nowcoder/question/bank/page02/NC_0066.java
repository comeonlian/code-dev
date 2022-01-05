package com.leolian.nowcoder.question.bank.page02;

/**
 * NC 66 : 两个链表的第一个公共结点
 * <p>
 * 输入两个无环的单链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，
 * 保证传入数据是正确的）
 * <p>
 * 示例1:
 * 输入：{1,2,3},{4,5},{6,7}
 * 返回值：{6,7}
 * 说明：第一个参数{1,2,3}代表是第一个链表非公共部分，第二个参数{4,5}代表是第二个链表非公共部分，
 * 最后的{6,7}表示的是2个链表的公共部分，这3个参数最后在后台会组装成为2个两个无环的单链表，且是有公共节点的
 * <p>
 * 示例2:
 * 输入：{1},{2,3},{}
 * 返回值：{}
 * 说明：两个链表没有公共节点 ,返回null，后台打印{}
 */
public class NC_0066 {

    public static void main(String[] args) {
        NC_0066 nc0066 = new NC_0066();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node4.next = node5;

        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        node6.next = node7;

        node3.next = node6;
        node5.next = node6;

        ListNode listNode = nc0066.FindFirstCommonNode(node1, node4);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    /**
     * @param pHead1
     * @param pHead2
     * @return
     */

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            if (p1 == null) {
                p1 = pHead2;
            } else {
                p1 = p1.next;
            }
            if (p2 == null) {
                p2 = pHead1;
            } else {
                p2 = p2.next;
            }
        }
        return p1;
    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}
