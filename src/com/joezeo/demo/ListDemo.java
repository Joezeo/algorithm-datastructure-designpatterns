package com.joezeo.demo;

import java.util.ArrayList;

public class ListDemo {
    /**
     *  list在for each循环中，如果移除list的数据，对循环是否有影响
     *
     *  答案是会抛出 java.util.ConcurrentModificationException 异常
     */
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("fd");
        strings.add("fdfds");
        strings.add("fdwqwer");
        strings.add("fdfdsff");
        strings.add("fdtrega");
        strings.add("fdljf");
        strings.add("fdfdsljf");
        for(String s : strings){
            strings.remove(s);
            System.out.println(s);
        }
    }
}
