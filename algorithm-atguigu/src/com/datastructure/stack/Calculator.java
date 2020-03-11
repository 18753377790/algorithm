package com.datastructure.stack;

/**
 * @Author 李非凡
 * @Description: 计算器
 * 使用两个栈实现计算器
 *
 * 思考题：将小括号加入计算器
 * @Date 2020/3/3 17:08
 * @Version 1.0
 */
public class Calculator {

    public static void main(String[] args) {
        // 根据计算器设计思路，完成表达式的运算，如何处理多位数的问题？
        String expression = "70+2*6-4";
        // 创建2个栈，数字栈，符号栈
        ArrayStack2 numberStack = new ArrayStack2(10);
        ArrayStack2 operatorStack = new ArrayStack2(10);
        // 定义需要的相关变量
        // 用于扫描的索引
        int index = 0;
        int num1;
        int num2;
        int operator;
        int result;
        // 将每次扫描得到的char保存到ch中
        char ch = ' ';
        // 用于拼接多位数
        String keepNum = "";

        // 开始用while循环的扫描expression
        while (true) {
            // 依次得到expression中的每一个字符
            ch = expression.substring(index, index + 1).charAt(0);
            // 判断ch是什么，然后做相应的处理
            if (operatorStack.isOperator(ch)) {
                // 如果是运算符，则判断当前的符号栈是否为空，
                if (!operatorStack.isEmpty()) {
                    /*
                     如果符号栈有操作符，就进行比较，如果当前的操作符的优先级小于或者等于栈中的操作符
                     从符号栈中pop出一个符号，进行运算，将得到结果压入数字栈，然后将当前的操作符压入符号栈
                     */
                    if (operatorStack.priority(ch) <= operatorStack.priority(operatorStack.peek())) {
                        num1 = numberStack.pop();
                        num2 = numberStack.pop();
                        operator = operatorStack.pop();
                        result = numberStack.calculate(num1, num2, operator);
                        // 把运算的结果压入数字栈
                        numberStack.push(result);
                        /*
                         将当前的操作符压入符号栈
                         operatorStack.push(ch)省略，最后统一处理
                         */
                    }
                    /*
                     如果当前的操作符的优先级大于栈中的操作符，就直接入符号栈
                     operatorStack.push(ch)省略，最后统一处理
                     */
                }
                // 如果符号栈为空则直接压入符号栈
                operatorStack.push(ch);
            }else {
                /*
                如果是数字，则直接压入数字栈，根据ASCII码，应该减去48，即numberStack.push(ch - 48)

                思路分析：
                1.当处理多位数时，不能发现是一个数字就立即压入数字栈，因为它可能是多位数
                2.在处理数字时，需要向expression的表达式的index后再看一位：
                  如果是数字就继续扫描
                  如果是符号才压入栈
                3.因此需要定义一个字符串，用于拼接
                处理多位数
                 */
                keepNum += ch;

                if (index == expression.length() - 1) {
                    numberStack.push(Integer.parseInt(keepNum));
                }else {
                    /*
                    判断下一个字符是不是数字，如果是数字就继续扫描，如果是运算符则压入栈
                    注意只是看后一位，index本身的值不改变
                    */
                    if (operatorStack.isOperator(expression.substring(index + 1, index + 2).charAt(0))) {
                        // 如果后一位是运算符则入栈，注意类型转换
                        numberStack.push(Integer.parseInt(keepNum));
                        // 注意！！！，清空keepNum
                        keepNum = "";
                    }
                }
            }
            // 让index+1，并判断是否扫描到expression最后
            index++;
            if (index >= expression.length()) {
                break;
            }
        }

        /*
         当表达式扫描完毕，就顺序的从数字栈和符号栈中pop出相应的数字和符号，并运行
          如果符号栈为空，则计算到最后的结果，数字栈中只有一个数字（结果）
          相当于循环里面加了if (operatorStack.isEmpty()) break
         */
        while (!operatorStack.isEmpty()) {
            num1 = numberStack.pop();
            num2 = numberStack.pop();
            operator = operatorStack.pop();
            result = numberStack.calculate(num1, num2, operator);
            numberStack.push(result);
        }
        // 将数字栈中的最后一个数pop出来，就是结果
        System.out.printf("表达式%s = %d", expression, numberStack.pop());
    }
}
