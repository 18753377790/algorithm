package com.algorithm.divergent.thinking.ability;

import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description:
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 *
 * 1.&
 * &按位与的运算规则是将两边的数转换为二进制位，然后运算最终值，
 * 运算规则即(两个为真才为真)1&1=1 , 1&0=0 , 0&1=0 , 0&0=0
 * 3的二进制位是0000 0011 ， 5的二进制位是0000 0101 ，
 * 那么就是011 & 101，由按位与运算规则得知，001 & 101等于0000 0001，最终值为1
 * 7的二进制位是0000 0111，那就是111 & 101等于101，也就是0000 0101，故值为5
 *
 * 2.|
 * |按位或和&按位与计算方式都是转换二进制再计算，
 * 不同的是运算规则(一个为真即为真)1|0 = 1 , 1|1 = 1 , 0|0 = 0 , 0|1 = 1
 * 6的二进制位0000 0110 , 2的二进制位0000 0010 , 110|010为110，最终值0000 0110，故6|2等于6
 *
 * 3.^
 * ^异或运算符顾名思义，异就是不同，其运算规则为1^0 = 1 , 1^1 = 0 , 0^1 = 1 , 0^0 = 0
 * 5的二进制位是0000 0101，9的二进制位是0000 1001，也就是0101 ^ 1001,结果为1100 , 00001100的十进制位是12
 *
 * 4.~
 * ~ 取反就是1为0,0为1,5的二进制位是0000 0101，取反后为1111 1010，值为-6
 *
 * 5.<<
 * 5<<2的意思为5的二进制位往左挪两位，右边补0，5的二进制位是0000 0101 ，
 * 就是把有效值101往左挪两位就是0001 0100 ，正数左边第一位补0，负数补1，等于乘于2的n次方，十进制位是20
 *
 * 6.>>
 * 凡位运算符都是把值先转换成二进制再进行后续的处理，5的二进制位是0000 0101，
 * 右移两位就是把101左移后为0000 0001，正数左边第一位补0，负数补1，等于除于2的n次方，结果为1
 *
 * 7.>>>
 * 正数无符号右移
 * 无符号右移运算符和右移运算符的主要区别在于负数的计算，因为无符号右移是高位补0，移多少位补多少个0。
 * 15的二进制位是0000 1111，右移2位0000 0011，结果为3
 * 负数无符号右移
 * -6的二进制是6的二进制取反再加1,6的二进制也就是0000 0000 0000 0000 0000 0000 0000 0110，
 * 取反后加1为1111 1111 1111 1111 1111 1111 1111 1010，右移三位0001 1111 1111 1111 1111 1111 1111 1111
 * @Date 2019/8/13 19:43
 * @Version 1.0
 */
public class TwoSum {

    /**
     * 相加的方法
     *
     * 首先看十进制是如何做的： 5+7=12，三步走
     * 第一步：相加各位的值，不算进位，得到2。
     *
     * 第二步：计算进位值，得到10. 如果这一步的进位值为0，那么第一步得到的值就是最终结果。
     *
     * 第三步：重复上述两步，只是相加的值变成上述两步的得到的结果2和10，得到12。
     * @param num1
     * @param num2
     * @return
     */
    private int add(int num1, int num2){
        while (num2 != 0) {
            // 第一步：相加各位的值，不算进位，得到010，二进制每位相加就相当于各位做异或操作，101^111。
            int temp = num1 ^ num2;
            // 第二步：计算进位值，得到1010，相当于各位做与操作得到101，再向左移一位得到1010，(101&111)<<1。
            num2 = (num1 & num2) << 1;
            // 第三步重复上述两步， 各位相加 010^1010=1000，进位值为100=(010&1010)<<1。继续重复上述两步：1000^100 = 1100，进位值为0，跳出循环，1100为最终结果。
            num1 = temp;
        }
        return num1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        TwoSum twoSum = new TwoSum();
        System.out.println(twoSum.add(num1, num2));
    }
}
