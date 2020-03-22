package com.algorithm.huawei;

import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description: 字符串最后一个单词的长度
 * 题目描述
 * 计算字符串最后一个单词的长度，单词以空格隔开。
 *
 * 输入描述:
 * 一行字符串，非空，长度小于5000。
 * 输出描述:
 * 整数N，最后一个单词的长度。
 *
 * 示例1
 * 输入 hello world
 * 输出 5
 * @Date 2020/3/14 14:32
 * @Version 1.0
 */
public class LastWordLengthInString {

    public static void main(String[] args) {
        String str = new Scanner(System.in).next();
        System.out.println(getWordLength(str));
    }

    private static int getWordLength(String str) {
        String[] strings = str.split(" ");
        return strings[strings.length - 1].length();
    }
}
