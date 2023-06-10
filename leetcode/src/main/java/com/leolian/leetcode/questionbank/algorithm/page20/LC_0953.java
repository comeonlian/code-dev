package com.leolian.leetcode.questionbank.algorithm.page20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

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

        // "hello","leetcode" "hlabcdefgijkmnopqrstuvwxyz" -> true
        // "word","world","row" "worldabcefghijkmnpqstuvxyz" -> false
        // "apple","app" "abcdefghijklmnopqrstuvwxyz" -> false
        // "zirqhpfscx", "zrmvtxgelh", "vokopzrtc", "nugfyso", "rzdmvyf", "vhvqzkfqis", "dvbkppw", "ttfwryy", "dodpbbkp", "akycwwcdog" "khjzlicrmunogwbpqdetasyfvx" -> false
        // "pkdxziwmu","vmtxaepejwpehfczt","oyzcpokwvfzafahij","xmxwdyfsba","abdqtfznnlbbd","fpqtqynjbajajundew","qmaetdtagqzvlrigeh","mqwqptasdmfd","lnzxpmbe","nnuhbzougbew" "bhpldvigsquneymtrcjwzfxako" -> false
        // "z","apple","app" "zabcdefghijklmnopqrstuvwxy" -> false
        String[] words = new String[]{"z","apple","app"};
        String order = "zabcdefghijklmnopqrstuvwxy";
        System.out.println(lc0953.isAlienSorted(words, order));
    }

    public boolean isAlienSorted(String[] words, String order) {
        if (words == null || words.length == 0) {
            return false;
        }
        if (words.length == 1) {
            return true;
        }
        // 计算数组中最长的单词
        int maxWordLength = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.length() > maxWordLength) {
                maxWordLength = word.length();
            }
        }

        List<String> wordList = null;

        for (int i = 0; i < maxWordLength; i++) {
            if (i == 0) {
                wordList = Arrays.stream(words).collect(Collectors.toList());
            }

            ArrayList<Integer> indexList = new ArrayList<>();
            HashMap<Character, TreeSet<Integer>> map = new HashMap<>();
            for (int j = 0; j < wordList.size(); j++) {
                String word = wordList.get(j);
                if (i >= word.length()) {
                    indexList.add(-1);
                    continue;
                }
                char ch = word.charAt(i);
                if (map.containsKey(ch)) {
                    map.get(ch).add(j);
                } else {
                    TreeSet<Integer> treeSet = new TreeSet<>();
                    treeSet.add(j);
                    map.put(ch, treeSet);
                }
                int indexOf = order.indexOf(ch);
                indexList.add(indexOf);
            }
            
            boolean check = checkOrder(indexList);
            if (!check) {
                return false;
            }

            TreeSet<Integer> treeSet = new TreeSet<>();
            map.forEach((k, v) -> {
                if (v.size() > 1) {
                    treeSet.addAll(v);
                }
            });

            if (treeSet.isEmpty()) {
                break;
            }

            ArrayList<String> wordListTemp = new ArrayList<>();
            for (Integer index : treeSet) {
                wordListTemp.add(wordList.get(index));
            }
            
            wordList.clear();
            wordList.addAll(wordListTemp);
        }

        return true;
    }

    private boolean checkOrder(ArrayList<Integer> indexList) {
        int left;
        int right;
        for (int i = 1; i < indexList.size(); i++) {
            left = indexList.get(i - 1);
            right = indexList.get(i);
            if (left > right) {
                return false;
            }
        }
        return true;
    }
    
    /*
    执行用时：5 ms, 在所有 Java 提交中击败了4.23%的用户
    内存消耗：40.5 MB, 在所有 Java 提交中击败了16.71%的用户
    通过测试用例：125 / 125
    */

}
