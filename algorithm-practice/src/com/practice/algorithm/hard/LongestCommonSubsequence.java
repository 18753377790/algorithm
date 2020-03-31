package com.practice.algorithm.hard;

/**
 * @Author 李非凡
 * @Description: 最长公共子序列
 * @Date 2020/3/8 23:34
 * @Version 1.0
 */
public class LongestCommonSubsequence {

    private static final int MAX_LEN = 50;

    public static void main(String[] args) {
//        String str1 = "ABCBDAB";
//        String str2 = "BDCABA";

        // 算法导论上222页的DNA的碱基序列匹配
         String str1 = "ACCGGTCGAGTGCGCGGAAGCCGGCCGAA";
         String str2 = "GTCGTTCGGAATGCCGTTGCTCTGTAAA";

        // 仅仅使用一个c表
        int[][] c = new int[MAX_LEN][MAX_LEN];

        int m = str1.length();
        int n = str2.length();

        LongestCommonSubsequence lcs = new LongestCommonSubsequence();

        lcs.lcsLength(str1, str2, m, n, c);
        lcs.printLcs(c, str1, m, n);
    }

    private void lcsLength(String str1, String str2, int m, int n, int[][] c) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        for(int i = 0; i <= m; i++) {
            c[i][0] = 0;
        }

        for(int j = 1; j <= n; j++) {
            c[0][j] = 0;
        }

        for(int i = 1; i<= m; i++) {
            for(int j = 1; j <= n; j++) {
                // 仅仅去掉了对b数组的使用，其它都没变
                if(chars1[i-1] == chars2[j-1]) {
                    c[i][j] = c[i-1][j-1] + 1;
                } else {
                    c[i][j] = Math.max(c[i - 1][j], c[i][j - 1]);
                }

            }
        }
    }

    private void printLcs(int[][] c, String x, int i, int j) {
        if(i == 0 || j == 0) {
            return;
        }
        char[] chars = x.toCharArray();
        if(c[i][j] == c[i - 1][j]) {
            printLcs(c, x, i-1, j);
        } else if(c[i][j] == c[i][j-1]) {
            printLcs(c, x, i, j-1);
        } else {
            printLcs(c, x, i-1, j-1);
            System.out.printf("%c ",chars[i - 1]);
        }
    }
}
