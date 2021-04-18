package com.leolian.data.structure.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 归并排序算法
 */
public class MergeSort {

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();

//        int[] arr = new int[]{
//                9, -1, 10, -2, 8, 4, 5, 7, 1, 3, 6, 2
//        };

        //创建要给 80000 个的随机的数组， 在我的机器是 2-3 秒，比冒泡快.
        int length = 30000000;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (int) (Math.random() * length);
        }
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        int[] temp = new int[arr.length];
        mergeSort.sort(arr, 0, arr.length - 1, temp);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);

//        System.out.println(Arrays.toString(arr));
    }


    public void sort(int[] arr, int left, int right, int[] temp) {
        int mid = (left + right) / 2;
        if (left < right) {
            // 向左递归分解
            sort(arr, left, mid, temp);
            // 向右递归分解
            sort(arr, mid + 1, right, temp);
        }
        merge(arr, left, mid, right, temp);
    }

    /**
     * @param arr
     * @param left
     * @param mid
     * @param right
     * @param temp
     */
    public void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int leftTemp = left;
        int rightTemp = mid + 1;
        int tempIndex = 0;
        while (leftTemp <= mid && rightTemp <= right) {
            if (arr[leftTemp] < arr[rightTemp]) {
                temp[tempIndex] = arr[leftTemp];
                tempIndex += 1;
                leftTemp += 1;
            } else {
                temp[tempIndex] = arr[rightTemp];
                tempIndex += 1;
                rightTemp += 1;
            }
        }
        while (leftTemp <= mid) {
            temp[tempIndex] = arr[leftTemp];
            tempIndex += 1;
            leftTemp += 1;
        }
        while (rightTemp <= right) {
            temp[tempIndex] = arr[rightTemp];
            tempIndex += 1;
            rightTemp += 1;
        }
        // 拷贝回原数组
        tempIndex = 0;
        int leftTempIndex = left;
        while (leftTempIndex <= right) {
            arr[leftTempIndex] = temp[tempIndex];
            leftTempIndex += 1;
            tempIndex += 1;
        }
    }

}
