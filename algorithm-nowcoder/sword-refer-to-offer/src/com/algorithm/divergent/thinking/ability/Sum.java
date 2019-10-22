package com.algorithm.divergent.thinking.ability;

import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description:
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * @Date 2019/8/13 20:33
 * @Version 1.0
 */
public class Sum {

    /**
     *
     * @param n
     * @return
     */
    private int sum(int n){

        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n = scanner.nextInt();
        Sum sum = new Sum();
        System.out.println(sum.sum(n));
    }
}
