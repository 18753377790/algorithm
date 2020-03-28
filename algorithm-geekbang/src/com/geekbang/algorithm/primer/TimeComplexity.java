package com.geekbang.algorithm.primer;

/**
 * @Author 李非凡
 * @Description:
 * 时间复杂度
 * 全称是渐进时间复杂度，表示算法的执行时间与数据规模之间的增长关系
 *
 * 大 O 时间复杂度表示法：代码执行时间随数据规模增长的变化趋势->渐进时间复杂度->时间复杂度
 * 可以省略掉系数，低阶和常量
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
     * 对数时间复杂度 O(logN)
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
        int sum1 = 0;
        int i = 1;
        for (; i < m; ++i) {
            sum1 = sum1 + i;
        }

        int sum2 = 0;
        int j = 1;
        for (; j < n; ++j) {
            sum2 = sum2 + j;
        }

        return sum1 + sum2;
    }

    /**
     * O(n)
     * n 表示数组 array 的长度
     * @param array
     * @param n
     * @param x
     * @return pos
     */
    private int find(int[] array, int n, int x) {
        int i = 0;
        int pos = -1;
        for (; i < n; ++i) {
            if (array[i] == x) {
                pos = i;
            }
        }
        return pos;
    }

    /**
     * 最好和最坏时间复杂度
     *
     * 最好情况时间复杂度就是，在最理想的情况下，执行这段代码的时间复杂度。
     * 最坏情况时间复杂度就是，在最糟糕的情况下，执行这段代码的时间复杂度。
     * 平均情况时间复杂度全称应该叫加权均时间复杂度或者期望时间复杂度。
     *
     * 最好时间复杂度：如果数组中第一个元素正好是要查找的变量 x，那就不需要继续遍历剩下的 n-1 个数据了，那时间复杂度就是 O(1)。
     * 最坏时间复杂度：如果数组中不存在变量 x，那我们就需要把整个数组都遍历一遍，时间复杂度就成了 O(n)。
     *
     * 要查找的变量 x 在数组中的位置，有 n+1 种情况：在数组的 0～n-1 位置中和不在数组中。
     * @param array
     * @param n
     * @param x
     * @return pos
     */
    private int bestAndWorstAndAverage(int[] array, int n, int x) {
        int i = 0;
        int pos = -1;
        for (; i < n; ++i) {
            if (array[i] == x) {
                pos = i;
                break;
            }
        }
        return pos;
    }

    /**
     * 均摊时间复杂度
     * 均摊时间复杂度就是一种特殊的平均时间复杂度
     *
     * 对一个数据结构进行一组连续操作中，大部分情况下时间复杂度都很低，只有个别情况下时
     * 间复杂度比较高，而且这些操作之间存在前后连贯的时序关系，这个时候，我们就可以将这
     * 一组操作放在一块儿分析，看是否能将较高时间复杂度那次操作的耗时，平摊到其他那些时
     * 间复杂度比较低的操作上。
     * 而且，在能够应用均摊时间复杂度分析的场合，一般均摊时间复杂度就等于最好情况时间复杂度。
     * @param val
     * @param n
     */
    private void insert(int val, int n) {
        /*
        array 表示一个长度为 n 的数组
        代码中的 array.length 就等于 n
         */
        int[] array = new int[n];
        int count = 0;
        if (count == array.length) {
            int sum = 0;
            for (int i = 0; i < array.length; ++i) {
                sum = sum + array[i];
            }
            array[0] = sum;
            count = 1;
        }

        array[count] = val;
        ++count;
    }

    public static void main(String[] args) {

    }
}
