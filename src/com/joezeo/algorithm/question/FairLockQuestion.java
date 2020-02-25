package com.joezeo.algorithm.question;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个线程交替输出
 * 一个线程输出奇数，一个输出偶数
 */
public class FairLockQuestion {

    private static Object lock = new Object();
    private static volatile boolean flag = true;
    private static ReentrantLock reentrantLock = new ReentrantLock(true);

    public static void main(String[] args) {
//        useSynchronized();
        useFlag();
//        useReentrantlock();
    }

    public static void useReentrantlock() {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i < 100; i += 2) {
                reentrantLock.lock();
                System.out.println(i);
                reentrantLock.unlock();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 2; i < 100; i += 2) {
                reentrantLock.lock();
                System.out.println(i);
                reentrantLock.unlock();
            }
        });
        t1.start();
        t2.start();
    }

    public static void useFlag() {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i < 100; i += 2) {
                synchronized (lock) {
                    if (flag) {
                        System.out.println(i);
                        flag = false;
                    }
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 2; i < 100; i += 2) {
                synchronized (lock) {
                    if (!flag) {
                        System.out.println(i);
                        flag = true;
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }

    public static void useSynchronized() {
        Thread t1 = new Thread(() -> {
            for (int i = 1; true; i += 2) {
                synchronized (lock) {
                    System.out.println(i);
                    try {
                        Thread.currentThread().wait(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 2; true; i += 2) {
                synchronized (lock) {
                    System.out.println(i);
                    try {
                        Thread.currentThread().wait(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }
}
