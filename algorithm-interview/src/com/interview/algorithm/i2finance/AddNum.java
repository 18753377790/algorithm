package com.interview.algorithm.i2finance;

import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description:
 * 艾融软件笔试题
 *
 * 求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。
 * 例如2+22+222+2222+22222
 * (此时 共有5个数相加)，几个数相加有键盘控制。
 * @Date 2019/8/17 8:08
 * @Version 1.0
 */
public class AddNum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入a");
        int a = scanner.nextInt();
        System.out.println("输入n");
        int n  = scanner.nextInt();
        System.out.println("sum=" + addNum(a, n));
    }

    /**
     * 累加的方法
     * @param a 加数
     * @param n 几个数相加
     * @return sum
     */
    private static int addNum(int a, int n){
        // 累加器
        int sum = 0;
        // 存尾数（个位数）
        int b = a;
        // 循环相加得到最大的那个数
        for (int i = 0; i < n; i++) {
            // 累加求和
            sum += a;
            // 前移一位
            a = a * 10;
            // 加尾数（个位数）
            a += b;
        }
        return sum;
    }
}
