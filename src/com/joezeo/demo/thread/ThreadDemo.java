package com.joezeo.demo.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 目标：两个线程交替输出奇数、偶数
 */
public class ThreadDemo {
    private static CountDownLatch latch = new CountDownLatch(100);
    private static ReentrantLock reentrantLock = new ReentrantLock(true);

    public static void main(String[] args) throws InterruptedException {
        ThreadDemo.Inner1 inner1 = new ThreadDemo.Inner1();
        ThreadDemo.Inner2 inner2 = new ThreadDemo.Inner2();
        new Thread(inner1).start();
        new Thread(inner2).start();
        latch.await();
    }

    public static class Inner1 implements Runnable {
        @Override
        public void run() {
            for(int i=1; i<100; i+=2){
                reentrantLock.lock();
                System.out.println(i);
                reentrantLock.unlock();
            }
        }
    }


    public static class Inner2 implements Runnable {
        @Override
        public void run() {
            for(int i=2; i<100; i+=2){
                reentrantLock.lock();
                System.out.println(i);
                reentrantLock.unlock();
            }
        }
    }
}
