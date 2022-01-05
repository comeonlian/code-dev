package com.leolian.nowcoder.question.bank.page02;

import java.util.Stack;

/**
 * NC 78 : 用两个栈实现队列
 * <p>
 * 题目描述
 * 用两个栈来实现一个队列，分别完成在队列尾部插入整数(push)和在队列头部删除整数(pop)的功能。
 * 队列中的元素为int类型。保证操作合法，即保证pop操作时队列内已有元素。
 * <p>
 * 示例:
 * 输入:
 * ["PSH1","PSH2","POP","POP"]
 * 返回:
 * 1,2
 * 解析:
 * "PSH1":代表将1插入队列尾部
 * "PSH2":代表将2插入队列尾部
 * "POP“:代表删除一个元素，先进先出=>返回1
 * "POP“:代表删除一个元素，先进先出=>返回2
 * <p>
 * 示例1:
 * 输入：
 * ["PSH1","PSH2","POP","POP"]
 * 返回值：
 * 1,2
 */
public class NC_0076 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public static void main(String[] args) {
        NC_0076 nc0076 = new NC_0076();
        // push 
        nc0076.push(1);
        nc0076.push(2);
        nc0076.push(3);
        nc0076.push(4);
        nc0076.push(5);

        System.out.println(nc0076.pop());
        System.out.println(nc0076.pop());
        System.out.println(nc0076.pop());
    }

    public void push(int node) {
        stack1.push(node);
    }

    /**
     * 1.当插入时，直接插入 stack1
     * 2.当弹出时，当 stack2 不为空，弹出 stack2 栈顶元素，如果 stack2 为空，将 stack1 中的全部数逐个出栈入栈 stack2，再弹出 stack2 栈顶元素
     * @return
     */
    public int pop() {
        if (stack2.size() <= 0) {
            while (stack1.size() != 0) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

}

