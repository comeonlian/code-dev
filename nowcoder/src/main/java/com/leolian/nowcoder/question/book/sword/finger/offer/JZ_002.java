package com.leolian.nowcoder.question.book.sword.finger.offer;

/**
 * JZ 2 : 替换空格
 * <p>
 * 题目描述
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * <p>
 * 示例1
 * 输入："We Are Happy"
 * 返回值："We%20Are%20Happy"
 */
public class JZ_002 {

    public static void main(String[] args) {
        JZ_002 jz002 = new JZ_002();

        String s = "We Are Happy ";
        System.out.println(jz002.replaceSpace(s));
    }

    /**
     * @param s string字符串
     * @return string字符串
     */
    public String replaceSpace(String s) {
        return s.replaceAll(" ", "%20");
    }

}
