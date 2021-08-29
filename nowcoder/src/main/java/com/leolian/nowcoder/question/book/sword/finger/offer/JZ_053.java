package com.leolian.nowcoder.question.book.sword.finger.offer;

import java.util.HashSet;

/**
 * JZ 53 : 表示数值的字符串
 * <p>
 * 题目描述
 * 请实现一个函数用来判断字符串str是否表示数值（包括科学计数法的数字，小数和整数）。
 * 科学计数法的数字(按顺序）可以分成以下几个部分:
 * 1.若干空格
 * 2.一个整数或者小数
 * 3.（可选）一个 'e' 或 'E' ，后面跟着一个整数(可正可负)
 * 4.若干空格
 * <p>
 * 小数（按顺序）可以分成以下几个部分：
 * 1.若干空格
 * 2.（可选）一个符号字符（'+' 或 '-'）
 * 3. 可能是以下描述格式之一:
 * 3.1 至少一位数字，后面跟着一个点 '.'
 * 3.2 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
 * 3.3 一个点 '.' ，后面跟着至少一位数字
 * 4.若干空格
 * <p>
 * 整数（按顺序）可以分成以下几个部分：
 * 1.若干空格
 * 2.（可选）一个符号字符（'+' 或 '-')
 * 3. 至少一位数字
 * 4.若干空格
 * <p>
 * 例如，字符串["+100","5e2","-123","3.1416","-1E-16"]都表示数值。
 * 但是["12e","1a3.14","1.2.3","+-5","12e+4.3"]都不是数值。
 * <p>
 * 提示:
 * 1.1 <= str.length <= 20
 * 2.str 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，空格 ' ' 或者点 '.' 。
 * 3.如果怀疑用例是不是能表示为数值的，可以使用python的print(float(str))去查看
 * <p>
 * 示例1
 * 输入："123.45e+6"
 * 返回值：true
 * <p>
 * 示例2
 * 输入："1.2.3"
 * 返回值：false
 * <p>
 * 示例3
 * 输入："."
 * 返回值：false
 * <p>
 * 示例4
 * 输入："    .2  "
 * 返回值：true
 */
public class JZ_053 {

    public static void main(String[] args) {
        JZ_053 jz053 = new JZ_053();

        String s = "92e1740e91";
        System.out.println(jz053.isNumeric(s));
    }

    public boolean isNumeric(String str) {
        if (null == str || str.length() == 0) {
            return false;
        }
        str = str.trim();
        if (str.length() == 0) {
            return false;
        }
        if (str.length() == 1) {
            if (str.charAt(0) < '0' || str.charAt(0) > '9') {
                return false;
            }
        }
        char ch;
        boolean eFlag = false, eBefore = false;
        HashSet<Character> pointSet = new HashSet<>(str.length());
        HashSet<Integer> numSet = new HashSet<>(str.length());
        HashSet<Character> eSet = new HashSet<>(str.length());
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            if (i == 0) {
                if (ch == '.') {
                    pointSet.add(ch);
                    continue;
                }
                if (ch == '+' || ch == '-') {
                    continue;
                }
                if ((ch >= '0' && ch <= '9')) {
                    numSet.add(ch - 48);
                    continue;
                }
                return false;
            }
            if (ch == '.') {
                if (pointSet.contains(ch))
                    return false;
                if (eBefore)
                    return false;
                pointSet.add(ch);
                continue;
            }
            if (ch == '+' || ch == '-') {
                if (!eFlag)
                    return false;
                continue;
            }
            if (ch == 'e' || ch == 'E') {
                if (numSet.isEmpty())
                    return false;
                if (eSet.contains(ch))
                    return false;
                eFlag = true;
                eBefore = true;
                eSet.add(ch);
                continue;
            }
            if (ch < '0' || ch > '9') {
                return false;
            }
            if (eFlag) {
                eFlag = false;
            }
            numSet.add(ch - 48);
        }
        if (eFlag) {
            return false;
        }
        if (!pointSet.isEmpty() && numSet.isEmpty()) {
            return false;
        }
        return true;
    }

}
