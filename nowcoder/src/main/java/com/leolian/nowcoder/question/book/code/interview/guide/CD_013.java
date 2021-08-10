package com.leolian.nowcoder.question.book.code.interview.guide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

/**
 * CD13 : 用一个栈实现另一个栈的排序
 * <p>
 * 题目描述
 * 一个栈中元素的类型为整型，现在想将该栈从顶到底按从大到小的顺序排序，只许申请一个栈。
 * 除此之外，可以申请新的变量，但不能申请额外的数据结构。如何完成排序？
 * <p>
 * 输入描述：
 * 第一行输入一个N，表示栈中元素的个数
 * 第二行输入N个整数a(i)表示栈顶到栈底的各个元素
 * 输出描述：
 * 输出一行表示排序后的栈中栈顶到栈底的各个元素。
 * <p>
 * 示例1
 * 输入：
 * 5
 * 5 8 4 3 6
 * 输出：
 * 8 6 5 4 3
 * <p>
 * 备注：
 * 1 <= N <= 10000
 * -1000000 <=a(n)<= 1000000
 */
public class CD_013 {

    public static void main(String[] args) throws IOException {
        CD_013 main = new CD_013();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        String[] strs = bufferedReader.readLine().trim().split(" ");
        int[] array = Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            stack.push(array[i]);
        }
        Stack<Integer> resStack = sortByStack(stack);
        while (resStack.size() > 0) {
            System.out.print(resStack.pop() + " ");
        }
        System.out.println();
    }

    private static Stack<Integer> sortByStack(Stack<Integer> stackA) {
        Stack<Integer> stackB = new Stack<>();
        while (stackA.size() > 0) {
            Integer popA = stackA.pop();
            if (stackB.size() != 0 && popA < stackB.peek()) {
                while (stackB.size() > 0 && popA < stackB.peek()) {
                    Integer popB = stackB.pop();
                    stackA.push(popB);
                }
            }
            stackB.push(popA);
        }
        return stackB;
    }

}
