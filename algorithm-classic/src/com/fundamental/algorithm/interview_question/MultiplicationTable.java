package com.fundamental.algorithm.interview_question;

/**
 * @Author 李非凡
 * @Description:
 * 九九乘法表
 * @Date 2019/11/18 10:39
 * @Version 1.0
 */
public class MultiplicationTable {

    /**
     * 使用单层循环打印九九乘法表
     */
    private static void singleLoop() {
        // 单层循环，初始化i和j为1
        for (int i = 1, j = 1; j <= 9; i++) {
            // 打印（注意一定要用空格隔开）
            System.out.print(i + "*" + j + "=" + i * j + " ");
            //
            if (i == j) {
                i = 0;
                j++;
                System.out.println();
            }
        }
    }

    /**
     * 使用双层循环打印九九乘法表
     */
    private static void doubleLoop() {
        // 遍历行
        for (int i = 1; i <= 9; i++) {
            // 遍历列，不能大于行i的值
            for (int j = 1; j <= i; j++) {
                // 打印（注意一定要用空格隔开）
                System.out.print(j + "*" + i + "=" + j * i + " ");
            }
            // 换行（必须换行）
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("使用单层循环打印九九乘法表：");
        singleLoop();
        System.out.println("使用双层循环打印九九乘法表：");
        doubleLoop();
    }
}
