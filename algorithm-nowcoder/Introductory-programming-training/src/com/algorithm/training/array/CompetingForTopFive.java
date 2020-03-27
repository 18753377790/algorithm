package com.algorithm.training.array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description: 争夺前五名
 * 题目描述
 * 期中考试开始了，大家都想取得好成绩，争夺前五名。从键盘输入n个学生成绩（不超过40个），输出每组排在前五高的成绩。
 *
 * 输入描述:
 * 两行，第一行输入一个整数，表示n个学生（>=5），第二行输入n个学生成绩（整数表示，范围0~100），用空格分隔。
 * 输出描述:
 * 一行，输出成绩最高的前五个，用空格分隔。
 * 
 * 示例1
 * 输入
 * 6
 * 99 45 78 67 72 88
 * 输出
 * 99 88 78 72 67
 * @Date 2020/3/23 1:17
 * @Version 1.0
 */
public class CompetingForTopFive {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println("---");
        String str = scanner.nextLine();
        String[] strings = str.split(" ");

        int[] array = new int[num];
        
        for (int i = 0; i < num; i++) {
            array[i] = Integer.parseInt(strings[i]);    
        }

        Arrays.sort(array);

        for (int i = num - 1; i > num - 5; i--) {
            System.out.print(array[i] + " ");
        }
    }
}
