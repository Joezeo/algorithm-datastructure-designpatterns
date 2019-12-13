package com.joezeo.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理
 * 实际对象和代理对象依然要实现同一个接口
 * <p>
 * 代理对象事先并没有编写，而是由程序动态生成
 * 需要编写InvocationHandler
 */
public class JdkDynamicProxy {
    public static void main(String[] args) {
        Star realStar = new RealStar();
        StarHandler handler = new StarHandler(realStar);
        Star proxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{Star.class}, handler);
        proxy.sing();
        // 实际上会调用handler的invoke方法
    }
}

/**
 * 公共接口
 */
interface Star {
    void sing();
}

/**
 * 实际对象
 */
class RealStar implements Star {

    @Override
    public void sing() {
        System.out.println("Star sings~");
    }
}

/**
 * 用于动态生成proxy代理对象的handler
 */
class StarHandler implements InvocationHandler {

    // 依然需要聚合实际对象
    private Star realStar;

    public StarHandler(Star realStar) {
        this.realStar = realStar;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("签约");
        Object res = method.invoke(realStar, args);
        System.out.println("收钱");
        return res;
    }
}


