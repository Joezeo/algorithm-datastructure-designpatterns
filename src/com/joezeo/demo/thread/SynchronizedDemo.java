package com.joezeo.demo.thread;

public class SynchronizedDemo {
    public static void main(String[] args) {
        new SynchronizedDemo().hello();
    }

    public synchronized void hello(){
        System.out.println("Hello World");
    }

}
