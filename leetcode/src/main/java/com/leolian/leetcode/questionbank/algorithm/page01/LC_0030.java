package com.leolian.leetcode.questionbank.algorithm.page01;

import java.util.*;

/**
 * LC 30 : 串联所有单词的子串
 * 给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串长度相同。
 * s 中的 串联子串 是指一个包含  words 中所有字符串以任意顺序排列连接起来的子串。
 * 例如，如果words = ["ab","cd","ef"]， 那么"abcdef"，"abefcd"，"cdabef"，"cdefab"，"efabcd"， 和"efcdab" 都是串联子串。
 * "acdbef" 不是串联子串，因为他不是任何words排列的连接。
 * 返回所有串联字串在 s 中的开始索引。你可以以 任意顺序 返回答案。
 * <p>
 * 提示：
 * 1 <= s.length <= 104
 * 1 <= words.length <= 5000
 * 1 <= words[i].length <= 30
 * words[i]和s 由小写英文字母组成
 * <p>
 * 示例 1：
 * 输入：s = "barfoothefoobarman", words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：因为 words.length == 2 同时 words[i].length == 3，连接的子字符串的长度必须为 6。
 * 子串 "barfoo" 开始位置是 0。它是 words 中以 ["bar","foo"] 顺序排列的连接。
 * 子串 "foobar" 开始位置是 9。它是 words 中以 ["foo","bar"] 顺序排列的连接。
 * 输出顺序无关紧要。返回 [9,0] 也是可以的。
 * <p>
 * 示例 2：
 * 输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * 输出：[]
 * 解释：因为 words.length == 4 并且 words[i].length == 4，所以串联子串的长度必须为 16。
 * s 中没有子串长度为 16 并且等于 words 的任何顺序排列的连接。
 * 所以我们返回一个空数组。
 * <p>
 * 示例 3：
 * 输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * 输出：[6,9,12]
 * 解释：因为 words.length == 3 并且 words[i].length == 3，所以串联子串的长度必须为 9。
 * 子串 "foobarthe" 开始位置是 6。它是 words 中以 ["foo","bar","the"] 顺序排列的连接。
 * 子串 "barthefoo" 开始位置是 9。它是 words 中以 ["bar","the","foo"] 顺序排列的连接。
 * 子串 "thefoobar" 开始位置是 12。它是 words 中以 ["the","foo","bar"] 顺序排列的连接。
 */
public class LC_0030 {

    public static void main(String[] args) {
        LC_0030 lc_0030 = new LC_0030();

        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word", "good", "best", "good"};

        System.out.println(lc_0030.findSubstring(s, words));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> resultList = new ArrayList<>();
        Set<String> wordSet = new HashSet<>();
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            if (wordMap.containsKey(word)) {
                Integer value = wordMap.get(word);
                wordMap.remove(word);
                wordMap.put(word, value + 1);
            } else {
                wordMap.put(word, 1);
            }
            wordSet.add(word);
        }
        int wordLength = words[0].length();
        int totalLength = wordLength * words.length;
        for (String word : wordSet) {
            int startIndex = 0;
            while (startIndex >= 0 && startIndex <= s.length()) {
                int index = s.indexOf(word, startIndex);
                if (index < 0) {
                    startIndex = -1;
                    continue;
                }
                startIndex = index + 1;
                String totalStr = s.substring(index, Math.min((index + totalLength), s.length()));
                if (totalStr.length() == totalLength) {
                    Map<String, Integer> decrementMap = new HashMap<>(wordMap);
                    for (int i = 0; i < totalLength; i = i + wordLength) {
                        String wordVal = totalStr.substring(i, i + wordLength);
                        if (decrementMap.containsKey(wordVal)) {
                            Integer value = decrementMap.get(wordVal);
                            decrementMap.remove(wordVal);
                            decrementMap.put(wordVal, value - 1);
                        }
                    }
                    boolean flag = true;
                    for (Map.Entry<String, Integer> entry : decrementMap.entrySet()) {
                        if (entry.getValue() != 0) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        resultList.add(index);
                    }
                }
            }
        }
        return resultList;
    }
    /*
    执行用时：188 ms, 在所有 Java 提交中击败了28.59%的用户
    内存消耗：42.8 MB, 在所有 Java 提交中击败了5.19%的用户 
    */
}
