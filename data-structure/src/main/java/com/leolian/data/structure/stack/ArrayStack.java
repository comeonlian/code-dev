package com.leolian.data.structure.stack;

/**
 * @author Lian
 * @description:
 * @date 2020/10/17 17:55
 */
public class ArrayStack {
    private int size;
    private int top;
    private int[] data;

    public ArrayStack(int size) {
        this.top = -1;
        this.size = size;
        this.data = new int[size];
    }


    /**
     * 栈是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        if (top == -1) {
            return true;
        }
        return false;
    }


    /**
     * 栈是否满
     *
     * @return
     */
    public boolean isFull() {
        if (top == (size - 1)) {
            return true;
        }
        return false;
    }


    /**
     * 入栈
     *
     * @param val
     */
    public void push(int val) {
        if (isFull()) {
            System.out.println("栈已满，稍后再尝试添加！");
            return;
        }
        data[++top] = val;
    }


    /**
     * 出栈
     *
     * @return
     */
    public int pop() {
        if (isEmpty()) {
            System.out.println("栈为空，请稍后再尝试出栈！");
            return -1;
        }
        int val = data[top--];
        return val;
    }


    /**
     * 打印栈内容
     */
    public void list() {
        if (isEmpty()) {
            System.out.println("栈为空！");
            return;
        }
        System.out.println();
        for (int i = top; i >= 0; i--) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

}
