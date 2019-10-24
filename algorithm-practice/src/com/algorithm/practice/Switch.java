package com.algorithm.practice;

import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description:
 * 设学生的学习成绩按如下的分数段判定为四个等级
 * 85~100
 * 70~84
 * 60~69
 * 0~60
 *
 * 0~9
 * 10~24
 * 25~40
 * @Date 2018/12/11 21:56
 * @Version 1.0
 */
public class Switch {

    public static void main(String[] args) {
        System.out.println("请输入分数：");
        Scanner scanner = new Scanner(System.in);
        int score = scanner.nextInt();
        int level;
        if (score>100 || score<0){
            System.out.println("无效的分数，请输入0~100之间的整数！");
            return;
        }else if (score >= 85){
            level = 1;
        }else if (score >= 70){
            level = 2;
        }else if (score >= 60){
            level = 3;
        }else {
            level = 4;
        }
        switch (level){
            case 1:
                System.out.println("A");
                break;
            case 2:
                System.out.println("B");
                break;
            case 3:
                System.out.println("C");
                break;
            default:
                System.out.println("D");
        }
    }
}
