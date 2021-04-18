package com.leolian.data.structure.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 基数排序算法
 */
public class RadixSort {

    public static void main(String[] args) {
        RadixSort radixSort = new RadixSort();

//        int[] arr = new int[]{
//                973463585, 53, 3, 542, 748, 14, 214, 7454
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

        radixSort.sort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);

//        System.out.println(Arrays.toString(arr));
    }


    private void sort(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        // 最大的位数
        int maxBit = String.valueOf(max).length();
        // 桶的大小
        int[][] bucket = new int[10][arr.length];
        // 每个桶存放数据量大小
        int[] bucketLength = new int[10];

        for (int loop = 0, divideVal = 1; loop < maxBit; loop++, divideVal *= 10) {
            // 数据入桶
            for (int i = 0; i < arr.length; i++) {
                int bitVal = arr[i] / divideVal % 10;
                bucket[bitVal][bucketLength[bitVal]] = arr[i];
                bucketLength[bitVal] += 1;
            }
            int arrIndex = 0;
            for (int i = 0; i < bucketLength.length; i++) {
                int length = bucketLength[i];
                if (length > 0) {
                    for (int j = 0; j < length; j++) {
                        arr[arrIndex] = bucket[i][j];
                        arrIndex += 1;
                    }
                }
                bucketLength[i] = 0;
            }
        }
    }

}
