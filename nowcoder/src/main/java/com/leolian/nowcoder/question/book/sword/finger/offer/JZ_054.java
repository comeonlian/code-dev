package com.leolian.nowcoder.question.book.sword.finger.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * JZ 54 : 字符流中第一个不重复的字符
 * <p>
 * 题目描述
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，
 * 第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 后台会用以下方式调用Insert 和 FirstAppearingOnce 函数
 * string caseout = "";
 * 1.读入测试用例字符串casein
 * 2.如果对应语言有Init()函数的话，执行Init() 函数
 * 3.循环遍历字符串里的每一个字符ch {
 * Insert(ch);
 * caseout += FirstAppearingOnce()
 * }
 * 2. 输出caseout，进行比较。
 * 返回值描述：
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 * <p>
 * 示例1
 * 输入："google"
 * 返回值："ggg#ll"
 */
public class JZ_054 {

    public static void main(String[] args) {
        JZ_054 jz054 = new JZ_054();

        String s = "google";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            jz054.Insert(ch);
            builder.append(jz054.FirstAppearingOnce());
        }
        System.out.println(builder.toString());
    }

    private int len = 1;
    private char firstch = '#';
    private HashMap<Character, Appear> map = new HashMap<>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (firstch == ch) {
            firstch = '#';
            int firstIndex = Integer.MAX_VALUE;
            for (Map.Entry<Character, Appear> entry : map.entrySet()) {
                char key = entry.getKey();
                Appear appear = entry.getValue();
                if (ch != key && appear.count == 1 && appear.index < firstIndex) {
                    firstIndex = appear.index;
                    firstch = key;
                }
            }
            if (!map.containsKey(ch)) {
                map.put(ch, new Appear(len++, 1));
            } else {
                map.get(ch).count = map.get(ch).count + 1;
            }
        } else if (firstch == '#') {
            if (!map.containsKey(ch)) {
                firstch = ch;
                map.put(ch, new Appear(len++, 1));
            } else {
                map.get(ch).count = map.get(ch).count + 1;
            }
        } else {
            if (!map.containsKey(ch)) {
                map.put(ch, new Appear(len++, 1));
            } else {
                map.get(ch).count = map.get(ch).count + 1;
            }
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        return firstch;
    }

    public class Appear {
        int index;
        int count;

        public Appear(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }
}
