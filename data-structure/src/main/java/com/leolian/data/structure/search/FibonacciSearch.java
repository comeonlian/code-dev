package com.leolian.data.structure.search;

import java.util.Arrays;

/**
 * 斐波那契查找算法
 */
public class FibonacciSearch {

    private static final int FIBONACCI_ARRAY_MAX_SIZE = 30;

    public static void main(String[] args) {
        FibonacciSearch fibonacciSearch = new FibonacciSearch();

        int[] arr = {1, 8, 10, 89, 1000, 1234};

        System.out.println("index=" + fibonacciSearch.fibSearch(arr, 10));
    }

    /**
     * @param arr
     * @param findVal
     * @return
     */
    public int fibSearch(int[] arr, int findVal) {
        int length = arr.length;
        int low = 0;
        int high = arr.length - 1;
        // 构建斐波那契数组
        int[] fibonacci = fibonacci();
        int k = 0;
        while (length > fibonacci[k] - 1) {
            k++;
        }
        // 原数组扩容并填充
        arr = Arrays.copyOf(arr, fibonacci[k] - 1);
        for (int i = length; i < arr.length; i++) {
            arr[i] = arr[length - 1];
        }
        while (low <= high) {
            int mid = low + fibonacci[k - 1] - 1;
            if (findVal < arr[mid]) { // 在F[k-1]-1段
                high = mid - 1;
                k = k - 1;
            } else if (findVal > arr[mid]) { // 在F[k-2]-1段
                low = mid + 1;
                k = k - 2;
            } else {
                return Math.min(mid, high);
            }
        }
        return -1;
    }

    /**
     * 初始化斐波那契数组
     */
    public int[] fibonacci() {
        int[] arr = new int[FIBONACCI_ARRAY_MAX_SIZE];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < FIBONACCI_ARRAY_MAX_SIZE; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr;
    }

}
