package com.leolian.leetcode.questionbank.algorithm.page05;

import java.util.Stack;

/**
 * LC 232 : 用栈实现队列
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * 实现 MyQueue 类：
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * 说明：
 * 你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 提示：
 * 1 <= x <= 9
 * 最多调用 100 次 push、pop、peek 和 empty
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）
 * <p>
 * 示例1
 * 输入：
 * ["MyQueue", "push", "push", "peek", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null, null, null, 1, 1, false]
 * 解释：
 * MyQueue myQueue = new MyQueue();
 * myQueue.push(1); // queue is: [1]
 * myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
 * myQueue.peek(); // return 1
 * myQueue.pop(); // return 1, queue is [2]
 * myQueue.empty(); // return false
 */
public class LC_0232 {

    public static void main(String[] args) {
        LC_0232 lc0232 = new LC_0232();

        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(6);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }

    static class MyQueue {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        volatile int length;
        /**
         * 两个栈的顺序，true为正序；false为逆序
         */
        volatile boolean order;

        public MyQueue() {
            this.order = true;
        }

        public synchronized void push(int x) {
            length += 1;
            if (order) {
                stack1.push(x);
                return;
            }
            while (!stack2.empty()) {
                stack1.push(stack2.pop());
            }
            stack1.push(x);
            order = true;
        }

        public synchronized int pop() {
            if (empty()) {
                return 0;
            }
            length -= 1;
            if (!order) {
                return stack2.pop();
            }
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
            order = false;
            return stack2.pop();
        }

        public synchronized int peek() {
            if (empty()) {
                return 0;
            }
            if (!order) {
                return stack2.peek();
            }
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
            order = false;
            return stack2.peek();
        }

        public synchronized boolean empty() {
            System.out.println(length);
            return length == 0;
        }
    }
}
