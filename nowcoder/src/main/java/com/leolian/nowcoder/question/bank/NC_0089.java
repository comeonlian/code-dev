package com.leolian.nowcoder.question.bank;

import java.util.Stack;

/**
 * NC 89 : 字符串变形
 * <p>
 * 对于一个给定的字符串，我们需要在线性(也就是O(n))的时间里对它做一些变形。首先这个字符串中包含着一些空格，就像"Hello World"一样，
 * 然后我们要做的是把这个字符串中由空格隔开的单词反序，同时反转每个字符的大小写。比如"Hello World"变形后就变成了"wORLD hELLO"。
 * 输入描述：
 * 给定一个字符串s以及它的长度n(1≤n≤500)
 * 返回值描述：
 * 请返回变形后的字符串。题目保证给定的字符串均由大小写字母和空格构成。
 * <p>
 * 示例1:
 * 输入："This is a sample",16
 * 返回值："SAMPLE A IS tHIS"
 */
public class NC_0089 {

    public static void main(String[] args) {
        NC_0089 nc0089 = new NC_0089();

        String s = "This is a sample";
        // s = "h i "; // " I H"
        System.out.println(nc0089.trans(s, s.length()));
    }

    public String trans(String s, int n) {
        char spacce = ' ';
        String space = " ";
        Stack<String> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == spacce) {
                if (builder.length() > 0) {
                    stack.push(builder.toString());
                    builder.delete(0, builder.length());
                }
                stack.push(String.valueOf(ch));
            } else {
                builder.append(ch);
            }
        }
        if (builder.length() > 0) {
            stack.push(builder.toString());
            builder.delete(0, builder.length());
        }
        StringBuilder resBuilder = new StringBuilder();
        while (stack.size() > 0) {
            String pop = stack.pop();
            if (pop.equals(space)) {
                resBuilder.append(space);
                continue;
            }
            for (int i = 0; i < pop.length(); i++) {
                char ch = pop.charAt(i);
                if (ch >= 97) {
                    ch = (char) (ch - 32);
                } else {
                    ch = (char) (ch + 32);
                }
                resBuilder.append(ch);
            }
        }
        return resBuilder.toString();
    }

}
