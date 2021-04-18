package com.leolian.data.structure.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 希尔排序算法: 交换法实现
 */
public class ShellSort1 {

    public static void main(String[] args) {
        ShellSort1 shellSort1 = new ShellSort1();

//        int[] arr = new int[]{
//                9, -1, 10, -2, 8, 4, 5, 7, 1, 3, 6, 2
//        };

        //创建要给 80000 个的随机的数组， 在我的机器是 2-3 秒，比冒泡快.
        int length = 200000;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (int) (Math.random() * length);
        }
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        shellSort1.sort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);

//        System.out.println(Arrays.toString(arr));
    }


    public void sort(int[] arr) {
        int temp;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
    }

}
