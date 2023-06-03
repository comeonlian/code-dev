package com.leolian.leetcode.questionbank.algorithm.page20;

import java.util.Arrays;

/**
 * LC 953 : 验证外星语词典
 * 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
 * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；
 * 否则，返回 false。
 * 提示：
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * order.length == 26
 * 在words[i]和order中的所有字符都是英文小写字母。
 * <p>
 * 示例1
 * 输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * 输出：true
 * 解释：在该语言的字母表中，'h' 位于 'l' 之前，所以单词序列是按字典序排列的。
 * <p>
 * 示例2
 * 输入：words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * 输出：false
 * 解释：在该语言的字母表中，'d' 位于 'l' 之后，那么 words[0] > words[1]，因此单词序列不是按字典序排列的。
 * <p>
 * 示例3
 * 输入：words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * 输出：false
 * 解释：当前三个字符 "app" 匹配时，第二个字符串相对短一些，然后根据词典编纂规则 "apple" > "app"，
 * 因为 'l' > '∅'，其中 '∅' 是空白字符，定义为比任何其他字符都小（更多信息）。
 */
public class LC_0953 {

    public static void main(String[] args) {
        LC_0953 lc0953 = new LC_0953();
        
        String[] words = new String[]{"zirqhpfscx","zrmvtxgelh","vokopzrtc","nugfyso","rzdmvyf","vhvqzkfqis","dvbkppw","ttfwryy","dodpbbkp","akycwwcdog"};
        String order = "khjzlicrmunogwbpqdetasyfvx";
        System.out.println(lc0953.isAlienSorted(words, order));
    }

    public boolean isAlienSorted(String[] words, String order) {
        if (words == null || words.length == 0) {
            return false;
        }
        if (words.length == 1) {
            return true;
        }
        int maxWordLength = 0;
        int maxWordIndex = -1;
        String maxWord = null;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.length() > maxWordLength) {
                maxWordLength = word.length();
                maxWordIndex = i;
                maxWord = word;
            }
        } 

        for (int i = 0; i < maxWordLength; i++) {
            char ch = maxWord.charAt(i);
            boolean hasRepeat = false;
            
            for (int j = 0; j < words.length; j++) {
                if (j == maxWordIndex) {
                    continue;
                }
                String word = words[j];
                if (word == null || word.length() == 0) {
                    continue;
                }
                char tmpCh = word.charAt(0);
                if (ch == tmpCh) {
                    words[j] = word.substring(1);
                    hasRepeat = true;
                }
            }
            if (hasRepeat) {
                words[maxWordIndex] = words[maxWordIndex].substring(1);
            } else {
                break;
            } 
        }
        System.out.println(Arrays.toString(words));
        for (int i = 0; i < 1; i++) {
            int leftPos = Integer.MIN_VALUE;
            int curPos = Integer.MIN_VALUE;
            for (String word : words) {
                int pos = 0;
                if (i < word.length()) {
                    pos = order.indexOf(word.charAt(i));
                }
                if (leftPos == Integer.MIN_VALUE) {
                    if (i < word.length()) {
                        leftPos = pos;
                    } else {
                        leftPos = -1; // 空白符
                    }
                } else {
                    if (i < word.length()) {
                        curPos = pos;
                    } else {
                        curPos = -1; // 空白符
                    }
                    if (leftPos > curPos) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
