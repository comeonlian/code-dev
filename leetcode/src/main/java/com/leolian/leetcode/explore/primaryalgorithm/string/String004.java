package com.leolian.leetcode.explore.primaryalgorithm.string;

/**
 * LC 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * <p>
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class String004 {

    public static void main(String[] args) {
        String004 string004 = new String004();

        String s = "rat";
        String t = "car";

        boolean anagram = string004.isAnagram(s, t);
        System.out.println(anagram);
    }

    /**
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] chs = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            int indexS = cs - 'a';
            chs[indexS] = chs[indexS] + 1;
        }
        for (int i = 0; i < t.length(); i++) {
            char ct = t.charAt(i);
            int indexT = ct - 'a';
            chs[indexT] = chs[indexT] - 1;
            if (chs[indexT] < 0) {
                return false;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (chs[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /*
    1、参考解法
        if (s.length() != t.length()) {
            return false;
        }
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        Arrays.sort(chs);
        Arrays.sort(cht);
        return Arrays.equals(chs, cht);

    2、初始解法
        if (s.length() != t.length()) {
            return false;
        }
        int[] chs = new int[26];
        int[] cht = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            int indexS = cs - 'a';
            chs[indexS] = chs[indexS] + 1;
            char ct = t.charAt(i);
            int indexT = ct - 'a';
            cht[indexT] = cht[indexT] + 1;
        }
        for (int i = 0; i < 26; i++) {
            if (chs[i] != cht[i]) {
                return false;
            }
        }
        return true;

        执行结果：通过显示详情
        执行用时：6 ms, 在所有 Java 提交中击败了33.77%的用户
        内存消耗：38.6 MB, 在所有 Java 提交中击败了70.79%的用户
    3、执行上述算法优化
        if (s.length() != t.length()) {
            return false;
        }
        int[] chs = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            int indexS = cs - 'a';
            chs[indexS] = chs[indexS] + 1;
        }
        for (int i = 0; i < t.length(); i++) {
            char ct = t.charAt(i);
            int indexT = ct - 'a';
            chs[indexT] = chs[indexT] - 1;
            if (chs[indexT] < 0) {
                return false;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (chs[i] != 0) {
                return false;
            }
        }
        return true;

        执行结果：通过显示详情
        执行用时：4 ms, 在所有 Java 提交中击败了63.68%的用户
        内存消耗：38.9 MB, 在所有 Java 提交中击败了35.28%的用户
    */

}
