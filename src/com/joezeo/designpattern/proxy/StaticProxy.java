package com.joezeo.designpattern.proxy;

/**
 * 静态代理模式中
 * 实际对象和代理对象实现同一个接口
 * 代理对象聚合实际对象（代理对象has实际对象）
 */
public class StaticProxy {
    public static void main(String[] args) {
        Subject subject = new Proxy(new RealObj());
        subject.doAction();
    }
}

/**
 * 首先是一个公共的接口
 */
interface Subject{
    void doAction();
}

class RealObj implements Subject{

    @Override
    public void doAction() {
        System.out.println("do some action~");
    }
}

class Proxy implements Subject{

    private RealObj realObj;

    public Proxy(RealObj realObj) {
        this.realObj = realObj;
    }

    @Override
    public void doAction() {
        System.out.println("执行前置操作");
        realObj.doAction();
        System.out.println("执行后置操作");
    }
}
