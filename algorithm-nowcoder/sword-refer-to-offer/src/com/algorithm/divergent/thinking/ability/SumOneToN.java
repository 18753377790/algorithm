package com.algorithm.divergent.thinking.ability;

import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description:
 * 求1+2+3+...+n
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * @Date 2019/8/13 20:33
 * @Version 1.0
 */
public class SumOneToN {

    /**
     * 求1到n的累加和
     * @param n n的大小
     * @return 1到n的累加和
     */
    private int Sum(int n){

        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n = scanner.nextInt();
        SumOneToN sum = new SumOneToN();
        System.out.println(sum.Sum(n));
    }
}
