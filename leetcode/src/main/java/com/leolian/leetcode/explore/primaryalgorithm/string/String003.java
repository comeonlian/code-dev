package com.leolian.leetcode.explore.primaryalgorithm.string;

/**
 * LC 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * 示例：
 * s = "leetcode"
 * 返回 0
 * <p>
 * s = "loveleetcode"
 * 返回 2
 * <p>
 * 提示：你可以假定该字符串只包含小写字母。
 */
public class String003 {

    public static void main(String[] args) {
        String003 string003 = new String003();

        String str = "loveleetcode";
        int firstUniqChar = string003.firstUniqChar(str);
        System.out.println(firstUniqChar);
    }

    /**
     * 自制哈希表
     *
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        int[] index = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int val = ch - 'a';
            count[val] = count[val] + 1;
            index[val] = i;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int val = ch - 'a';
            if (count[val] == 1) {
                return index[val];
            }
        }
        return -1;
    }

    /*
    执行结果：通过显示详情
    执行用时：8 ms, 在所有 Java 提交中击败了67.60%的用户
    内存消耗：38.7 MB, 在所有 Java 提交中击败了98.13%的用户
    */

    /*
    执行超时 ！！！
    if (s.trim().length() == 0) {
            return -1;
        }
        boolean[] arr = new boolean[s.length()];
        for (int i = 0; i < s.length() - 1; i++) {
            char start = s.charAt(i);
            for (int j = i + 1; j < s.length(); j++) {
                if (arr[j]) {
                    continue;
                }
                char tmp = s.charAt(j);
                if (start == tmp) {
                    if (!arr[i]) {
                        arr[i] = true;
                    }
                    arr[j] = true;
                }
            }
        }
        ;
        for (int i = 0; i < s.length(); i++) {
            if (!arr[i]) {
                return i;
            }
        }
        return -1;
    */

}
