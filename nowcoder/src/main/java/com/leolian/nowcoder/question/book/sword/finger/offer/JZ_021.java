package com.leolian.nowcoder.question.book.sword.finger.offer;

import java.util.Stack;

/**
 * JZ 21 : 栈的压入、弹出序列
 * <p>
 * 题目描述
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * <p>
 * 示例1
 * 输入：[1,2,3,4,5],[4,3,5,1,2]
 * 返回值：false
 */
public class JZ_021 {

    public static void main(String[] args) {
        JZ_021 jz021 = new JZ_021();

        int[] pushA = new int[]{1, 2, 3, 4, 5};
        int[] popA = new int[]{4, 5, 3, 2, 1};

        System.out.println(jz021.IsPopOrder(pushA, popA));
    }

    /**
     * 1、遍历A数组
     * 2、如果当前A中第一个元素与B数组的第一个元素不相等
     *      如果栈为空，将A中元素入栈，A数组指针往后移动
     *      如果栈不为空，再比较栈顶元素与B数组的第一个元素
     *      如果相等，则将栈顶元素出栈，B数组指针往后移动；循环同时需要判断B数组元素与当前A数组元素是否相等，如果相等再入栈，循环执行直至不相等或栈为空跳出循环
     *      如果在循环中出现B数组元素与A当前元素相等，不入栈，如果没有出现过则将A中元素入栈，A数组指针往后移动
     * 3、如果相等，则A数组指针往后移动，B数组指针往后移动
     * 4、循环执行 2）3）步骤
     * 5、跳出循环之后，如果栈中有元素，B数组指针未到末尾，需要再次循环判断栈中元素与B数组剩余元素
     * 5、最后判断栈中是否还有数据或者B数组的指针小于数组长度，如果满足返回false
     *
     * @param pushA
     * @param popA
     * @return
     */
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (null == pushA || null == popA || pushA.length == 0 || popA.length == 0) {
            return false;
        }
        if (pushA.length != popA.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int indexA = 0, indexB = 0;
        int valA, valB;
        for (; indexA < pushA.length; indexA++) {
            valA = pushA[indexA];
            valB = popA[indexB];
            if (valA == valB) {
                indexB++;
                continue;
            }
            if (stack.size() == 0) {
                stack.push(valA);
                continue;
            }
            int tempVal = popA[indexB];
            boolean flag = false;
            while (tempVal == valA || stack.peek() == tempVal) {
                stack.pop();
                indexB++;
                if (stack.size() == 0 || indexB >= (popA.length - 1)) {
                    break;
                }
                tempVal = popA[indexB];
                if (tempVal == valA) {
                    stack.push(valA);
                    flag = true;
                }
            }
            if (!flag) {
                stack.push(valA);
            }
        }
        if (stack.size() > 0 || indexB < (popA.length - 1)) {
            int tempVal = popA[indexB];
            while (stack.size() > 0 && stack.peek() == tempVal) {
                stack.pop();
                indexB++;
                if (stack.size() == 0 || indexB > (popA.length - 1)) {
                    break;
                }
                tempVal = popA[indexB];
            }
        }
        if (stack.size() > 0 || indexB <= (popA.length - 1)) {
            return false;
        }
        return true;
    }

}
