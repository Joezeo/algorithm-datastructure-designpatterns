package com.joezeo.designpattern.sigleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;

/**
 *
 * 懒汉式单例模式
 * 延迟加载
 * 线程不安全（需加synchronized）
 *
 */
public class LazySingleton {

    private LazySingleton() {
    }

    private static LazySingleton instance;

    /*
        对于static修饰的方法，synchronized锁的是Class对象

        普通方法，synchronized锁的是this对象
     */
    public static LazySingleton getInstance() {
        //双重判断加锁
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }

        return instance;
    }

    //测试
    public static void main(String[] args) {
        // 我这里创建一个list来装下面1000个线程里获取的LazySingleton对象
        // 错误！！list线程不安全
        // 线程安全的容器有 Vector、Stack、HashTable、Enumeration
        //List<LazySingleton> list = new ArrayList<>();
        Vector<LazySingleton> vector = new Vector<>();

        //计数器，用于开始主线程
        CountDownLatch latch = new CountDownLatch(1000);

        for (int i = 0; i < 1000; i++) {
            // 使用lambda表达式代替匿名对象的建立
            // lambda表达式：带参数变量的表达式
            // 基本形式：(参数)->{ 表达式 }
            new Thread(()-> {
                    //加入延迟
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    vector.add(LazySingleton.getInstance());
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
        for(LazySingleton l : vector){
            System.out.println(l);
        }
        //经过多次测试，可以做到线程安全
    }
}
