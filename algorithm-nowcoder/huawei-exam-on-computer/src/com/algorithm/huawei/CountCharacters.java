package com.algorithm.huawei;

/**
 * @Author 李非凡
 * @Description: 计算字符个数
 * 题目描述
 * 写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
 *
 * 输入描述:
 * 第一行输入一个有字母和数字以及空格组成的字符串，第二行输入一个字符。
 * 输出描述:
 * 输出输入字符串中含有该字符的个数。
 *
 * 示例1
 * 输入
 * ABCDEF
 * A
 * 输出 1
 * @Date 2020/3/14 15:02
 * @Version 1.0
 */
public class CountCharacters {

    public static void main(String[] args) {
        String str = "ABCDEF";
        char ch = 'A';

        System.out.println(count(str, ch));
    }

    /**
     *
     * @param str
     * @param ch
     * @return
     */
    private static int count(String str, char ch) {
        int count = 0;
        char[] chars = str.toCharArray();

        for (char aChar : chars) {
            if (aChar == ch) {
                count++;
            }
        }

        return count;
    }
}
