package com.leolian.leetcode.questionbank.algorithm.page06;

import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * LC 299 : 猜数字游戏
 * 你在和朋友一起玩 猜数字（Bulls and Cows）游戏，该游戏规则如下：
 * 写出一个秘密数字，并请朋友猜这个数字是多少。朋友每猜测一次，你就会给他一个包含下述信息的提示：
 * 猜测数字中有多少位属于数字和确切位置都猜对了（称为 "Bulls"，公牛），
 * 有多少位属于数字猜对了但是位置不对（称为 "Cows"，奶牛）。
 * 也就是说，这次猜测中有多少位非公牛数字可以通过重新排列转换成公牛数字。
 * 给你一个秘密数字 secret 和朋友猜测的数字 guess ，请你返回对朋友这次猜测的提示。
 * 提示的格式为 "xAyB" ，x 是公牛个数， y 是奶牛个数，A 表示公牛，B 表示奶牛。
 * 请注意秘密数字和朋友猜测的数字都可能含有重复数字。
 * <p>
 * 示例1
 * 输入：secret = "1807", guess = "7810"
 * 输出："1A3B"
 * 解释：数字和位置都对（公牛）用 '|' 连接，数字猜对位置不对（奶牛）的采用斜体加粗标识。
 * "1807"
 * |
 * "7810"
 * 示例2
 * 输入：secret = "1123", guess = "0111"
 * 输出："1A1B"
 * 解释：数字和位置都对（公牛）用 '|' 连接，数字猜对位置不对（奶牛）的采用斜体加粗标识。
 * "1123"        "1123"
 * |      or     |
 * "0111"        "0111"
 * 注意，两个不匹配的 1 中，只有一个会算作奶牛（数字猜对位置不对）。通过重新排列非公牛数字，其中仅有一个 1 可以成为公牛数字。
 */
public class LC_0299 {

    public static void main(String[] args) {
        LC_0299 lc0299 = new LC_0299();

        // 1122 2211
        // 1123 0111
        // 1807 7810
        // 1122 1222
        String secret = "1807";
        String guess = "7810";
        System.out.println(lc0299.getHint(secret, guess));
    }
    
    public static int CAL_CHAR_INT_VAL = 48;

    public static boolean isBlank(String s) {
        return s == null || s.length() == 0;
    }

    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        if (isBlank(secret) || isBlank(guess)) {
            return String.format("%dA%dB", bulls, cows);
        }
        // 秘密数字，每位数值对应下标集合
        HashMap<Integer, HashSet<Integer>> secretMap = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            int val = secret.charAt(i) - CAL_CHAR_INT_VAL;
            if (secretMap.containsKey(val)) {
                HashSet<Integer> indexSet = secretMap.get(val);
                indexSet.add(i);
            } else {
                HashSet<Integer> indexSet = new HashSet<>();
                indexSet.add(i);
                secretMap.put(val, indexSet);
            }
        }
        // 猜测数字转换成数组
        int[] arr = new int[guess.length()];
        for (int i = 0; i < guess.length(); i++) {
            arr[i] = guess.charAt(i) - CAL_CHAR_INT_VAL;
        }
        // 先计算公牛
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            if (secretMap.containsKey(val)) {
                HashSet<Integer> indexSet = secretMap.get(val);
                if (indexSet.contains(i)) {
                    // 公牛
                    bulls++;
                    indexSet.remove(i);
                    arr[i] = -1;
                }
            }
        }
        // 记录猜测数字中数值并且是母牛是否重复出现
        HashMap<Integer, AtomicInteger> guessValAppear = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            if (val != -1 && secretMap.containsKey(val)) {
                HashSet<Integer> indexSet = secretMap.get(val);
                if (!indexSet.isEmpty() && !indexSet.contains(i)) {
                    if (!guessValAppear.containsKey(val)) {
                        guessValAppear.put(val, new AtomicInteger(1));
                        cows++;
                    } else {
                        int guessValCount = guessValAppear.get(val).intValue();
                        if (guessValCount < indexSet.size()) {
                            guessValAppear.get(val).incrementAndGet();
                            cows++;
                        }
                    }
                }
            }
        }
        return String.format("%dA%dB", bulls, cows);
    }
    
    /*
    执行用时：12ms，击败9.44%使用 Java 的用户
    内存消耗：44.30MB，击败5.12%使用 Java 的用户
    */
}
