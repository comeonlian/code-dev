package com.leolian.nowcoder.question.bank;

/**
 * NC 141 : 判断回文
 * <p>
 * 描述
 * 给定一个字符串，请编写一个函数判断该字符串是否回文。如果回文请返回true，否则返回false。
 * <p>
 * 示例1
 * 输入："absba"
 * 返回值：true
 * <p>
 * 示例2
 * 输入："ranko"
 * 返回值：false
 * <p>
 * 示例3
 * 输入："yamatomaya"
 * 返回值：false
 * <p>
 * 示例4
 * 输入："a"
 * 返回值：true
 * <p>
 * 备注：
 * 字符串长度不大于1000000，且仅由小写字母组成
 */
public class NC_0141 {

    public static void main(String[] args) {
        NC_0141 nc0141 = new NC_0141();

        String s = "absba";
        System.out.println(nc0141.judge(s));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param str string字符串 待判断的字符串
     * @return bool布尔型
     */
    public boolean judge(String str) {
        if (null == str || str.length() == 0) {
            return false;
        }
        if (str.length() == 1) {
            return true;
        }
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            char startCh = str.charAt(start);
            char endCh = str.charAt(end);
            if (startCh != endCh) {
                return false;
            }
            start = start + 1;
            end = end - 1;
        }
        return true;
    }

}
