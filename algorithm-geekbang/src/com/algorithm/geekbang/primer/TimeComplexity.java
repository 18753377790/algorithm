package com.algorithm.geekbang.primer;

/**
 * @Author 李非凡
 * @Description:
 * 时间复杂度
 * 全称是渐进时间复杂度，表示算法的执行时间与数据规模之间的增长关系
 *
 * 大 O 时间复杂度表示法：代码执行时间随数据规模增长的变化趋势->渐进时间复杂度->时间复杂度
 *
 * 我们在分析一个算法、一段代码的时间复杂度的时候，也只关注循环执行次数最多的那一段代码就可以了。
 * 加法法则：总的时间复杂度就等于量级最大的那段代码的时间复杂度。
 * 乘法法则：嵌套代码的复杂度等于嵌套内外代码复杂度的乘积
 * @Date 2019/10/15 0:17
 * @Version 1.0
 */
public class TimeComplexity {

    /**
     * 常量时间复杂度
     * 3->O(1)
     * 一般情况下，只要算法中不存在循环语句、递归语句，即使有成千上万行的代码，其时间复杂度也是Ο(1)。
     */
    private void constant(){
        int i = 8;
        int j = 6;
        int sum = i + j;
    }

    /**
     * 对数时间复杂度
     * 在采用大 O 标记复杂度的时候，可以忽略系数，即 O(Cf(n)) = O(f(n))。
     * @param n
     */
    private void logarithmic(int n){
        int i = 1;
        while (i <= n) {
            i = i * 2;
        }
    }

    /**
     * 线性时间复杂度
     * 2n+2 -> O(n)
     * Constant
     * Logarithmic
     * @param n
     * @return sum
     */
    private int liner(int n){
        int sum = 0;
        int i = 1;
        for (; i <= n; ++i) {
            sum += i;
        }
        return sum;
    }

    /**
     * 平方时间复杂度
     * 2n^2+2n+3 -> O(n^2)
     * @param n
     * @return sum
     */
    private int square(int n){
        int sum = 0;
        int i = 1;
        int j = 1;
        for (; i <= n; ++i) {
            j = 1;
            for (; j <= n; ++j) {
                sum += i * j;
            }
        }
        return sum;
    }

    /**
     * O(m+n)
     * @param m
     * @param n
     * @return sum
     */
    private int cal(int m, int n) {
        int sum_1 = 0;
        int i = 1;
        for (; i < m; ++i) {
            sum_1 = sum_1 + i;
        }

        int sum_2 = 0;
        int j = 1;
        for (; j < n; ++j) {
            sum_2 = sum_2 + j;
        }

        return sum_1 + sum_2;
    }

    public static void main(String[] args) {

    }
}
