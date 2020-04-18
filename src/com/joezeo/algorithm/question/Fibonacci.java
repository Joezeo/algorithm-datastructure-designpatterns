package com.joezeo.algorithm.question;

/**
 * 尝试斐波那契的非递归解法
 * @author Joezeo
 * @date 2020/4/18 15:30
 */
public class Fibonacci {
    public static void main(String[] args) {
        // 1,2,3,4,5,6, 7, 8, 9,10
        // 1,1,2,3,5,8,13,21,34,55
        long start = System.currentTimeMillis();
        fibonacci(50);
        long end = System.currentTimeMillis();
        System.out.println("非递归解法计算斐波那契，使用时间：" + (end-start));
        // 非递归解法计算斐波那契，使用时间：0

        start = System.currentTimeMillis();
        fibo(50);
        end = System.currentTimeMillis();
        System.out.println("递归解法计算斐波那契，使用时间：" + (end-start));
        // 递归解法计算斐波那契，使用时间：44918
    }

    // 非递归解法
    // 这里运用到了动态规划的思想
    public static int fibonacci(int n){
        if(n==1 || n==2){
            return 1;
        }

        int[] fibo = new int[n];
        fibo[0] = 1;
        fibo[1] = 1;

        for(int i=2; i<n; i++){
            fibo[i] = fibo[i-1]+fibo[i-2];
        }
        return fibo[n-1];
    }

    // 递归解法
    // 由于递归解法会循环计算很多相同的值，故效率远远比不上递归解法
    // 这种问题被称为Overlap Sub Question(重叠子问题)
    public static int fibo(int n){
        if(n==1 || n==2){
            return 1;
        }
        return fibo(n-1)+fibo(n-2);
    }
}
