package com.atguigu.datastructure.complexity;

/**
 * @Author 李非凡
 * @Description: 时间复杂度
 * 时间频度T(n)可以忽略
 * 常数项
 * 低次项
 * 系数
 *
 * 计算时间复杂度的方法
 * 1.用常数1代替运行时间中的所有加法常数项
 * 2.修改后的运行次数函数中，只保留最高阶项
 * 3.去掉最高阶项的系数
 *
 * 常见的时间复杂度
 * 常数阶
 * 对数阶
 * 线性阶
 * 线性对数阶
 * 平方阶
 * 立方阶
 * k次方阶
 * 指数阶
 * 阶乘阶
 * @Date 2020/3/5 2:11
 * @Version 1.0
 */
public class TimeComplexity {

    public static void main(String[] args) {
        /*
         此段代码时间频度T(n)=n+1，因为最后一次循环还需要判断一次
         f(n)=n
         T(n)/f(n)=1
         T(n)=O(f(n))=O(n)
         */
        int total = 0;
        int end = 100;
        for (int i = 1; i <= end; i++) {
            total += i;
        }
        // 直接计算，时间频度T(n)=1
        total = (1 + end) * end / 2;

        /*
         对数阶时间复杂度
         设x为执行次数
         2^x=n
         x=log2(n)=log2(1024)=10
         */
        int i = 1;
        int n = 1024;
        while (i < n) {
            i = i * 2;
        }
    }
}
