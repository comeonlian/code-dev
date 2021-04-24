package com.leolian.data.structure.hashtab;

/**
 * 链表
 */
public class EmpLinkedList {
    Emp head;

    public void add(Emp emp) {
        if (null == head) {
            head = emp;
            return;
        }
        Emp curEmp = head;
        while (null != curEmp.next) {
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }

    public void list(int no) {
        if (null == head) {
            System.out.println("第 " + (no + 1) + " 链表为空");
            return;
        }
        Emp curEmp = head;
        System.out.print("第 " + (no + 1) + " 链表的信息为");
        while (null != curEmp) {
            System.out.printf(" => id=%d name=%s\t", curEmp.id, curEmp.name);
            curEmp = curEmp.next;
        }
        System.out.println();
    }

    public Emp findEmpById(int id) {
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        //辅助指针
        Emp curEmp = head;
        while (null != curEmp) {
            if (curEmp.id == id) {//找到
                break;//这时 curEmp 就指向要查找的雇员
            }
            curEmp = curEmp.next;//以后
        }
        return null;
    }

}
