package com.interview.algorithm.oppo;

/**
 * @Author 李非凡
 * @Description:
 * 博彦科技外派OPPO面试题：字符串反转
 * @Date 2019/11/20 13:47
 * @Version 1.0
 */
public class StringReverse {

    /**
     * 字符串反转
     * @param str 源字符串
     * @return 反转后的字符串
     */
    private static String reverse(String str) {

        StringBuilder builder = new StringBuilder();

        char[] chars = str.toCharArray();

        for (int i = chars.length - 1; i >=0; i--) {
            builder.append(chars[i]);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String str = "fuck";
        System.out.println(reverse(str));
        System.out.println(new StringBuffer("fuck").reverse().toString());
    }
}
