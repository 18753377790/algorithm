package com.algorithm.offer.knowledge_transfer_ability;

/**
 * @Author 李非凡
 * @Description:
 * 左旋转字符串
 *
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 * 是不是很简单？OK，搞定它！
 * @Date 2019/11/2 16:03
 * @Version 1.0
 */
public class LeftRotationString {

    /**
     * 左旋转字符串
     * @param str 左移前的字符串
     * @param n 左移的位数
     * @return 左移后的字符串
     */
    private String LeftRotateString(String str, int n) {
        if ("".equals(str))
            return str;
        return str.substring(n) + str.substring(0, n);
    }

    public static void main(String[] args) {
        String str = "abcXYZdef";
        int n = 3;
        LeftRotationString rotationString = new LeftRotationString();
        System.out.println(rotationString.LeftRotateString(str, n));
    }
}
