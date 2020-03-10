package com.algorithm.atguigu.queue;

import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description:TODE
 * @Date 2020/3/1 9:25
 * @Version 1.0
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {
        // 创建一个队列
        ArrayQueue queue = new ArrayQueue(3);
        // 接收用户输入
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        // 输出一个菜单
        while (loop) {
            System.out.println("s(show)：显示队列");
            System.out.println("e(exit)：退出程序");
            System.out.println("a(add)：添加数据到队列");
            System.out.println("g(get)：从队列取出数据");
            System.out.println("h(head)：查看队列头的数据");
            // 接收一个字符
            key = scanner.next().charAt(0);
            switch (key) {
                case's':
                    queue.showQueue();
                    break;
                case'a':
                    System.out.println("输入一个数：");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case'g':
                    // 取出数据
                    try{
                        int result = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", result);
                    }catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case'h':
                    // 查看队列头的数据
                    try {
                        int result = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", result);
                    }catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case'e':
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
