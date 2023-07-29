package com.leolian.leetcode.questionbank.algorithm.page02;

import java.util.Stack;

/**
 * LC 71 : 简化路径
 * 给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..）表示将目录切换到上一级（指向父目录）；
 * 两者都可以是复杂相对路径的组成部分。任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。 对于此问题，
 * 任何其他格式的点（例如，'...'）均被视为文件/目录名称。
 * 请注意，返回的 规范路径 必须遵循下述格式：
 * 始终以斜杠 '/' 开头。
 * 两个目录名之间必须只有一个斜杠 '/' 。
 * 最后一个目录名（如果存在）不能 以 '/' 结尾。
 * 此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
 * 返回简化后得到的 规范路径 。
 * 提示：
 * 1 <= path.length <= 3000
 * path 由英文字母，数字，'.'，'/' 或 '_' 组成。
 * path 是一个有效的 Unix 风格绝对路径。
 * <p>
 * 示例1
 * 输入：path = "/home/"
 * 输出："/home"
 * 解释：注意，最后一个目录名后面没有斜杠。
 * <p>
 * 示例2
 * 输入：path = "/../"
 * 输出："/"
 * 解释：从根目录向上一级是不可行的，因为根目录是你可以到达的最高级。
 * <p>
 * 示例3
 * 输入：path = "/home//foo/"
 * 输出："/home/foo"
 * 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
 * <p>
 * 示例4
 * 输入：path = "/a/./b/../../c/"
 * 输出："/c"
 */
public class LC_0071 {

    public static void main(String[] args) {
        LC_0071 lc0071 = new LC_0071();

        String path = "/assd_/..../b/../c/";
        System.out.println(lc0071.simplifyPath(path));
    }

    public static final char SLASH = '/';
    public static final String SLASH_S = "/";
    public static final String SLASH_CUR = "/.";
    public static final String SLASH_PRE = "/..";

    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return "";
        }
        Stack<String> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        char ch = path.charAt(0);
        char pre = ch;
        builder.append(ch);
        for (int i = 1; i < path.length(); i++) {
            ch = path.charAt(i);

            if (ch == SLASH && pre != SLASH) {
                String tmp = builder.toString();

                if ((SLASH_PRE).equals(tmp)) {
                    if (!stack.isEmpty())
                        stack.pop();
                } else if (!(SLASH_S).equals(tmp) && !(SLASH_CUR).equals(tmp)) {
                    stack.push(tmp);
                }

                builder.delete(0, builder.length());
                builder.append(ch);
            } else {
                if (pre == SLASH && ch == SLASH) {
                    continue;
                } else {
                    builder.append(ch);
                }
            }
            pre = ch;
        }
        String tmp = builder.toString();
        if (builder.length() > 0 && !(SLASH_S).equals(tmp) && !(SLASH_CUR).equals(tmp)) {
            if ((SLASH_PRE).equals(tmp)) {
                if (!stack.isEmpty())
                    stack.pop();
            } else {
                stack.push(tmp);
            }
            builder.delete(0, builder.length() - 1);
        }
        StringBuilder result = new StringBuilder();
        while (!stack.empty()) {
            result.insert(0, stack.pop());
        }
        if (result.length() == 0) {
            result.append(SLASH_S);
        }
        return result.toString();
    }
    
    /*
    执行用时：3 ms, 在所有 Java 提交中击败了93.17%的用户
    内存消耗：41.1 MB, 在所有 Java 提交中击败了93.70%的用户
    通过测试用例：258 / 258
    */
}
