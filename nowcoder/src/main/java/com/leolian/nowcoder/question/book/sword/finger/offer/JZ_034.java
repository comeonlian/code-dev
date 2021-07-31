package com.leolian.nowcoder.question.book.sword.finger.offer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/**
 * JZ 34 : 第一个只出现一次的字符
 * <p>
 * 题目描述
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 * <p>
 * 示例1
 * 输入："google"
 * 返回值：4
 */
public class JZ_034 {

    public static void main(String[] args) {
        JZ_034 jz034 = new JZ_034();

        String str = "google";
        System.out.println(jz034.FirstNotRepeatingChar(str));
    }

    public int FirstNotRepeatingChar(String str) {
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (map.containsKey(ch)) {
                map.get(ch).add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(ch, list);
            }
        }
        Collection<ArrayList<Integer>> values = map.values();
        Iterator<ArrayList<Integer>> iterator = values.iterator();
        int index = str.length();
        boolean hasMin = false;
        while (iterator.hasNext()) {
            ArrayList<Integer> list = iterator.next();
            if (list.size() == 1) {
                Integer idx = list.get(0);
                if (idx < index) {
                    index = idx;
                    hasMin = true;
                }
            }
        }
        return hasMin ? index : -1;
    }

}
