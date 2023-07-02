package com.leolian.leetcode.questionbank.algorithm.page08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * LC 380 : O(1) 时间插入、删除和获取随机元素
 * 实现 RandomizedSet 类：
 * RandomizedSet() 初始化 RandomizedSet 对象
 * bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
 * bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
 * int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
 * 你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。
 * 提示：
 * -2^31 <= val <= 2^31 - 1
 * 最多调用 insert、remove 和 getRandom 函数 2 * 10^5 次
 * 在调用 getRandom 方法时，数据结构中 至少存在一个 元素。
 * <p>
 * 示例1:
 * 输入:
 * ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
 * [[], [1], [2], [2], [], [1], [2], []]
 * 输出:
 * [null, true, false, true, 2, true, false, 2]
 * 解释:
 * RandomizedSet randomizedSet = new RandomizedSet();
 * randomizedSet.insert(1); // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
 * randomizedSet.remove(2); // 返回 false ，表示集合中不存在 2 。
 * randomizedSet.insert(2); // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
 * randomizedSet.getRandom(); // getRandom 应随机返回 1 或 2 。
 * randomizedSet.remove(1); // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
 * randomizedSet.insert(2); // 2 已在集合中，所以返回 false 。
 * randomizedSet.getRandom(); // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
 */
public class LC_0380 {

    public static void main(String[] args) {

        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1)); // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
        System.out.println(randomizedSet.remove(2)); // 返回 false ，表示集合中不存在 2 。
        System.out.println(randomizedSet.insert(2)); // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
        System.out.println(randomizedSet.insert(3)); // 向集合中插入 3 。返回 true 。集合现在包含 [1,2,3] 。
        System.out.println(randomizedSet.insert(4)); // 向集合中插入 4 。返回 true 。集合现在包含 [1,2,3,4] 。
        System.out.println(randomizedSet.getRandom()); // getRandom 应随机返回 1 2 3 4 。
        System.out.println(randomizedSet.remove(1)); // 从集合中移除 1 ，返回 true 。集合现在包含 [4,2,3] 。
        System.out.println(randomizedSet.insert(5)); // 向集合中插入 5 。返回 true 。集合现在包含 [4,2,3,5] 。
        System.out.println(randomizedSet.remove(2)); // 向集合中插入 5 。返回 true 。集合现在包含 [4,5,3] 。
        System.out.println(randomizedSet.getRandom()); // getRandom 应随机返回 4 5 3 。
    }

    public static class RandomizedSet {
        private Random random;
        private int size;
        private HashMap<Integer, Integer> map;
        private ArrayList<Integer> list;
        
        public RandomizedSet() {
            size = 0;
            map = new HashMap<>();
            list = new ArrayList<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            list.add(size, val);
            map.put(val, size);
            size++;
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            int removeIndex = map.get(val);
            map.remove(val);
            if (removeIndex < (size - 1)) {
                int lastVal = list.get(size - 1);
                list.set(removeIndex, lastVal);
                map.remove(lastVal);
                map.put(lastVal, removeIndex);
            }
            size--;
            return true;
        }

        public int getRandom() {
            int rand = random.nextInt(size);
            return list.get(rand);
        }
    }

    /*
     执行用时：20 ms, 在所有 Java 提交中击败了99.82%的用户
     内存消耗：87.3 MB, 在所有 Java 提交中击败了78.32%的用户
     通过测试用例：19 / 19
     */
}
