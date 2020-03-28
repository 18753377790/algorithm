package com.training.algorithm.io;

import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description: 成绩输入输出
 * 题目描述
 * 输入3科成绩，然后把三科成绩输出，成绩为整数形式。
 *
 * 输入描述:
 * 一行，3科成绩，用空格分隔，范围（0~100）。
 * 输出描述:
 * 一行，把3科成绩显示出来，输出格式详见输出样例。
 *
 * 示例1
 * 输入
 * 60 80 90
 * 输出
 * score1=60,score2=80,score3=90
 * @Date 2020/3/16 17:54
 * @Version 1.0
 */
public class ScoreInputOutput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String score = scanner.nextLine();

        String[] strings = score.split(" ");

        System.out.println("score1=" + strings[0] + ",score2=" + strings[1] + ",score3=" + strings[2]);
    }
}
