package com.huawei.algorithm;

/**
 * @Author 李非凡
 * @Description: 字符串反转
 * 题目描述
 * 写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
 *
 * 输入描述:
 * 输入N个字符
 * 输出描述:
 * 输出该字符串反转后的字符串
 *
 * 示例1
 * 输入
 * abcd
 *
 * 输出
 * dcba
 * @Date 2020/3/14 20:11
 * @Version 1.0
 */
public class StringReverse {

    public static void main(String[] args) {
        String str = "abcd";
        System.out.println(stringReverse(str));
    }

    /**
     *
     * @param str
     * @return
     */
    private static String stringReverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}
