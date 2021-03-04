package com.leolian.data.structure.list.circle;

/**
 * @author Lian
 * @description:
 * @date 2020/10/17 17:02
 */
public class Boy {
    private int no;
    private Boy next;

    public Boy() {
    }

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

}
