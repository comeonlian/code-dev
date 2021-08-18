package com.leolian.nowcoder.question.book.sword.finger.offer;

/**
 * JZ 46 : 孩子们的游戏(圆圈中最后剩下的数)
 * <p>
 * 题目描述
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。
 * 其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数 m,让编号为 0 的小朋友开始报数。
 * 每次喊到 m-1 的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
 * 从他的下一个小朋友开始,继续 0...m-1 报数....这样下去....直到剩下最后一个小朋友,可以不用表演,
 * 并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
 * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 * <p>
 * 如果没有小朋友，请返回 -1
 * <p>
 * 示例1
 * 输入：5,3
 * 返回值：3
 */
public class JZ_046 {

    public static void main(String[] args) {
        JZ_046 jz046 = new JZ_046();

        int n = 6;
        int m = 7;
        System.out.println(jz046.LastRemaining_Solution(n, m));
    }

    public int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        ListNode head = null, cur = null;
        for (int i = 0; i < n; i++) {
            if (null == head) {
                head = new ListNode(i);
                cur = head;
            } else {
                ListNode node = new ListNode(i);
                cur.next = node;
                cur = node;
            }
        }
        cur.next = head;
        ListNode preNode = cur, curNode = head;
        int count = 0;
        while (preNode != curNode) {
            if (count == (m - 1)) {
                preNode.next = curNode.next;
                curNode = curNode.next;
                count = 0;
            } else {
                preNode = preNode.next;
                curNode = curNode.next;
                count++;
            }
        }
        return curNode.val;
    }

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
