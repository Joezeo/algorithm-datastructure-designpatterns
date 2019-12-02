package com.joezeo.designpattern.sigleton;

import java.util.Vector;
import java.util.concurrent.CountDownLatch;

/**
 *
 * 静态内部类式单例模式
 * 延迟加载：是
 * 线程安全：是
 *
 */
public class StaticInnerClassSingleton {
    private StaticInnerClassSingleton(){
    }

    private static class Inner{
        private static final StaticInnerClassSingleton instance = new StaticInnerClassSingleton();
    }
    /*
        类的初始化：
            类的主动引用（发生初始化）

            类的被动引用（不发生初始化）
                1、引用常量不发生初始化（在编译阶段时就存入了类的常量池中）
                2、通过数组定义类引用
                      如 DemoClass[] arr = new DemoClass[10]; 注意：无论是几维数组，第一个[]中必须有长度
                3、访问一个静态域时，只有真正申明了这个域的类才会被初始化

     */
    public static StaticInnerClassSingleton getInstance(){
        //Inner类没有主动使用
        //只有通过显式调用 getInstance 方法时，才会显式装载 Inner 类，从而实例化 instance
        return Inner.instance;
    }

    //测试
    public static void main(String[] args) {
        // 我这里创建一个vector来装下面1000个线程里获取的StaticInnerClassSingleton对象(ArrayList线程不安全)
        Vector<StaticInnerClassSingleton> vector = new Vector<>();

        //计数器，用于开始主线程
        CountDownLatch latch = new CountDownLatch(1000);

        for (int i = 0; i < 1000; i++) {
            new Thread(()-> {
                    //加入延迟
                    try {
                        Thread.sleep(800);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    vector.add(StaticInnerClassSingleton.getInstance());
                    latch.countDown();
            }).start();
        }

        //主线程等候
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //输出结果
        for(StaticInnerClassSingleton s : vector){
            System.out.println(s);
        }
        //经过多次测试，可以做到线程安全
    }
}
