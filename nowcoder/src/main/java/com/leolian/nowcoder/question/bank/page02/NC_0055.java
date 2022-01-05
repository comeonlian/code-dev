package com.leolian.nowcoder.question.bank.page02;

/**
 * NC 55 : 最长公共前缀
 * <p>
 * 题目描述
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 示例1
 * 输入：["abca","abc","abca","abc","abcc"]
 * 返回值："abc"
 */
public class NC_0055 {

    public static void main(String[] args) {
        NC_0055 nc0055 = new NC_0055();

        String[] arr = new String[]{"c", "c"};
        System.out.println(nc0055.longestCommonPrefix(arr));
    }


    /**
     * @param strs string字符串一维数组
     * @return string字符串
     */
    public String longestCommonPrefix(String[] strs) {
        if (null == strs || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String result = "";
        String prefix = strs[0];
        for (int i = 0; i < strs.length; i++) {
            String val = strs[i];
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < Math.min(prefix.length(), val.length()); j++) {
                char prefixCh = prefix.charAt(j);
                char valCh = val.charAt(j);
                if (prefixCh != valCh) {
                    break;
                } else {
                    builder.append(prefixCh);
                }
            }
            result = builder.toString();
            prefix = builder.toString();
        }
        return result;
    }

}
