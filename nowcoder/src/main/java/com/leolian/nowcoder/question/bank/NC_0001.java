package com.leolian.nowcoder.question.bank;

/**
 * NC 1 : 大数加法
 * <p>
 * 以字符串的形式读入两个数字，编写一个函数计算它们的和，以字符串形式返回。
 * （字符串长度不大于100000，保证字符串仅由'0'~'9'这10种字符组成）
 * <p>
 * 示例1
 * 输入："1","99"
 * 返回值："100"
 * 说明：
 * 1+99=100
 */
public class NC_0001 {

    public static void main(String[] args) {
        NC_0001 nc0001 = new NC_0001();

        String s = "1";
        String t = "99";
        System.out.println(nc0001.solve(s, t));
    }

    public String solve(String s, String t) {
        if ((null == s || s.length() == 0) && (null == t || t.length() == 0)) {
            return "";
        }
        if (null == s || s.length() == 0) {
            return t;
        }
        if (null == t || t.length() == 0) {
            return s;
        }
        StringBuilder builder = new StringBuilder();
        boolean isCarry = false;
        int sLen = s.length() - 1, tLen = t.length() - 1;
        while (sLen >= 0 && tLen >= 0) {
            int val1 = s.charAt(sLen) - 48;
            int val2 = t.charAt(tLen) - 48;
            int sum = val1 + val2;
            if (isCarry) {
                sum += 1;
                isCarry = false;
            }
            if ((sum) >= 10) {
                builder.append(sum % 10);
                isCarry = true;
            } else {
                builder.append(sum);
            }
            sLen--;
            tLen--;
        }
        if (sLen >= 0) {
            while (sLen >= 0) {
                int val = s.charAt(sLen) - 48;
                if (isCarry) {
                    val += 1;
                    isCarry = false;
                }
                if (val >= 10) {
                    builder.append(val % 10);
                    isCarry = true;
                } else {
                    builder.append(val);
                }
                sLen--;
            }
        }
        if (tLen >= 0) {
            while (tLen >= 0) {
                int val = t.charAt(tLen) - 48;
                if (isCarry) {
                    val += 1;
                    isCarry = false;
                }
                if (val >= 10) {
                    builder.append(val % 10);
                    isCarry = true;
                } else {
                    builder.append(val);
                }
                tLen--;
            }
        }
        if (isCarry) {
            builder.append(1);
            isCarry = false;
        }
        return builder.reverse().toString();
    }

}
