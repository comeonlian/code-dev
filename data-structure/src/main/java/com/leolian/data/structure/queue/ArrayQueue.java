package com.leolian.data.structure.queue;

/**
 * @author 80254155
 * @description:
 * @date 2020/7/5 20:58
 */
public class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] array;


    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.front = -1;
        this.rear = -1;
        this.array = new int[maxSize];
    }


    /**
     * @param data
     */
    public void addQueue(int data) {
        if (isFull()) {
            System.err.println("队列已满，无法添加数据！");
            return;
        }
        array[++rear] = data;
    }


    /**
     * @return
     */
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，稍后重试！");
        }
        return array[++front];
    }


    /**
     * @return
     */
    public boolean isFull() {
        if (rear == (maxSize - 1)) {
            return true;
        }
        return false;
    }


    /**
     * @return
     */
    public boolean isEmpty() {
        if (front == rear) {
            return true;
        }
        return false;
    }


    /**
     * @return
     */
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，稍后重试！");
        }
        return array[++front];
    }


    /**
     *
     */
    public void showQueue() {
        if (isEmpty()) {
            System.err.println("队列为空，稍后重试！");
            return;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, array[i]);
        }
    }

}
