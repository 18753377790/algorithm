package com.algorithm.offer.recursion_and_loop;

import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description:
 * 跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * @Date 2019/11/1 11:15
 * @Version 1.0
 */
public class NormalJumpFloor {

    /**
     * 跳台阶
     * 0->0
     * 1->1
     * 2->2 11 2
     * 3->3 111 12 21
     * 4->5 1111 112 121 211 22
     * 5->8 11111 1112 1121 1211 122 2111 212 221
     * 6->13 111111 11112 11121 11211 12111 1122 1212 1221 21111 2112 2121 2211 222
     * @param target 台阶的阶数
     * @return 跳法数
     */
    private int JumpFloor(int target) {
        if (target <= 2)
            return target;
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        NormalJumpFloor jumpFloor = new NormalJumpFloor();
        System.out.println(jumpFloor.JumpFloor(target));
    }
}
