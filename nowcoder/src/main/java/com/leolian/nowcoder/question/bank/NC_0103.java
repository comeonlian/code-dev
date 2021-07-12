package com.leolian.nowcoder.question.bank;

/**
 * NC 103 : 反转字符串
 * <p>
 * 描述
 * 写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
 * <p>
 * 示例1
 * 输入："abcd"
 * 返回值："dcba"
 */
public class NC_0103 {

    public static void main(String[] args) {
        NC_0103 nc0103 = new NC_0103();

        String str = "abcd";
        System.out.println(nc0103.solve(str));
    }

    /**
     * 反转字符串
     *
     * @param str string字符串
     * @return string字符串
     */
    public String solve(String str) {
        if (null == str || str.length() == 0) {
            return "";
        }
        String resultStr = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            resultStr = resultStr + c;
        }
        return resultStr;
    }

}
