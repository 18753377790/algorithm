package com.offer.algorithm;

/**
 * @Author 李非凡
 * @Description: 数值的整数次方
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 * @Date 2020/3/14 22:50
 * @Version 1.0
 */
public class IntegerPowerOfValue {

    public static void main(String[] args) {
        double base = 2;
        int exponent = 2;
        System.out.println(new IntegerPowerOfValue().power(base, exponent));
    }

    /**
     *
     * @param base
     * @param exponent
     * @return
     */
    public double power(double base, int exponent) {
        if (base == 0 && exponent == 0) {
            return -1.0;
        }

        double power = 1;

        if (exponent > 0) {
            for (int i = 0; i < exponent; i++) {
                power *= base;
            }
        }else {
            for (int i = 0; i < -exponent; i++) {
                power *= base;
            }
            power = 1 / power;
        }

        return power;
    }
}
