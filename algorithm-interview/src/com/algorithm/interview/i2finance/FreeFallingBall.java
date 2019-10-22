package com.algorithm.interview.i2finance;

/**
 * @Author 李非凡
 * @Description:
 * 艾融软件笔试题
 *
 * 一球从100米高度自由落下，每次落地后反跳回原高度的一半,再落下，
 * 求它在第10次落地时，共经过多少米？
 * 第10次反弹多高？
 *
 * 299.707031
 * 0.097656
 * @Date 2019/8/17 11:08
 * @Version 1.0
 */
public class FreeFallingBall {

    public static void main(String[] args) {
        // 反弹的高度，初始值为100
        double height = 100;
        // 经过的高度，初始值为100
        double total = 100;
        // 循环9次，计算第一次落地到第九次落地再弹起小球经过多少米
        for (int i = 1; i < 10; i++) {
            height = height / 2;
            total += height * 2;
        }
        height = height / 2;
        System.out.println("第10次落地时，共经过多少" + total + "第10次反弹" + height);
    }
}
