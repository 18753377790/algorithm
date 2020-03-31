package com.fundamental.algorithm.classical_algorithm;

import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description:
 * 鸡兔同笼
 * 一个笼子里关着若干鸡和兔，从上面数共有35个头，从下面数共有94只脚，问笼中鸡和兔的数量各是多少？
 * @Date 2019/11/6 18:22
 * @Version 1.0
 */
public class ChickenAndRabbit {

    /**
     * 鸡兔同笼求解
     * 设鸡有x只，兔有y只，则
     * x+y=35
     * 2x+4y=94
     * x=23
     * y=12
     * @param head 头数
     * @param foot 脚数
     * @param chicken 鸡数
     * @param rabbit 兔数
     */
    private static void chickenAndRabbit(int head, int foot, int[] chicken, int[] rabbit) {
        rabbit[0] = (foot - 2 * head) /2;
        chicken[0] = head - rabbit[0];
    }

    public static void main(String[] args) {
        int[] chicken = {0};
        int[] rabbit = {0};

        System.out.println("鸡兔同笼问题求解！");
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入头数：");
        int head = scanner.nextInt();
        System.out.println("输入脚数：");
        int foot = scanner.nextInt();

        chickenAndRabbit(head, foot, chicken, rabbit);

        System.out.println("鸡有：" + chicken[0] + "兔有：" + rabbit[0]);
    }
}
