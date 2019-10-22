package com.algorithm.basic.algorithm.probability;

import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description:
 * 概率算法：蒙特卡罗算法求圆周率
 * @Date 2018/8/22 22:16
 * @Version 1.0
 */
public class MonteCarlo {

    /**
     * 蒙卡列罗算法
     * @param n
     * @return
     */
    private static Double monteCarlo(Integer n){
        Double x,y,Pi;
        Integer sum = 0;
        for (int i = 0; i < n; i++) {
            x = Math.random();
            y = Math.random();
            if ((x*x+y*y) <= 1){
                sum++;
            }
        }
        Pi = 4.0 * sum / n;
        return Pi;
    }

    public static void main(String[] args) {
        System.out.println("蒙特卡罗概率算法计算π");
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入点的数量：");
        Integer n = scanner.nextInt();
        Double Pi = monteCarlo(n);
        System.out.println("π=" + Pi);
    }
}
