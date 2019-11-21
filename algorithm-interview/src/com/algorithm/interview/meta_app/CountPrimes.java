package com.algorithm.interview.meta_app;

import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description:
 * 展心展力笔试题
 *
 * 统计质数
 * 统计所有小于非负整数n的质数的数量
 *
 * 示例：
 * 输入：10
 * 输出：4
 * 解释：小于10的质数一共有4个，它们是2,3,5,7
 *
 * 质数定义为一个大于1的自然数，并且因数只有1和它自身，不能整除其他自然数
 * @Date 2019/8/16 22:31
 * @Version 1.0
 */
public class CountPrimes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(new CountPrimes().countPrimes(n));
    }

    /**
     * 统计质数的方法
     * @param n 统计质数的范围（0~n）
     * @return 质数出现的次数
     */
    private int countPrimes(int n){
        // 如果n <= 2，则没有小于他们的质数
        if (n <= 2)
            return 0;
        // 统计质数的计数器，默认是n - 2，因为1和2
        int count = n - 2;
        // 外循环是将2~(n-1)的数字进行循环判断其是否是质数
        for (int i = 2; i < n; i++) {
            // 内循环是将外循环的每个数进行是否是质数的判断
            for (int j = 2; j <= Math.sqrt(i); j++) {
                // 如果i不是质数，则计数器减一，并中断内循环进行外循环
                if (i % j == 0){
                    count--;
                    break;
                }
            }
        }
        return count;
    }
}
