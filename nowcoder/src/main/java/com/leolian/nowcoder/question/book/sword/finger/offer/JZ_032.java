package com.leolian.nowcoder.question.book.sword.finger.offer;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * JZ 32 : 把数组排成最小的数
 * <p>
 * 题目描述
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * <p>
 * 示例1
 * 输入：[3,32,321]
 * 返回值："321323"
 * 说明：
 */
public class JZ_032 {

    public static void main(String[] args) {
        JZ_032 jz032 = new JZ_032();

        int[] numbers = new int[]{9, 9, 3, 32, 321, 4, 4};
        System.out.println(jz032.PrintMinNumber(numbers));
    }

    // 定义一个新的排序规则，比较两数大小，将数组中数字按从“小”到“大”顺序排好后用字符串连接起来得到的就是最小数字
    // 新得排序规则如下：先将数字转化为字符串，然后拼接，如果ab < ba，则规定a < b，否则规定a > b。
    // 有了排序规则就可以使用排序方式将数组中数字进行排序，排好序后连接即可
    // 定义一个新的比较器，创建一个treeset，设置新得比较器，遍历数组，将每个元素存入treeset中即可
    // 将treeset中的元素拼接输出即是最小数字
    public String PrintMinNumber(int[] numbers) {
        if (null == numbers || numbers.length == 0) {
            return "";
        }
        ArrayList<Integer> list = new ArrayList<>(numbers.length);
        for (int num : numbers) {
            list.add(num);
        }
        list.sort((num1, num2) -> {
            int val1 = Integer.parseInt(String.valueOf(num1) + num2);
            int val2 = Integer.parseInt(String.valueOf(num2) + num1);
            if (val1 > val2) {
                return 1;
            } else if (val1 < val2) {
                return -1;
            }
            return 0;
        });
        String res = list.stream().map(Objects::toString).collect(Collectors.joining());
        return res;
    }

}
