package com.leolian.leetcode.questionbank.algorithm.page08;


import java.util.Stack;

/**
 * LC 394 : 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * 提示：
 * 1 <= s.length <= 30
 * s 由小写英文字母、数字和方括号 '[]' 组成
 * s 保证是一个 有效 的输入。
 * s 中所有整数的取值范围为 [1, 300] 
 * <p>
 * 示例1
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * <p>
 * 示例2
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * <p>
 * 示例3
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * <p>
 * 示例4
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 */
public class LC_0394 {

    public static void main(String[] args) {
        LC_0394 lc0394 = new LC_0394();

        String s = "3[a2[c5[s]]dy]mn8[zx]";

        System.out.println(lc0394.decodeString(s));
    }

    public String decodeString(String s) {
        if (null == s || s.length() == 0) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        
        Stack<String> chStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();

        StringBuilder numBuilder = new StringBuilder();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch >= '0' && ch <= '9') {
                numBuilder.append(ch);
            } else if (ch == '[') {
                numStack.push(Integer.parseInt(numBuilder.toString()));
                numBuilder.delete(0, numBuilder.length());

                chStack.push(String.valueOf(ch));
            } else if (ch == ']') {
                while (chStack.size() > 0) {
                    String pop = chStack.pop();
                    if (pop.equals("[")) {
                        break;
                    } else {
                        builder.insert(0, pop);
                    }
                }
                String w = builder.toString();
                Integer count = numStack.pop();
                for (int j = 1; j < count; j++) {
                    builder.append(w);
                }
                chStack.push(builder.toString());
                builder.delete(0, builder.length());
            } else {
                chStack.push(String.valueOf(ch));
            }
        }
        while (chStack.size() > 0) {
            String pop = chStack.pop();
            if (pop.equals("[")) {
                break;
            } else {
                res.insert(0, pop);
            }
        }
        return res.toString();
    }

    /*
    执行用时：1 ms, 在所有 Java 提交中击败了76.57%的用户
    内存消耗：39.6 MB, 在所有 Java 提交中击败了5.01%的用户
    通过测试用例：34 / 34
    */

}
