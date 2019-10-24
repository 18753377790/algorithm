package com.algorithm.practice;

/**
 * @Author 李非凡
 * @Description:
 * 编写一个Java应用程序，输出1~100之间所有既可以被3整除，又可以7整除的数
 * @Date 2018/12/11 21:22
 * @Version 1.0
 */
public class Division {

    public static void main(String[] args) {
        for (int i = 1; i <= 100 ; i++) {
            if (i % 3 == 0 && i % 7 == 0){
                System.out.println(i);
            }
        }
    }
}
