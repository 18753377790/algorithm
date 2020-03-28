package com.offer.algorithm.divergent_thinking_ability;

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
     * 1+2+3+...+n
     * An=A1+(n-1)=n
     * Sn=n(A1+An)/2=(n+n^2)/2
     * @param n n的大小
     * @return 1到n的累加和
     */
    private int Sum(int n){
        int sum = (int) Math.pow(n, 2) + n;
        // 变量为非负数时，右移1相当于除以2，左移相当于乘以2
        return sum >> 1;
    }

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n = scanner.nextInt();
        SumOneToN sum = new SumOneToN();
        System.out.println(sum.Sum(n));
    }
}
