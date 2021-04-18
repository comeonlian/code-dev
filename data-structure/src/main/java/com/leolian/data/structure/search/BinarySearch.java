package com.leolian.data.structure.search;

import java.util.List;

/**
 * 二分查找
 */
public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();

        int arr[] = {1, 8, 10, 89, 1000, 1000, 1234};

        int index = binarySearch.search(arr, 0, arr.length - 1, 89);

//        List<Integer> list = new ArrayList<>();
//        binarySearch.search2(list, arr, 0, arr.length - 1, 1000);
//        System.out.println(list);

        if (index == -1) {
            System.out.println("没有找到");
        } else {
            System.out.println("找到，下标为=" + index);
        }
    }

    public int search(int[] arr, int left, int right, int value) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (arr[mid] == value) {
            return mid;
        } else if (arr[mid] > value) {
            return search(arr, left, mid - 1, value);
        } else {
            return search(arr, mid + 1, right, value);
        }
    }

    public List<Integer> search2(List<Integer> list, int[] arr, int left, int right, int value) {
        if (left > right) {
            return list;
        }
        int mid = (left + right) / 2;
        if (arr[mid] == value) {
            list.add(mid);
            int temp = mid - 1;
            while (temp >= 0 && arr[temp] == value) {
                list.add(temp);
                temp -= 1;
            }
            temp = mid + 1;
            while (temp <= right && arr[temp] == value) {
                list.add(temp);
                temp += 1;
            }
            return list;
        } else if (arr[mid] > value) {
            search2(list, arr, left, mid - 1, value);
        } else {
            search2(list, arr, mid + 1, right, value);
        }
        return list;
    }

}
