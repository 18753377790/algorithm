package com.algorithm.atguigu.stack;

/**
 * @Author 李非凡
 * @Description: 运算符优先级
 * @Date 2020/3/4 14:06
 * @Version 1.0
 */
public class OperatorPriority {

    /**
     * 加
     */
    private static final int ADD = 1;

    /**
     * 减
     */
    private static final int SUB = 1;

    /**
     * 乘
     */
    private static final int MUL = 2;

    /**
     * 除法
     */
    private static final int DIV = 2;

    /**
     * 根据传入的运算符返回对应的优先级数字
     * @param operator
     * @return
     */
    public static int getPriority(String operator) {
        int result = 0;
        switch (operator) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符");
                break;
        }
        return result;
    }
}
