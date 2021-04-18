package com.leolian.data.structure.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 快速排序算法
 */
public class QuickSort {

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();

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

        quickSort.sort(arr, 0, arr.length - 1);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);

//        System.out.println(Arrays.toString(arr));
    }


    public void sort(int[] arr, int leftIndex, int rightIndex) {
        int left = leftIndex;
        int right = rightIndex;
        int pivot = arr[(left + right) / 2];
        while (left < right) {
            while (arr[left] < pivot) {
                left += 1;
            }
            while (arr[right] > pivot) {
                right -= 1;
            }
            if (left >= right) {
                break;
            }

            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            if (arr[left] == pivot) {
                right -= 1;
            }
            if (arr[right] == pivot) {
                left += 1;
            }
        }
        if (left == right) {
            left += 1;
            right -= 1;
        }
        // 向左递归
        if (leftIndex < right) {
            sort(arr, leftIndex, right);
        }
        // 向右递归
        if (rightIndex > left) {
            sort(arr, left, rightIndex);
        }
    }

}
