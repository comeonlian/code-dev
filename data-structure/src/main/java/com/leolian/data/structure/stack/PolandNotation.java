package com.leolian.data.structure.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author 80254155
 * @description:
 * @date 2021/4/14 20:38
 */
public class PolandNotation {

    public static void main(String[] args) {

        String expression = "1+((2+3)*4)-5"; // 1 2 3 + 4 * + 5 –

        PolandNotation polandNotation = new PolandNotation();
        String[] res = polandNotation.infixToSuffix(expression);
        System.out.println(Arrays.toString(res));
        int cal = polandNotation.calculate(res);
        System.out.println(cal);
    }

    /**
     * 1．从左至右扫描，将 3 和 4 压入堆栈；
     * 2．遇到+运算符，因此弹出 4 和 3（4 为栈顶元素，3 为次顶元素），计算出 3+4 的值，得 7，再将 7 入栈；
     * 3．将 5 入栈；
     * 4．接下来是×运算符，因此弹出 5 和 7，计算出 7×5=35，将 35 入栈；
     * 5．将 6 入栈；
     * 6．最后是-运算符，计算出 35-6 的值，即 29，由此得出最终结果
     *
     * @param suffix
     * @return
     */
    public int calculate(String[] suffix) {
        Stack<Integer> stack = new Stack<>();
        for (String s : suffix) {
            if (s.matches("\\d+")) {
                Integer value = Integer.valueOf(s);
                stack.push(value);
                continue;
            }
            Integer val1 = stack.pop();
            Integer val2 = stack.pop();
            if (s.equals("+")) {
                Integer res = val2 + val1;
                stack.push(res);
            } else if (s.equals("-")) {
                Integer res = val2 - val1;
                stack.push(res);
            } else if (s.equals("*")) {
                Integer res = val2 * val1;
                stack.push(res);
            } else if (s.equals("/")) {
                Integer res = val2 / val1;
                stack.push(res);
            }
        }
        return stack.pop();
    }

    /**
     * @param expression
     * @return
     */
    public String[] infixToSuffix(String expression) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            list.add(String.valueOf(expression.charAt(i)));
        }
        Stack<String> s1 = new Stack<>();
        Stack<String> s2 = new Stack<>();
        for (String item : list) {
            //如果是一个数，加入 s2
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                //如果是右括号“)”，则依次弹出 s1 栈顶的运算符，并压入 s2，直到遇到左括号为止，此时将这一对括号丢弃
                while (s1.size() != 0 && !s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                if (s1.size() != 0) {
                    s1.pop();//!!! 将 ( 弹出 s1 栈， 消除小括号
                }
            } else {
                //当 item 的优先级小于等于 s1 栈顶运算符, 将 s1 栈顶的运算符弹出并加入到 s2 中，再次转到(4.1) 与 s1 中新的栈顶运算符相比较
                //问题：我们缺少一个比较优先级高低的方法
                while (s1.size() != 0 && !s1.peek().equals("(") && getOperatorPriority(s1.peek()) >= getOperatorPriority(item)) {
                    s2.add(s1.pop());
                }
                //还需要将 item 压入栈
                s1.push(item);
            }
        }
        //将 s1 中剩余的运算符依次弹出并加入 s2
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
        String[] array = s2.toArray(new String[]{});
        return array;
    }

    public static int getOperatorPriority(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = 1;
                break;
            case "-":
                result = 1;
                break;
            case "*":
                result = 2;
                break;
            case "/":
                result = 2;
                break;
        }
        return result;
    }

}
