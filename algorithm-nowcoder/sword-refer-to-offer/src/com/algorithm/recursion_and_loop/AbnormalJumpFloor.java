package com.algorithm.recursion_and_loop;

import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description:
 * 变态跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @Date 2019/11/1 13:59
 * @Version 1.0
 */
public class AbnormalJumpFloor {

    /**
     * 变态跳台阶
     * 0->0
     * 1->1 1
     * 2->2 11 2
     * 3->4 111 12 21 3
     * 4->8 1111 112 121 211 22 13 31 4
     * 5->15 11111 1112 1121 1211 122 2111 212 221 113 131 311 14 41 23 5
     * 6->
     * @param target 台阶的阶数
     * @return 跳法数
     */
    private int JumpFloorII(int target) {
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
    }
}
