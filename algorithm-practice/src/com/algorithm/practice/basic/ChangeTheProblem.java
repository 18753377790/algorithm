package com.algorithm.practice.basic;

/**
 * @Author 李非凡
 * @Description: 找零问题
 * 贪心算法（贪婪算法）
 * 只顾眼前不顾全局，是局部最优解
 *
 * 最重要两点
 * 1.贪心策略
 * 2.通过局部最优解能够得到全局最优解
 * @Date 2020/2/28 3:46
 * @Version 1.0
 */
public class ChangeTheProblem {

    /**
     * private static final int[] TYPES_OF_CHANGE = {0, 1, 5, 10, 25};
     * 零钱种类，第一个元素0起填充的作用，方便下标处理
     */
	private static final int[] TYPES_OF_CHANGE = {0, 1, 7, 10};

    /**
     *
     * @param c
     * @param m
     * @param s
     * @param n
     */
    private static void change(int[] c, int[] m, int[] s, int n) {
        // 减掉填充符
        int k = c.length - 1;
        m[0] = 0;
        for(int i = 1; i <= n; i++) {
            m[i] = Integer.MAX_VALUE;
            for(int j = 1; j <= k && (i >= c[j]); j++) {
                if(m[i - c[j]] + 1 < m[i]) {
                    m[i] = m[i - c[j]] + 1;
                    s[i] = j;
                }
            }
        }
    }

    /**
     *
     * @param c
     * @param s
     * @param n
     * @param count
     */
    private static void print(int[] c, int[] s, int n, int count) {
        int k = c.length;
        int[] number = new int[k];

        for(int i = 1; i < k; i++) {
            number[i] = 0;
        }

        while(n != 0) {
            number[s[n]] ++;
            n = n - c[s[n]];
        }
        System.out.printf("共%d个硬币：\n", count);
        for(int i = k - 1 ; i >= 1; i--) {
            if(number[i] > 0) {
                System.out.printf("%d个%d分硬币  ",number[i],c[i]);
            }
        }
    }

    public static void main(String[] args) {

        int k = TYPES_OF_CHANGE.length;
        // 所需找零钱数
        int n = 15;

        int[] c = new int[k];

//        for(int i = 0; i < k; i++){
//            c[i] = c1[i];
//        }
        System.arraycopy(TYPES_OF_CHANGE, 0, c, 0, k);

        // 不同零钱数对应的最小硬币数
        int[] m = new int[n + 1];
        // 记录所选硬币
        int[] s = new int[n + 1];

        change(c, m, s, n);

        print(c, s, n, m[n]);
    }
}
