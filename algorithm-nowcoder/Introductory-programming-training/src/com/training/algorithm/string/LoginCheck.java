package com.training.algorithm.string;

import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description: 登录验证
 * 题目描述
 * 有个软件系统登录的用户名和密码为（用户名：admin，密码：admin），用户输入用户名和密码，判断是否登录成功。
 *
 * 输入描述:
 * 多组测试数据，每行有两个用空格分开的字符串，第一个为用户名，第二个位密码。
 * 输出描述:
 * 针对每组输入测试数据，输出为一行，一个字符串（“Login Success!”或“Login Fail!”）。
 *
 * 示例1
 * 输入
 * admin admin
 * 输出
 * Login Success!
 *
 * 示例2
 * 输入
 * admin abc
 * 输出
 * Login Fail!
 * @Date 2020/3/23 1:08
 * @Version 1.0
 */
public class LoginCheck {

    private static final String ADMIN = "admin";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strings = str.split(" ");

        if (ADMIN.equals(strings[0]) && ADMIN.equals(strings[1])) {
            System.out.println("Login Success!");
        }else {
            System.out.println("Login Fail!");
        }
    }
}
