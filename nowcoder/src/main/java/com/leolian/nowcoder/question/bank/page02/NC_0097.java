package com.leolian.nowcoder.question.bank.page02;

import java.util.*;

/**
 * NC 97 : 字符串出现次数的TopK问题
 * <p>
 * 题目描述
 * 给定一个字符串数组，再给定整数k，请返回出现次数前k名的字符串和对应的次数。
 * 返回的答案应该按字符串出现频率由高到低排序。如果不同的字符串有相同出现频率，按字典序排序。
 * 对于两个字符串，大小关系取决于两个字符串从左到右第一个不同字符的 ASCII 值的大小关系。
 * 比如"ah1x"小于"ahb"，"231"<”32“
 * 字符仅包含数字和字母
 * [要求]
 * 如果字符串数组长度为N，时间复杂度请达到O(N \log K)O(NlogK)
 * <p>
 * 示例1
 * 输入：["a","b","c","b"],2
 * 返回值：[["b","2"],["a","1"]]
 * 说明：
 * "b"出现了2次，记["b","2"]，"a"与"c"各出现1次，但是a字典序在c前面，记["a","1"]，最后返回[["b","2"],["a","1"]]
 * <p>
 * 示例2
 * 输入：["123","123","231","32"],2
 * 返回值：[["123","2"],["231","1"]]
 * 说明：
 * "123"出现了2次，记["123","2"]，"231"与"32"各出现1次，但是"231"字典序在"32"前面，记["231","1"]，最后返回[["123","2"],["231","1"]]
 * <p>
 * 示例3
 * 输入：["abcd","abcd","abcd","pwb2","abcd","pwb2","p12"],3
 * 返回值：[["abcd","4"],["pwb2","2"],["p12","1"]]
 */
public class NC_0097 {

    public static void main(String[] args) {
        NC_0097 nc0097 = new NC_0097();

        String[] num = new String[]{"abcd","abcd","abcd","pwb2","abcd","pwb2","p12"};
        int k = 3;
        String[][] topKstrings = nc0097.topKstrings(num, k);
        for (String[] arr : topKstrings) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public String[][] topKstrings(String[] strings, int k) {
        if (null == strings || strings.length == 0 || k == 0) {
            return null;
        }
        HashMap<String, Integer> hashMap = new HashMap<>();
        TreeMap<Integer, TreeSet<String>> treeMap = new TreeMap<>(Comparator.reverseOrder());
        for (String s : strings) {
            if (!hashMap.containsKey(s)) {
                Integer count = 1;
                hashMap.put(s, count);
                solve(treeMap, s, 0, count);
                continue;
            }
            Integer count = hashMap.get(s);
            hashMap.remove(s);
            hashMap.put(s, count + 1);
            solve(treeMap, s, count, count + 1);
        }
        String[][] res = new String[k][];
        int index = 0;
        outer:
        for (Map.Entry<Integer, TreeSet<String>> entry : treeMap.entrySet()) {
            Integer count = entry.getKey();
            TreeSet<String> value = entry.getValue();
            for (String s : value) {
                String[] arr = new String[2];
                arr[0] = s;
                arr[1] = String.valueOf(count);
                res[index++] = arr;
                if (index >= k)
                    break outer;
            }
        }
        return res;
    }

    public void solve(TreeMap<Integer, TreeSet<String>> treeMap,
                      String s,
                      Integer preCount,
                      Integer newCount) {
        if (preCount != 0) {
            TreeSet<String> set = treeMap.get(preCount);
            set.remove(s);
        }
        if (!treeMap.containsKey(newCount)) {
            TreeSet<String> set = new TreeSet<>(Comparator.naturalOrder());
            set.add(s);
            treeMap.put(newCount, set);
        } else {
            TreeSet<String> set = treeMap.get(newCount);
            set.add(s);
        }
    }
}
