package com.leolian.nowcoder.question.company.shopee;

public class InterviewCase {


    public static void main(String[] args) {
        int[] array = {4, 5, 6, 7, 0, 1, 2};
        int k = 3;
        int x = 1;
        int res = search(array, 3, 1);
        System.out.println(res);
    }

    public static int search(int[] array, int k, int x) {
        int start = 0;
        int end = array.length - k;
        int index = binarySearch(array, start, end, x);
        if (index != -1) {
            return index;
        }
        start = end + 1;
        end = array.length - 1;
        return binarySearch(array, start, end, x);
    }


    public static int binarySearch(int[] array, int start, int end, int val) {
        int mid = (start + end) / 2;
        if (val < array[mid]) {
            binarySearch(array, start, mid - 1, val);
        } else if (val > array[mid]) {
            binarySearch(array, mid + 1, end, val);
        } else {
            if (start <= end) {
                return start;
            }
            return -1;
        }
        return -1;
    }

}