package com.algorithm.luban.day02;

/**
 * @Author 李非凡
 * @Description:
 * 扩展知识
 * 值类型和引用类型
 * 值类型：在栈中存储数据，赋值的过程是复制数据的过程
 * 引用类型：在栈中存储对象引用，在堆中存储对象，赋值的过程是复制地址的过程
 * 栈：先进后出，读写速度快，但是存储数据量小
 * 堆：靠地址寻找数据，容量大，但是读写速度比栈慢
 * @Date 2019/4/11 17:54
 * @Version 1.0
 */
public class DataType {

    public static void main(String[] args) {
        //值类型
//        int a = 10;
//        int b = 20;
//        a = b;
//        a = 30;
//        System.out.println(a + "--" + b);

        //引用类型
//        A a1 = new A();
//        a1.num = 10;
//        A a2 = new A();
//        a2.num = 20;
//        a1 = a2;//此时把a2的地址赋值给a1
//        a1.num = 30;//此时改变的是a1和a2共同指向的num的大小
//        System.out.println(a1.num + "--" + a2.num);

        String a = "a";
        String b = "b";
        a = b;
        a = "s";//字符串池
        System.out.println(a + "--" + b);
    }
}

/**
 *
 */
class A{
    public int num;
}
