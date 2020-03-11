package com.datastructure.stack;

import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description:TODE
 * @Date 2020/3/3 15:04
 * @Version 1.0
 */
public class ArrayStackDemo {

    public static void main(String[] args) {
        /*
         测试一下ArrayStack是否正确
         先创建一个ArrayStack对象->表示栈
         */
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        // 控制是否退出菜单
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);

        while (loop) {
            System.out.println("(show)：表示显示栈");
            System.out.println("(exit)：退出程序");
            System.out.println("(push)：表示添加数据到栈");
            System.out.println("(pop)：表示从栈取出数据");
            System.out.println("请输入你的选择：");
            key = scanner.next();
            switch (key) {
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数：");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    // 取出数据
                    try{
                        int result = stack.pop();
                        System.out.printf("出栈的数据是%d\n", result);
                    }catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}
