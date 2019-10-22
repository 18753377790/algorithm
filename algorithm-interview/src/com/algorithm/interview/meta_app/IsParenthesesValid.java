package com.algorithm.interview.meta_app;


import java.util.Scanner;
import java.util.Stack;

/**
 * @Author 李非凡
 * @Description:
 * 展心展力笔试题
 *
 * 判断括号是否对称
 * 给定一个只包括'(',')','{','}','[',']'的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 1.左括号必须用相同类型的右括号闭合
 * 2.左括号必须以正确的顺序闭合
 * 注意空字符串可被认为是有效字符串
 *
 * 示例：
 * @Date 2019/8/16 22:40
 * @Version 1.0
 */
public class IsParenthesesValid {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        IsParenthesesValid valid = new IsParenthesesValid();
        System.out.println(valid.isValid(s));
    }

    /**
     * 判断是否是有效的符号的方法
     * push是从栈顶入栈
     * peek能获取到栈顶数据不会移除栈，pop获取到栈顶数据会移除栈
     * @param s
     * @return
     */
    private boolean isValid(String s){
        // 如果字符串为空
        if (s == null || "".equals(s)){
            System.out.println("字符串不能为空！");
            return false;
        }
        int length = s.length();
        Stack<Character> stack = new Stack<Character>();
        // 存储遍历的字符
        char ch;
        // 存储字符转换后的数字
        int parentNum;
        // 记录下括号出现的次数
        int count = 0;
        for (int i = 0; i < length; i++) {
            ch = s.charAt(i);
            parentNum = whatParentheses(ch);
            // 如果parentNum < 0表示这是个左括号
            if (parentNum < 0){
                count++;
                // 左括号要放入栈中
                stack.push(ch);
                // 如果parentNum > 0表示这是个右括号
            } else if (parentNum > 0) {
                count++;
                // 如果出现右括号时栈为空，则为右括号左边没有左括号的特殊情况
                if (stack.isEmpty()){
                    return false;
                }
                // 如果parentNum加上栈顶的符号对应的数字相等，则栈顶是对应的左括号
                if (parentNum + whatParentheses(stack.peek()) == 0){
                    // 将栈顶的左括号出栈
                    stack.pop();
                }else {
                    return false;
                }
            }else {
                // 这不是一个括号，不用管
            }
        }
        // 字符串中有括号且栈最后被清空了，表示括号成对出现且有效
        return count > 0 && stack.isEmpty();
    }

    /**
     * 判断符号的方法
     * @param ch
     * @return
     */
    private static int whatParentheses(char ch){
        switch (ch){
            case '(':
                return -1;
            case '[':
                return -2;
            case '{':
                return -3;
            case ')':
                return 1;
            case ']':
                return 2;
            case '}':
                return 3;
        }
        return 0;
    }
}
