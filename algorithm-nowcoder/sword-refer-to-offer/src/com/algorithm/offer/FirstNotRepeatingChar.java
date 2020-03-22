package com.algorithm.offer;

/**
 * @Author 李非凡
 * @Description: 第一个只出现一次的字符
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 * @Date 2020/3/15 11:55
 * @Version 1.0
 */
public class FirstNotRepeatingChar {

    public static void main(String[] args) {
        String str = "abcdab";
        System.out.println(new FirstNotRepeatingChar().firstNotRepeatingChar(str));
    }

    /**
     *
     * @param str
     * @return
     */
    public int firstNotRepeatingChar(String str) {
        char[] chars = str.toCharArray();

        boolean flag = false;
        int index = -1;

        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars.length; j++) {
                if (chars[i] == chars[j] && i != j) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                flag = false;
            }else {
                index = i;
                break;
            }
        }

        return index;
    }
}
