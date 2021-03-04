package com.leolian.leetcode.questionbank.multithread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author lianliang
 * @date 2019/11/13 11:30
 */
public class Foo1115 {

    public static void main(String[] args) {
        FooBar1 fooBar = new FooBar1(6);
        Thread thread1 = new Thread(() -> {
            try {
                fooBar.foo(() -> {
                    System.out.println("foo");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                fooBar.bar(() -> {
                    System.out.println("bar");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
    }

}

class FooBar {
    private Lock lock = new ReentrantLock();
    private volatile boolean flag = true;
    private Condition conditionFoo = lock.newCondition();
    private Condition conditionBar = lock.newCondition();

    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        lock.lock();
        if (!flag) {
            conditionFoo.await();
        }
        for (int i = 0; i < n; i++) {
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
        }
        flag = false;
        conditionBar.signalAll();
        lock.unlock();
    }

    public void bar(Runnable printBar) throws InterruptedException {
        lock.lock();
        if (flag) {
            conditionBar.await();
        }
        for (int i = 0; i < n; i++) {
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
        }
        flag = true;
        conditionFoo.signal();
        lock.unlock();
    }
}

class FooBar1 {
    private Semaphore semaphore1 = new Semaphore(0);
    private Semaphore semaphore2 = new Semaphore(1);

    private int n;

    public FooBar1(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        semaphore2.acquire();
        for (int i = 0; i < n; i++) {
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
        }
        semaphore1.release();
    }

    public void bar(Runnable printBar) throws InterruptedException {
        semaphore1.acquire();
        for (int i = 0; i < n; i++) {
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
        }
        semaphore2.release();
    }
}

