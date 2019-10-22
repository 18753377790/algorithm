package com.algorithm.interview.bus365;

import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description:
 * 盛威时代面试题
 *
 * @Date 2019/7/31 21:25
 * @Version 1.0
 */
public class CalculateFourOperations {

    /**
     * 四则运算
     * @return
     */
    private static String fourOperations(){
        System.out.println("请计算公式：");
        int num1 = (int) (Math.random() * 10 + 1);
        int num2 = (int) (Math.random() * 10 + 1);
        // 生成随机运算符
        char[] operators = {'+', '-', '*'};
        char operator = operators[(int) (Math.random() * 3)];
//        System.out.println(num1 + operator + num2 + " = ?");
        // 运算的结果
        int result = 0;
        if (operator == '+'){
            System.out.println(num1 + " + " + num2 + " = ?");
            result = num1 + num2;
        }else if (operator == '-'){
            System.out.println(num1 + " - " + num2 + " = ?");
            result = num1 - num2;
        }else {
            System.out.println(num1 + " * " + num2 + " = ?");
            result = num1 * num2;
        }
        System.out.println(result);
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入答案：");
        // 输入的答案
        String answer = scanner.nextLine();
        // 对比运算结果和输入答案
        if ("R".equalsIgnoreCase(answer)){
            fourOperations();
        }
        if (String.valueOf(result).equals(answer)){
            return "成功";
        }else {
            return "失败";
        }
    }

    public static void main(String[] args) {
        String result = fourOperations();
        System.out.println(result);
    }
}
