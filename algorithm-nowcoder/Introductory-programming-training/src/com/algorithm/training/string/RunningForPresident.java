package com.algorithm.training.string;

import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description: 竞选社长
 * 题目描述
 * 假设你们社团要竞选社长，有两名候选人分别是A和B，社团每名同学必须并且只能投一票，最终得票多的人为社长.
 *
 * 输入描述:
 * 一行，字符序列，包含A或B，输入以字符0结束。
 * 输出描述:
 * 一行，一个字符，A或B或E，输出A表示A得票数多，输出B表示B得票数多，输出E表示二人得票数相等。
 *
 * 示例1
 * 输入
 * ABBABBAAB0
 * 输出
 * B
 * @Date 2020/3/21 10:35
 * @Version 1.0
 */
public class RunningForPresident {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        if (str == null || "".equals(str)) {
            return;
        }

        char[] chars = str.toCharArray();

        int countA = 0;
        int countB = 0;

        for (char aChar : chars) {
            if (aChar == 'A') {
                countA++;
            } else if (aChar == 'B') {
                countB++;
            } else {
                break;
            }
        }

        if (countA > countB) {
            System.out.println("A");
        }else if (countA < countB) {
            System.out.println("B");
        }else {
            System.out.println("E");
        }
    }
}
