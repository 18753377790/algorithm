package com.algorithm.interview.fit2cloud;

/**
 * @Author 李非凡
 * @Description:
 * 飞致云面试题
 * 求1到100之间所有质数和
 * 质数是只能被1和它本身整除的数
 * 1不是质数
 * @Date 2019/3/31 13:31
 * @Version 1.0
 */
public class PrimeNumber {

    /**
     *
     */
    private static final int NUMBER = 100;

    public static void main(String[] args) {
        // 累加器
        int sum = 0;
        for (int i = 2; i <= NUMBER; i++) {
            for (int j = 2; j <= i; j++) {
                // 如果一个数能被除1和它本身之外的数整除，它就不是质数，循环终止
                if (i % j == 0 && i != j){
                    break;
                }
                if (i % j == 0 && i == j){
                    System.out.println(i);
                    sum += i;
                }
            }
        }
        System.out.println("sum = " + sum);
    }
}
