package com.fundamental.algorithm.lb.base;

/**
 * @Author 李非凡
 * @Description:
 * 时间复杂度
 * 时间复杂度常用大O符号表述
 * 主要分为三种：
 * 1.常数型
 * 2.线性型
 * 3.对数型
 * 平方型
 * @Date 2019/5/18 15:56
 * @Version 1.0
 */
public class TimeComplexity {

    public static void main(String[] args) {
        //O(1)
        int n = 0;
        //O(1)
        int a = n+1;
        //O(100) => O(1)
        for (int i = 0; i < 100; i++) {
            //
        }

        //线性型
//        int m;
        //O(m)
//        for (int i = 0; i < m; i++) {
//
//        }

        //对数型nlog(n)快速排序
        int c = 1;
        for (int i = 0; i < n; i++) {
            while (c < n){
                c = c * 2;
            }
        }
        //c^2=n  c=log2^n; 2 => log(n)

        //平方型
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

            }
        }

        //O(n^2)
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

            }
        }
    }
}
