package com.leolian.data.structure.hashtab;

/**
 * 哈希表
 */
public class HashTab {
    int size;

    EmpLinkedList[] tab = null;

    public HashTab(int size) {
        this.size = size;
        this.tab = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            tab[i] = new EmpLinkedList();
        }
    }

    private int hash(int hasCode) {
        return hasCode % size;
    }

    public void add(Emp emp) {
        int hash = hash(emp.id);
        tab[hash].add(emp);
    }

    public void list() {
        for (int i = 0; i < size; i++) {
            tab[i].list(i);
        }
    }

    public void findEmpById(int id) {
        //使用散列函数确定到哪条链表查找
        int empLinkedListNO = hash(id);
        Emp emp = tab[empLinkedListNO].findEmpById(id);
        if (emp != null) {//找到
            System.out.printf("在第%d 条链表中找到 雇员 id = %d\n", (empLinkedListNO + 1), id);
        } else {
            System.out.println("在哈希表中，没有找到该雇员~");
        }
    }


}
