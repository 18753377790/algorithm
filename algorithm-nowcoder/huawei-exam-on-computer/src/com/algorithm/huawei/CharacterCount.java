package com.algorithm.huawei;

/**
 * @Author 李非凡
 * @Description: 字符个数统计
 * 题目描述
 * 编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)，换行表示结束符，不算在字符里。不在范围内的不作统计。
 *
 * 输入描述:
 * 输入N个字符，字符在ACSII码范围内。
 * 输出描述:
 * 输出范围在(0~127)字符的个数。
 *
 * 示例1
 * 输入 abc
 * 输出 3
 * @Date 2020/3/14 17:14
 * @Version 1.0
 */
public class CharacterCount {

    public static void main(String[] args) {
        String str = "abc";
        System.out.println(count(str));
    }

    private static int count(String str) {
        int count = 0;
        char[] chars = str.toCharArray();

        for (char aChar : chars) {
            if (aChar <= 127) {
                count++;
            }
        }


        return count;
    }
}
