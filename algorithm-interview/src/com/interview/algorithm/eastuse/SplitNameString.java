package com.interview.algorithm.eastuse;

/**
 * @Author 李非凡
 * @Description:
 * 易思优外派国家电网公司面试题
 * 有如下形式的字符串，包含n个姓名："zhangsan,lisi,wangwu,......"，请打印出全部姓名如下形式
 * zhangsan
 * lisi
 * wangwu
 * @Date 2019/11/19 10:02
 * @Version 1.0
 */
public class SplitNameString {

    /**
     * 打印拆分后的字符串
     * @param str 待拆分打印的字符串
     */
    private static void print(String str) {
        String[] strings = str.split(",");
        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static void main(String[] args) {
        String str = "zhangsan,lisi,wangwu";
        print(str);
    }
}
