package com.joezeo.utils;

public class ArrayUtils {
    private ArrayUtils(){};

    /**
     * 数组arr，i、j下标交换数值
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j){
        //一个数^（亦或）同一个数两次，结果不变
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j]; //此时arr[j] = arr[i] ^ arr[j] ^ arr[j] = arr[i]
        arr[i] = arr[i] ^ arr[j]; //此时arr[i] = arr[i] ^ arr[j] ^ arr[i] = arr[j]
    }
}
