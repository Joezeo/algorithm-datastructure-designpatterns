package com.joezeo.algorithm.bubblesort;

import com.joezeo.utils.ArrayUtils;

import java.util.Arrays;

/**
 * 冒泡排序
 * 时间复杂度 O(n2)
 */
public class BubbleSort {
    public static void main(String[] args) {
        //测试
        int[] arr = {21,2,99210,32,44,1123,4,0,123,-332,-42,112,123,9981,1023,6604,1,-9};
        bubbleSort(arr);
        //输出结果：[-332, -42, -9, 0, 1, 2, 4, 21, 32, 44, 112, 123, 123, 1023, 1123, 6604, 9981, 99210]
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr){
        for(int i=0; i<arr.length-1; i++){
            //冒泡算法每一次内外循环后可以确定一个最高位
            for(int j=0; j<arr.length-1-i; j++){
                if(arr[j] > arr[j+1]){//升序排序，修改符号可改变升降序方式
                    ArrayUtils.swap(arr, j, j+1);
                }
            }
        }
    }
}
