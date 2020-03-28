package com.geekbang.math.lesson3;

/**
 * @Author 李非凡
 * @Description: 舍罕王赏麦
 * 迭代法，简单来说，其实就是不断地用旧的变量值，递推计算新的变量值。
 * @Date 2020/3/14 10:12
 * @Version 1.0
 */
public class KingEnjoyWheat {

    public static void main(String[] args) {
        System.out.println(String.format("舍罕王给了这么多粒：%d", getNumberOfWheat(63)));
    }

    /**
     *
     * @param grid 放到第几格
     * @return 麦粒的总数
     */
    private static long getNumberOfWheat(int grid) {
        // 麦粒总数
        long sum = 0;
        // 当前格子里麦粒的数量
        long numberOfWheatInGrid;

        // 第一个格子里麦粒的数量
        numberOfWheatInGrid = 1;
        sum += numberOfWheatInGrid;

        // 从第二个格子进行循环，循环到第grid个格子
        for (int i = 2; i <= grid; i++) {
            // 当前格子里麦粒的数量是前一格的2倍
            numberOfWheatInGrid *= 2;
            // 累计麦粒总数
            sum += numberOfWheatInGrid;
        }

        return sum;
    }
}
