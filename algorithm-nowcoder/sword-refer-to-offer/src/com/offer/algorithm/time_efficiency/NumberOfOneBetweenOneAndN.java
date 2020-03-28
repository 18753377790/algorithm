package com.offer.algorithm.time_efficiency;

import java.util.Scanner;

/**
 * @Author 李非凡
 * @Description:
 * 整数中1出现的次数（从1到n整数中1出现的次数）
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 * @Date 2019/11/3 9:04
 * @Version 1.0
 */
public class NumberOfOneBetweenOneAndN {

    /**
     * 从1到n整数中1出现的次数
     * @param n 整数n
     * @return 1出现的次数
     */
    private int NumberOf1Between1AndN(int n) {
        if (n <= 0)
            return 0;

        // 统计1出现的次数
        int count = 0;
        for (int i = 1; i <= n; i++) {
            // 将数字n拆分成char数组，数组的每一位对应n的每一位
            String str = String.valueOf(i);
            char[] chars = str.toCharArray();
            for (char aChar : chars) {
                if (aChar == '1')
                    count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        NumberOfOneBetweenOneAndN number = new NumberOfOneBetweenOneAndN();
        System.out.println(number.NumberOf1Between1AndN(n));
    }
}
