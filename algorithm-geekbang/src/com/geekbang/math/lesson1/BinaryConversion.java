package com.geekbang.math.lesson1;

import java.math.BigInteger;

/**
 * @Author 李非凡
 * @Description: 进制转换
 * 二进制与十进制相互转换
 *
 * 计算机为什么使用二进制？
 * 1.计算机使用二进制和现代计算机系统的硬件实现有关。
 *  组成计算机系统的逻辑电路通常只有两个状态，即开关的接通与断开。
 *
 *  断开的状态我们用“0”来表示，接通的状态用“1”来表示。
 *  由于每位数据只有断开与接通两种状态，所以即便系统受到一定程度的干扰时，它仍然能够可靠地分辨出数字是“0”还是“1”。
 *  因此，在具体的系统实现中，二进制的数据表达具有抗干扰能力强、可靠性高的优点。
 *
 * 2.二进制也非常适合逻辑运算。
 *   逻辑运算中的“真”和“假”，正好与二进制的“0”和“1”两个数字相对应。
 *   逻辑运算中的加法（“或”运算）、乘法（“与”运算）以及否定（“非”运算）都可以通过“0”和“1”的加法、乘法和减法来实现。
 *
 * @Date 2020/3/13 22:22
 * @Version 1.0
 */
public class BinaryConversion {

    public static void main(String[] args) {
        int a = 53;
        String b = "110101";
        // 获取十进制数53的二进制数
        System.out.println(String.format("数字%d的二进制是%s", a, decimalToBinary(a)));
        // 获取二进制数110101的十进制数
        System.out.println(String.format("数字%s的十进制是%d", b, binaryToDecimal(b)));
    }

    /**
     * 十进制转换成二进制
     * @param decimalSource 十进制数
     * @return 对应的二进制数
     */
    public static String decimalToBinary(int decimalSource) {
        // 转换成BigInteger类型，默认是十进制
        BigInteger bi = new BigInteger(String.valueOf(decimalSource));
        // 参数2指定的是转化成二进制
        return bi.toString(2);
    }

    /**
     * 二进制转换成十进制
     * @param binarySource 二进制数
     * @return 对应的十进制数
     */
    public static int binaryToDecimal(String binarySource) {
        // 转换为BigInteger类型，参数2指定的是二进制
        BigInteger bi = new BigInteger(binarySource, 2);
        // 默认转换成十进制
        return Integer.parseInt(bi.toString());
    }
}
