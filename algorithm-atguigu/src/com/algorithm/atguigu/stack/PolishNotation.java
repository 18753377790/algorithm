package com.algorithm.atguigu.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Author 李非凡
 * @Description: 波兰表示法
 * 1.使用栈实现逆波兰表达式（后缀表达式）计算器
 * 2.使用两个栈实现中缀表达式转后缀表达式
 * @Date 2020/3/3 22:46
 * @Version 1.0
 */
public class PolishNotation {

    public static void main(String[] args) {
        /*
         使用栈实现逆波兰表达式（后缀表达式）计算器
         先定义一个逆波兰表达式（后缀表达式suffixExpression/postfixExpression）
         (3+4)x5-6 => 3 4 + 5 * 6 - =>29
         (30+4)x5-6 => 30 4 + 5 * 6 - =>164
         为了方便，逆波兰表达式的数字和符号使用空格隔开
         */
        String postfixExpression = "3 4 + 5 * 6 -";
        // 4 * 5 - 8 + 60 + 8 / 2 => 4 5 * 8 - 60 + 8 2 / => 76
        String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";
        /*
        思路
        1.先将"3 4 + 5 x 6 -"放入一个ArrayList中
        2.将ArrayList传给一个方法，遍历ArrayList配合栈完成计算
         */
        List<String> list = getListString(suffixExpression);
        System.out.println("list=" + list);

        int result = calculate(list);
        System.out.println("计算的结果是=" + result);

        /*
         将中缀表达式转成后缀表达式的功能
         说明：
         1.1+((2+3)x4)-5 => 1 2 3 + 4 x + 5 -
         2.因为直接对字符串进行操作不方便，因此先将"1+(2+3)x4-5"中缀表达式对应的List
           即：将"1+((2+3)x4)-5"转换成ArrayList[1,+,(,(,2,+,3,),*,4,),-,5]
         3.将得到的中缀表达式对应的list转换成后缀表达式对应的list
           即将ArrayList[1,+,(,(,2,+,3,),*,4,),-,5]转换成ArrayList[1,2,3,+,4,*,+,5,-]
         */
        String infixExpression = "1+((2+3)*4)-5";
        List<String> infixExpressionList = toInfixExpressionList(infixExpression);
        // ArrayList [1, +, (, (, 2, +, 3, ), *, 4, ), -, 5]
        System.out.println("中缀表达式对应的List" + infixExpressionList);
        // 后缀表达式对应的list
        List<String> postfixExpressionList = parsePostfixExpressionList(infixExpressionList);
        // ArrayList[1,2,3,+,4,*,+,5,-]
        System.out.println("后缀表达式对应的List" + postfixExpressionList);
        System.out.printf("1+((2+3)x4)-5=%d\n", calculate(postfixExpressionList));
    }

    /**
     * 将一个逆波兰表达式依次将数据和运算符放入到一个ArrayList中
     * @param postfixExpression
     * @return
     */
    private static List<String> getListString(String postfixExpression) {
        // 将postfixExpression分割
        String[] split = postfixExpression.split(" ");
        // 相当于for(String str:split) list.add(str)
        return new ArrayList<>(Arrays.asList(split));
    }

    /**
     * 完成对逆波兰表达式的运算
     * 思路：
     * 1.从左至右扫描
     * 2.遇到运算符弹出栈顶元素和次顶元素，计算出值，将结果入栈
     * 3.将数字入栈
     * 4.
     * 5.
     * 6.
     * @param list
     * @return
     */
    private static int calculate(List<String> list) {
        // 创建一个栈（只需要一个栈）
        Stack<String> stack = new Stack<>();
        // 遍历list
        for (String item : list) {
            // 使用正则表达式来取出数字，匹配的是多位数（\\d+）
            if (item.matches("\\d+")) {
                // 入栈
                stack.push(item);
            }else {
                // pop出两个数并运算，然后再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int result;
                switch (item) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        result = num1 / num2;
                        break;
                    default:
                        throw new RuntimeException("运算符有误");
                }
                // 将结果result入栈
                stack.push(String.valueOf(result));
            }
        }
        // 最后留在stack中的数据就是运算结果
        return Integer.parseInt(stack.pop());
    }

    /**
     * 重点：将中缀表达式转成对应的list
     * @param infixExpression
     * @return
     */
    private static List<String> toInfixExpressionList(String infixExpression) {
        // 定义一个list，存放中缀表达式对应的内容
        List<String> list = new ArrayList<>();
        // 指针（循环变量），用于遍历中缀表达式字符串
        int i = 0;
        // 用于对多位数的拼接
        String str;
        // 每遍历到一个字符，就放入ch中
        char ch;
        do {
            // 如果ch是一个非数字，需要加入到list中
            if ((ch = infixExpression.charAt(i)) < 48 || (ch = infixExpression.charAt(i)) > 57) {
                list.add(String.valueOf(ch));
                // i需要后移
                i++;
            }else {
                // 如果是一个数字，需要考虑多位数的问题，先将str置空
                str = "";
                // ASCII码0->48,9->57
                while (i < infixExpression.length() && (ch = infixExpression.charAt(i)) >= 48 && (ch = infixExpression.charAt(i)) <= 57) {
                    // 拼接
                    str += ch;
                    i++;
                }
                list.add(str);
            }
        }while (i < infixExpression.length());
        // 扫描完毕，返回list
        return list;
    }

    /**
     * 重点：将得到的中缀表达式对应的list转换成后缀表达式对应的list
     * @param list
     * @return
     */
    private static List<String> parsePostfixExpressionList(List<String> list) {
        /*
         需要定义2个栈，但是，因为s2这个栈在整个转换过程中没有pop操作，而且后面还需要逆序输出，
         因此比较麻烦，所以不使用Stack而是直接使用List
         stack为s1
         strings为s2
         */
        Stack<String> stack = new Stack<>();
        // 存储中间结果的strings，用来代替存储中间结果的s2(stack2)
        List<String> strings = new ArrayList<>();
        // 遍历list
        for (String item : list) {
            // 如果是一个数，就加入到strings
            if (item.matches("\\d+")) {
                strings.add(item);
            }else if ("(".equals(item)) {
                stack.push(item);
            }else if (")".equals(item)) {
                // 如果是右括号")"，则依次弹出stack栈顶的运算符，并存入strings，直到遇到左括号为止，此时将这一对括号丢弃
                while (!"(".equals(stack.peek())) {
                    strings.add(stack.pop());
                }
                // 注意：将"("弹出stack，消除小括号
                stack.pop();
            }else {
                /*
                 当item的优先级小于等于栈顶运算符的优先级，
                 将stack栈顶的运算符弹出并加入到strings中，
                 再次转到与stack中新的栈顶运算符的比较。
                 问题：缺少一个比较优先级高低的方法
                 */
                while (stack.size() != 0 && OperatorPriority.getPriority(stack.peek()) >= OperatorPriority.getPriority(item)) {
                    strings.add(stack.pop());
                }
                // 需要将item压入stack中
                stack.push(item);
            }
        }

        // 将stack中剩余的运算符依次弹出并加入strings
        while (stack.size() != 0) {
            strings.add(stack.pop());
        }
        // 注意：因为是存放到一个list中，因此按顺序输出就是对应的逆波兰表达式（后缀表达式）的list
        return strings;
    }
}
