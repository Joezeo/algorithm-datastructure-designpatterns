package com.joezeo.designpattern.sigleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;

/**
 *
 * 饿汉式单例模式
 * 延迟加载：无
 * 线程安全：是
 *
 */
public class HungerSingleton {

    private HungerSingleton(){
    }

    private static HungerSingleton instance = new HungerSingleton();

    public static HungerSingleton getInstance(){
        return instance;
    }

    //测试
    public static void main(String[] args) {
        // 我这里创建一个vector来装下面1000个线程里获取的HungerSingleton对象(ArrayList线程不安全)
        Vector<HungerSingleton> vector = new Vector<>();

        //计数器，用于开始主线程
        CountDownLatch latch = new CountDownLatch(1000);

        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //加入延迟
                    try {
                        Thread.sleep(800);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    vector.add(HungerSingleton.getInstance());
                    latch.countDown();
                }
            }).start();
        }

        //主线程等候
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //输出结果
        for(HungerSingleton hs : vector){
            System.out.println(hs);
        }
        //经过多次测试，可以做到线程安全
    }

}
