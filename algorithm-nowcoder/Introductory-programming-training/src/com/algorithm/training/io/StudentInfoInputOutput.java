package com.algorithm.training.io;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description: 学生基本信息输入输出
 * 题目描述
 * 依次输入一个学生的学号，以及3科（C语言，数学，英语）成绩，在屏幕上输出该学生的学号，3科成绩。
 *
 * 输入描述:
 * 学号以及3科成绩，学号和成绩之间用英文分号隔开，成绩之间用英文逗号隔开。
 * 输出描述:
 * 学号，3科成绩，输出格式详见输出样例。
 *
 * 示例1
 * 输入
 * 17140216;80.845,90.55,100.00
 * 输出
 * The each subject score of  No. 17140216 is 80.85, 90.55, 100.00.
 * @Date 2020/3/21 10:55
 * @Version 1.0
 */
public class StudentInfoInputOutput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        if (str == null || "".equals(str)) {
            return;
        }

        String[] strings = str.split(";");
        String[] split = strings[1].split(",");

        double[] score = new double[split.length];

        for (int i = 0; i < score.length; i++) {
            score[i] = Double.parseDouble(split[i]);
            score[i] = (double) Math.round(score[i] * 100) / 100;
            DecimalFormat df = new DecimalFormat("#0.00");
            split[i] = df.format(score[i]);
        }
        System.out.println("The each subject score of  No. " + strings[0] + " is " + split[0] +", "  + split[1] + ", " + split[2] + ".");
    }
}
