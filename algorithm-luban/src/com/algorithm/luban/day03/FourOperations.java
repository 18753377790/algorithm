package com.algorithm.luban.day03;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description:
 * 四则混合运算（没有负数，没有小数，只是整数0~9之间的数字的四则混合运算）
 * 使用两个栈和一个队列实现四则混合运算，例如下面的公式：
 * (2+4*3)*2
 *
 * 实现步骤：
 * 队列：存储拆分后的内容
 * 栈：
 *  数字栈：存储数字
 *  符号栈：存储运算符（加减乘除，左右括号）
 *
 * 计算规则：
 * 依次从队列中取出内容
 * 1.遇到数字，直接存放到数字栈
 * 2.遇到运算符：
 *     如果符号栈没有内容，直接放入
 *
 * @Date 2019/4/13 16:54
 * @Version 1.0
 */
public class FourOperations {

    /**
     * 存储运算符的有限级别（key是运算符，value是优先级别）
     */
    private static HashMap<String, Integer> map = new HashMap<String, Integer>();

    /**
     * 不要将代码都写在main方法里面
     * 而是要符合面向对象编程思想，将常用的代码封装成一个方法
     * @param args
     */
    public static void main(String[] args) {
        map.put("(", 0);
        map.put(")", 0);
        map.put("+", 1);
        map.put("-", 1);
        map.put("*", 2);
        map.put("/", 2);
        //数字栈
        MyStack numStack = new MyStack();
        //符号栈
        MyStack symbolStack = new MyStack();

        Scanner input = new Scanner(System.in);
        //获取用户输入的公式
        String value = input.nextLine();

        //将公式拆分成单独的内容并存储到队列中
        MyQueue queue = getQueue(value);
        //依次从队列中取出内容
        while (queue.getSize() > 0){
            String con = queue.DeQueue().toString();
            //如果是操作数，直接放入数字栈（map中只存在+-*/四个符号，不是符号的元素就是数字）
            if (!map.containsKey(con)){
                numStack.push(Integer.parseInt(con));
                //用continue继续循环，if else要少写，少一些嵌套的层数
                continue;
            }

            //如果是符号且符号栈中没有内容，符号直接进符号栈
            if (symbolStack.getSize() == 0){
                symbolStack.push(con);
                continue;
            }

            //如果是左括号，直接入栈
            if ("(".equals(con)){
                symbolStack.push(con);
                continue;
            }

            /*
            如果是右括号，循环取出符号栈中的内容（进行运算），
             直到遇到左括号结束（右括号永远不会入符号栈，要与左括号一同消失）
             */
            if (")".equals(con)){
                while (!"(".equals(symbolStack.peek().toString())){
                    //数字栈取出2个数，符号栈取出1个符号，进行运算，运算结果放入数字栈
                    int num1 = (int)numStack.pop();
                    int num2 = (int)numStack.pop();
                    String symbol = symbolStack.pop().toString();
                    //栈为先进后出，所以，第二个出来的数是前面的，第一个出来的是后面的
                    int end = operation(num2, symbol, num1);
                    numStack.push(end);
                }
                symbolStack.pop();
                continue;
            }

            /*
            如果当前运算符级别小于等于符号栈顶的运算符（当前符号栈不能为空），
            进行运算直到当前运算符能够入栈（当前运算符大于栈顶的运算符）
             */
            while (symbolStack.getSize() > 0 && !getLevel(con, symbolStack.peek().toString())){
                //数字栈取出2个数，符号栈取出1个符号，进行运算，运算结果放入数字栈
                int num1 = (int)numStack.pop();
                int num2 = (int)numStack.pop();
                String symbol = symbolStack.pop().toString();
                //栈为先进后出，所以，第二个出来的数是前面的，第一个出来的是后面的
                int end = operation(num2, symbol, num1);
                numStack.push(end);
            }
            //当前运算符大于栈顶的运算符，可以放入符号栈
            symbolStack.push(con);
        }

        //如果队列中的数据处理完，依次将符号栈中的内容进行运算
        while (symbolStack.getSize() > 0){
            //数字栈取出2个数，符号栈取出1个符号，进行运算，运算结果放入数字栈
            int num1 = (int)numStack.pop();
            int num2 = (int)numStack.pop();
            String symbol = symbolStack.pop().toString();
            //栈为先进后出，所以，第二个出来的数是前面的，第一个出来的是后面的
            int end = operation(num2, symbol, num1);
            numStack.push(end);
        }

        System.out.println(numStack.pop());
    }

    /**
     * 将公式拆分成单独的内容并存储到队列中
     * @param value
     * @return
     */
    public static MyQueue getQueue(String value){
        MyQueue queue = new MyQueue();
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            queue.EnQueue(chars[i]);
        }
        return queue;
    }

    /**
     * 进行数学运算（开闭原则：添加开放，对修改关闭。就是说扩展一个新的功能不要去修改源代码）
     * 简单工厂模式--》反射工厂模式
     * @param num1
     * @param symbol
     * @param num2
     * @return
     */
    public static int operation(int num1, String symbol, int num2){
        switch (symbol){
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1/num2;
            default:
                return 0;
        }
    }

    /**
     * 返回2个运算符的级别比较：s1符号是否大于s2符号
     * @param s1
     * @param s2
     * @return
     */
    public static boolean getLevel(String s1, String s2){
        return map.get(s1) > map.get(s2);
    }
}
