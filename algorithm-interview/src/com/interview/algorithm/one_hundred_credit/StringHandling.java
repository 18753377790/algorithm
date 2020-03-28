package com.interview.algorithm.one_hundred_credit;

import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description:
 * 输入一个字符串，如果这个字符串包含了英文字母或空格以外的字符，直接返回原字符串
 * 如果只包含字母或空格，则做以下处理：
 * 1.处理这些被空格隔开的单词，让每个单词只有最后一个字母大写。
 * 2.将所有空格替换为@符号。
 * 3.返回处理后的字符串。
 * @Date 2019/8/26 21:14
 * @Version 1.0
 */
public class StringHandling {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字符串：");
        String str = scanner.nextLine();
        System.out.println(stringHanding(str));
    }

    /**
     *
     * @param str
     * @return
     */
    private static String stringHanding(String str){
//        if (str.matches("^[[A-Za-z]|\\s]+$")){
//            return str;
//        }
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            // 如果这个字符串包含了英文字母或空格以外的字符，直接返回原字符串
            if (!(arr[i] <= 'z' && arr[i] >='a'|| arr[i] <= 'Z' && arr[i] >='A'||arr[i] == ' ')){
                return str;
            }
            // 处理这些被空格隔开的单词，让每个单词只有最后一个字母大写。
            if (arr[i] == ' ' && arr[i - 1] >= 'Z'){
                arr[i - 1] -= 32;
            }
        }
        String string = new String(arr);
        // 将所有空格替换为@符号。
        string = string.replaceAll("\\s", "@");
        return string;
    }
}
