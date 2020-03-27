package com.math.lesson1;

/**
 * @Author 李非凡
 * @Description: 位运算操作
 * @Date 2020/3/14 0:09
 * @Version 1.0
 */
public class BitOperation {


    public static void main(String[] args) {
        
        int a = 53;
        int b = 35;

        // 获取十进制数53和35的按位“或”
        System.out.println(String.format("数字%d(%s)和数字%d(%s)的按位‘或’结果是%d(%s)",
                a, BinaryConversion.decimalToBinary(a), b, BinaryConversion.decimalToBinary(b), or(a, b), BinaryConversion.decimalToBinary(or(a, b))));
        // 获取十进制数53和35的按位“与”
        System.out.println(String.format("数字%d(%s)和数字%d(%s)的按位‘与’结果是%d(%s)",
                a, BinaryConversion.decimalToBinary(a), b, BinaryConversion.decimalToBinary(b), and(a, b), BinaryConversion.decimalToBinary(and(a, b))));
        // 获取十进制数53和35的按位“异或”
        System.out.println(String.format("数字%d(%s)和数字%d(%s)的按位‘异或’结果是%d(%s)",
                a, BinaryConversion.decimalToBinary(a), a, BinaryConversion.decimalToBinary(a),xor(a, a), BinaryConversion.decimalToBinary(xor(a, a))));

    }



    /**
     *
     * @param num1
     * @param num2
     * @return
     */
    private static int or(int num1, int num2) {
        return (num1 | num2);
    }

    /**
     *
     * @param num1
     * @param num2
     * @return
     */
    private static int and(int num1, int num2) {
        return (num1 & num2);
    }

    /**
     *
     * @param num1
     * @param num2
     * @return
     */
    private static int xor(int num1, int num2) {
        return (num1 ^ num2);
    }
}
