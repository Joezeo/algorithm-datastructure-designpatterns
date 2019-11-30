package com.joezeo.algorithm.quicksort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        //测试
        int[] arr = {21,2,99210,32,44,1123,4,0,123,-332,-42,112,123,9981,1023,6604,1,-9};
        quickSort(arr);
        //输出结果：[-332, -42, -9, 0, 1, 2, 4, 21, 32, 44, 112, 123, 123, 1023, 1123, 6604, 9981, 99210]
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr){
        quickSort(arr, 0, arr.length-1);
    }


    public static void quickSort(int[] arr, int low, int high){
        // 设置递归头
        if(low >= high) return;

        // 因为low，high在最后进行下一轮递归时还需要使用
        // 故定义临时变量 i=low j=high
        int i = low;
        int j = high;

        //从数组的最左边挖坑，获取基准值val，此时坑的位置为i
        int val = arr[i];
        while(i < j){
            //从数组右边找比val小的值放到数组左侧
            while(arr[j] >= val && i < j){
                j--;
            }
            //找到了比val小的值，把此值放入左边的坑中，此时坑的位置变为j
            if(i < j)
                arr[i++] = arr[j];

            //从数组左边找比val大的值放到数组左侧
            while(arr[i] <= val && i < j){
                i++;
            }
            //找到了比val大的值，把此值放入右边的坑中，此时坑的位置变为i
            if(i < j)
                arr[j--] = arr[i];
        }
        //最后把基准值放入最后的坑中（i=j）
        //此时基准值左边的数都比其小，右边的数都比其大
        arr[i] = val;

        //对基准值左侧进行快排
        quickSort(arr, low, i-1);
        //对基准值右侧进行快排
        quickSort(arr, i+1, high);
    }
}



