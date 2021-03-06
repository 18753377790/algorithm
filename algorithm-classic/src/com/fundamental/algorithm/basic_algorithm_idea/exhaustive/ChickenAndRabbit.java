package com.fundamental.algorithm.basic_algorithm_idea.exhaustive;

import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description:
 * 穷举算法：鸡兔同笼问题
 * @Date 2018/8/20 19:44
 * @Version 1.0
 */
public class ChickenAndRabbit {

    /**
     * 鸡的数量
     */
    private static int chicken = 0;

    /**
     * 兔子的数量
     */
    private static int rabbit = 0;

    /**
     * 穷举算法
     * @param head 鸡头数
     * @param foot 鸡腿数
     * @return 鸡数
     */
    private static int exhaustive(int head, int foot){
        int re = 0;
        for (int i = 0; i <= head; i++) {
            int j = head - i;
            if (i * 2 + j * 4 == foot){
                re = 1;
                chicken = i;
                rabbit = j;
            }
        }
        return re;
    }

    public static void main(String[] args) {
        System.out.println("穷举法求解鸡兔同笼问题:");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入头数：");
        int head = scanner.nextInt();
        System.out.println("请输入脚数：");
        int foot = scanner.nextInt();

        int re = exhaustive(head,foot);
        if (re == 1){
            System.out.println("鸡有" + chicken + "只,兔有" + rabbit + "只");
        }else {
            System.out.println("此题无解");
        }
    }
}
