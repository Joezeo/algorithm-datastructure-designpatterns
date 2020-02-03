package com.joezeo.algorithm.question;

/**
 * 有n步台阶，一次只能上一步或者两步，共有多少种走法
 */
public class StepQuesion {
    public static void main(String[] args) {
        int count = count(10);
        System.out.println(count);
        count = countIterator(10);
        System.out.println(count);
    }

    /**
     * 分析
     * 根本：只考虑最后一次行动是走1步还是2步
     *
     * f(1)     到达台阶1               1
     *
     * f(2)     先到台阶f(1),再走1步
     *          走2步到达               2
     *
     * f(3)     先到台阶f(2),再走1步
     *          先到台阶f(1)，再走2步    f(3) = f(1)+f(2)=3
     *
     * f(4)     先到台阶f(3),再走1步
     *          先到台阶f(2)，再走2步    f(4) = f(2)+f(3)=5
     *          ······
     * f(n)     先到台阶f(n-1),再走1步
     *          先到台阶f(n-2)，再走2步    f(n) = f(n-1)+f(n-2)
     */

    /**
     * 递归解法
     */
    public static int count(int step) {
        if (step == 1 || step == 2) {
            return step;
        }
        int count = count(step - 1) + count(step - 2);
        return count;
    }

    /**
     * 迭代解法
     */
    public static int countIterator(int step) {
        if (step == 1 || step == 2) {
            return step;
        }
        int f1 = 2; // 最后一次走1步,之前的走法总和 即递归中的count(2)
        int f2 = 1; // 最后一次走2步,之前的走法总和 即递归中的count(1)
        int total = 0;
        for (int i = 3; i <= step; i++) {
            total = f1 + f2; // 相当于count(3)
            f2 = f1; // count(2)
            f1 = total; // count(3)
        }
        return total;
    }
}

