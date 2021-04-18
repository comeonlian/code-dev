package com.leolian.data.structure.search;

/**
 * 插值查找
 */
public class InsertValueSearch {

    public static void main(String[] args) {
        InsertValueSearch insertValueSearch = new InsertValueSearch();

        int arr[] = {1, 8, 10, 89, 1000, 1000, 1234};

        int index = insertValueSearch.search(arr, 0, arr.length - 1, 10);
//        int index = insertValueSearch.insertValueSearch(arr, 0, arr.length - 1, 8);

        if (index == -1) {
            System.out.println("没有找到");
        } else {
            System.out.println("找到，下标为=" + index);
        }
    }

    private int search(int[] arr, int left, int right, int value) {
        System.out.println("插值查找次数~~");
        if (left > right || value < arr[0] || value > arr[arr.length - 1]) {
            return -1;
        }
        int mid = left + (right - left) * (value - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (midVal > value) {
            return search(arr, left, mid - 1, value);
        } else if (midVal < value) {
            return search(arr, mid + 1, right, value);
        } else {
            return mid;
        }
    }


    public int insertValueSearch(int[] arr, int left, int right, int findVal) {
        System.out.println("插值查找次数~~");
        //注意：findVal < arr[0] 和 findVal > arr[arr.length - 1] 必须需要
        //否则我们得到的 mid 可能越界
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }
        // 求出 mid, 自适应
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (findVal > midVal) { // 说明应该向右边递归
            return insertValueSearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) { // 说明向左递归查找
            return insertValueSearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }

}
