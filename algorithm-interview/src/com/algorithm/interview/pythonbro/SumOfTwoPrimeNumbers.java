package com.algorithm.interview.pythonbro;

import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description:
 * 湃森兄弟面试题
 *
 * 写Java代码，输入整数n，计算出有多少对质数的和等于n，并输出。
 * （“质数”定义：只能被1或者自己整除的自然数）
 * 例如：输入为10, 程序应该输出结果为2。（共有两对质数的和为10,分别为(5,5),(3,7)）
 * 1不是质数
 *
 * 本题为腾讯秋招笔试题
 * @Date 2019/8/12 17:41
 * @Version 1.0
 */
public class SumOfTwoPrimeNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 输入的整数n
        int n = scanner.nextInt();
        // 计数器，程序输出的结果，默认值为0
        int count = 0;
        /*
         2是质数的开头，所以循环从2开始。
         n是奇数时
         比如9，9/2 = 4，此时的场景是4+5，然后是5+4，重复了
         n是偶数时
         比如10,10/2 = 5，此时的场景是5+5，然后是6+4，重复了
         */
        for (int i = 2; i <= n/2; i++) {
            // 如果i和n-i都是质数，则满足条件，计数器加1
            if (isPrime(i) && isPrime(n - i))
                count++;
        }
        System.out.println(count);
    }

    /**
     * 判断正整数是否是质数的方法
     * @param num 待判断的数字
     * @return flag
     */
    private static boolean isPrime(int num){
        // 1既不是质数也不是合数
        if (num == 1)
            return false;
        // 2是质数的开头
        if (num == 2)
            return true;
        // 判断是否为质数的标志，false是质数，true不是质数
        boolean flag = false;
        /*
         检查一个正整数N是否为素数，最简单的方法就是试除法，
         将该数N用小于等于根号N的所有素数去试除，若均无法整除，则N为素数

         只要遍历到平方根的前面就好了  后面跟前面的情况是一样的 只不过是2个值前后交换下
         比如 15
         1 3 5 15
         只要遍历到15的平方根是3到4之间 之前 所以只要遍历1和3
         3之后的要是有公倍数的话 就得跟3之前的乘
         也就是说 3*5 跟5*3的关系
         平方根前没有 之后也就没有了
         */
        for (int i = 2; i <= Math.sqrt(num); i++) {
            // 当num能整除i时，证明num不是质数，flag改为true
            if (num % i == 0){
                flag = true;
                break;
            }
        }
        // 当flag为false，即这个数是质数时，返回true
        return !flag;
    }
}
