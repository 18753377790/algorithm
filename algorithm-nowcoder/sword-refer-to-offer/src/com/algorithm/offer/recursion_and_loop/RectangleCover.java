package com.algorithm.offer.recursion_and_loop;

import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description:
 * 矩形覆盖
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * @Date 2019/11/1 14:53
 * @Version 1.0
 */
public class RectangleCover {

    /**
     * 矩形覆盖
     * 1->1 1
     * 2->2 11 2
     * 3->3 111 12 21
     * 4->5 1111 112 121 211 22
     * 5->8 11111 1112 1121 1211 2111 122 212 221
     * 6->13 111111 11112 11121 11211 12111 21111 1122 1212 1221 2112 2121 2211 222
     * @param target 2*1小矩形的个数
     * @return 覆盖的方法
     */
    private int RectCover(int target) {
        if (target <= 2)
            return target;
        return RectCover(target - 1) + RectCover(target - 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        RectangleCover cover = new RectangleCover();
        System.out.println(cover.RectCover(target));
    }
}
