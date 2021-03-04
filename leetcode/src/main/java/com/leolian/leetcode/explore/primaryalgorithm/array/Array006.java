package com.leolian.leetcode.explore.primaryalgorithm.array;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * LC 两个数组的交集 II:
 * <p>
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * <p>
 * 示例 2:
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 * <p>
 * 说明：
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * <p>
 * 进阶：
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class Array006 {

    public static void main(String[] args) {
        Array006 array006 = new Array006();

        int[] nums1 = new int[]{4, 9, 5};
        int[] nums2 = new int[]{9, 4, 9, 8, 4};

        int[] intersect = array006.intersect(nums1, nums2);
        System.out.println("Result array: " + Arrays.toString(intersect));
    }


    /**
     * 哈希表法
     * 由于同一个数字在两个数组中都可能出现多次，因此需要用哈希表存储每个数字出现的次数。对于一个数字，
     * 其在交集中出现的次数等于该数字在两个数组中出现次数的最小值。
     * 首先遍历第一个数组，并在哈希表中记录第一个数组中的每个数字以及对应出现的次数，然后遍历第二个数组，
     * 对于第二个数组中的每个数字，如果在哈希表中存在这个数字，则将该数字添加到答案，并减少哈希表中该数字出现的次数。
     * 为了降低空间复杂度，首先遍历较短的数组并在哈希表中记录每个数字以及对应出现的次数，然后遍历较长的数组得到交集。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        int len = Math.min(nums1.length, nums2.length);
        Map<Integer, AtomicInteger> map = new HashMap<>(len);
        List<Integer> result = new ArrayList<>();
        if (nums1.length <= nums2.length) {
            for (int nums : nums1) {
                if (map.containsKey(nums)) {
                    map.get(nums).incrementAndGet();
                } else {
                    map.put(nums, new AtomicInteger(1));
                }
            }
            for (int nums : nums2) {
                if (map.containsKey(nums)) {
                    result.add(nums);
                    if (map.get(nums).decrementAndGet() == 0) {
                        map.remove(nums);
                    }
                }
            }
        } else {
            for (int nums : nums2) {
                if (map.containsKey(nums)) {
                    map.get(nums).incrementAndGet();
                } else {
                    map.put(nums, new AtomicInteger(1));
                }
            }
            for (int nums : nums1) {
                if (map.containsKey(nums)) {
                    result.add(nums);
                    if (map.get(nums).decrementAndGet() == 0) {
                        map.remove(nums);
                    }
                }
            }
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }
    /*
    执行结果：通过
    显示详情执行用时：4 ms, 在所有 Java 提交中击败了43.54%的用户
    内存消耗：38.7 MB, 在所有 Java 提交中击败了55.44%的用户
    */

}
