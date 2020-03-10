package com.algorithm.atguigu.recursion;

/**
 * @Author 李非凡
 * @Description: 递归
 * 递归调用规则：
 * 1.当程序执行到一个方法时，就会开辟一个独立的空间（虚拟机栈）
 * 2.每个空间（方法）的数据（局部变量）是独立的，不会相互影响
 * 3.如果方法中使用的是引用类型变量（比如数组），就会共享该引用类型的数据
 * 4.递归必须向退出递归的条件逼近，否则会无限递归，出现栈溢出（StackOverflowError）
 * 5.当一个方法执行完毕，或者遇到return，就会返回。
 *   遵守谁调用，就将结果返回给谁，同时当方法执行完毕或返回时，该方法也就执行完毕
 *
 * 递归的应用：
 * 1.各种数学问题如：八皇后问题，汉诺塔，阶乘问题，迷宫问题，球和篮子的问题（Google编程大赛）
 * 2.各种算法如：快速排序，归并排序，二分查找，分治算法
 * 3.将用栈解决的问题用递归解决，递归的代码比较简洁
 * @Date 2020/3/4 16:23
 * @Version 1.0
 */
public class RecursionTest {

    public static void main(String[] args) {
        // 通过打印问题回顾递归调用机制
        print(4);
        // 打印问题加上else
        test(4);
        // 阶乘问题
        int result = factorial(5);
        System.out.println("result=" + result);
    }

    /**
     * 打印问题
     * 执行顺序
     * main:print(4)
     * n=4:if(n > 2) print(3)
     * n=3:if(n > 2) print(2)
     * n=2:if(n > 2) println(n=2) exit
     * n=3:println(n=3) exit
     * n=4:println(n=4) exit
     * main:exit
     * @param n
     */
    private static void print(int n) {
        if (n > 2) {
            print(n - 1);
        }
        System.out.println("n=" + n);
    }

    /**
     * 打印问题对照组
     * main:print(4)
     * n=4:if(n > 2) test(3)
     * n=3:if(n > 2) test(2)
     * n=2:if(n > 2) println(n=2) exit
     * n=3:exit
     * n=4:exit
     * main:exit
     * @param n
     */
    private static void test(int n) {
        if (n > 2) {
            test(n - 1);
        }else {
            System.out.println("n=" + n);
        }
    }

    /**
     * 阶乘问题
     * main:factorial(3)
     * n=3:if(n == 1) return factorial(2) * 3
     * n=2:if(n == 1) return factorial(1) * 2
     * n=1:if(n == 1) return 1
     * n=2:return 1 * 2
     * n=3:return 2 * 3
     * main:println(result=6)
     * @param n
     * @return n的阶乘
     */
    private static int factorial(int n) {
        if (n == 1) {
            return 1;
        }else {
            return factorial(n - 1) * n;
        }
    }
}
