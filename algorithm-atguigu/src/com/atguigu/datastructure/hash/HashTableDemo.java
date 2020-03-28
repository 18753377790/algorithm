package com.atguigu.datastructure.hash;

import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description: 哈希表演示
 * @Date 2020/3/7 19:13
 * @Version 1.0
 */
public class HashTableDemo {

    public static void main(String[] args) {
        // 创建哈希表
        HashTable hashTable = new HashTable(7);

        Scanner scanner = new Scanner(System.in);

        // 构建简易菜单
        while (true) {
            System.out.println("add：添加雇员");
            System.out.println("list：显示雇员");
            System.out.println("find：查找雇员");
            System.out.println("exit：退出系统");
            String key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    // 创建雇员结点
                    Employee employee = new Employee(id, name);
                    hashTable.add(employee);
                    break;
                case "list":
                    hashTable.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的id");
                    id = scanner.nextInt();
                    hashTable.findEmployeeById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
}
