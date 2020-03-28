package com.geekbang.math.lesson4;

/**
 * @Author 李非凡
 * @Description:TODE
 * @Date 2020/3/23 20:50
 * @Version 1.0
 */
public class KingEnjoyWheat {

    public static void main(String[] args) {
        int grid = 63;
        long start;
        long end;
        start = System.currentTimeMillis();
//        System.out.println(String.format("舍罕王给了这么多粒：%d", com.math.lesson3.KingEnjoyWheat.getNumberOfWheat(grid)));
        end = System.currentTimeMillis();
        System.out.println(String.format("耗时%d毫秒", (end - start)));

        start = System.currentTimeMillis();
        System.out.println(String.format("舍罕王给了这么多粒：%d", (long)(Math.pow(2, grid)) - 1));
        end = System.currentTimeMillis();
        System.out.println(String.format("耗时%d毫秒", (end - start)));
    }
}
