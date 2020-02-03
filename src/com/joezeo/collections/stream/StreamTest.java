package com.joezeo.collections.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Java8 Stream流机制
 */
public class StreamTest {
    public static void main(String[] args) {
        List<Apple> list = new ArrayList<>();
        list.add(new Apple(4.90, "red"));
        list.add(new Apple(2.32, "yellow"));
        list.add(new Apple(4.92, "green"));
        list.add(new Apple(4.90, "red"));
        list.add(new Apple(3.12, "red"));
        list.add(new Apple(4.90, "yellow"));
        list.add(new Apple(1.90, "green"));

//        List<Apple> redApples = oldWay(list);
        List<Apple> redApples = streamWay(list);
    }

    // 传统方式取出红苹果
    public static List<Apple> oldWay(List<Apple> list) {
        List<Apple> redApples = new ArrayList<>();
        for (Apple a : list) {
            if ("red".equals(a.getColor())) {
                redApples.add(a);
            }
        }
        return list;
    }

    // Stream流式编程取出红苹果
    public static List<Apple> streamWay(List<Apple> list) {
        return list.stream().filter(apple -> apple.getColor().equalsIgnoreCase("red")).collect(Collectors.toList());
    }
}
