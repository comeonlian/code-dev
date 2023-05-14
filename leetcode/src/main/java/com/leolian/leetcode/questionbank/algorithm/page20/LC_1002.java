package com.leolian.leetcode.questionbank.algorithm.page20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * LC 1002 : 查找共用字符
 * 给你一个字符串数组 words ，请你找出所有在 words 的每个字符串中都出现的共用字符（ 包括重复字符），
 * 并以数组形式返回。你可以按 任意顺序 返回答案。
 * 提示：
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 100
 * words[i] 由小写英文字母组成
 * <p>
 * 示例1
 * 输入：words = ["bella","label","roller"]
 * 输出：["e","l","l"]
 * <p>
 * 示例2
 * 输入：words = ["cool","lock","cook"]
 * 输出：["c","o"]
 */
public class LC_1002 {

    public static void main(String[] args) {
        LC_1002 lc1332 = new LC_1002();

        String[] words = new String[]{"cool","lock","cook"};
        System.out.println(lc1332.commonChars(words));
    }

    public List<String> commonChars(String[] words) {
        if (words == null || words.length == 0) {
            return new ArrayList<>();
        }
        HashMap<Character, AtomicInteger> result = new HashMap<>();
        for (int i = 0; i < words[0].length(); i++) {
            char ch = words[0].charAt(i);
            if (result.containsKey(ch)) {
                result.get(ch).incrementAndGet();
            } else {
                result.put(ch, new AtomicInteger(1));
            }
        }
        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            HashMap<Character, AtomicInteger> map = new HashMap<>();
            for (int j = 0; j < word.length(); j++) {
                char ch = word.charAt(j);
                if (result.containsKey(ch)) {
                    AtomicInteger count = result.get(ch);
                    if (count.intValue() > 1) {
                        result.get(ch).decrementAndGet();
                    } else {
                        result.remove(ch);
                    }
                    if (map.containsKey(ch)) {
                        map.get(ch).incrementAndGet();
                    } else {
                        map.put(ch, new AtomicInteger(1));
                    } 
                } 
            }
            if (map.isEmpty()) {
                return new ArrayList<>();
            }
            result = map;
        }
        ArrayList<String> resultList = new ArrayList<>();
        for (Map.Entry<Character, AtomicInteger> entry : result.entrySet()) {
            AtomicInteger value = entry.getValue();
            for (int i = 0; i < value.intValue(); i++) {
                resultList.add(String.valueOf(entry.getKey()));
            }
        }
        return resultList;
    }

    /*
    执行用时：12 ms, 在所有 Java 提交中击败了8.93%的用户
    内存消耗：42.4 MB, 在所有 Java 提交中击败了5.01%的用户
    通过测试用例：83 / 83
     */
}
