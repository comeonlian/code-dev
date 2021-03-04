package com.leolian.data.structure.queue;

/**
 * @author Lian
 * @description:
 * @date 2020/7/19 16:26
 */
public class CycleArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] array;


    public CycleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.front = 0;
        this.rear = 0;
        this.array = new int[maxSize];
    }


    /**
     * @return
     */
    public boolean isFull() {
        if (((rear + 1) % maxSize) == front) {
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
     * @param data
     */
    public void addQueue(int data) {
        if (isFull()) {
            System.err.println("队列已满，稍后重试！");
            return;
        }
        array[rear] = data;
        rear = (rear + 1) % maxSize;
    }


    /**
     * @return
     */
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，请稍后重试！");
        }
        int res = array[front];
        array[front] = 0;
        front = (front + 1) % maxSize;
        return res;
    }


    /**
     * @return
     */
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，请稍后重试！");
        }
        return array[front];
    }


    /**
     *
     */
    public void showQueue() {
        if (isEmpty()) {
            System.err.println("队列为空，请稍后重试！");
            return;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, array[i]);
        }
    }


}
