package com.algorithm.geekbang.primer;

/**
 * @Author 李非凡
 * @Description:
 * 空间复杂度
 * 全称是渐进空间复杂度，表示算法的存储空间与数据规模之间的增长关系。
 * @Date 2019/10/15 0:17
 * @Version 1.0
 */
public class SpaceComplexity {

    /**
     * 线性空间复杂度
     * O(n)
     * @param n
     */
    private void liner(int n){
        int i = 0;
        int[] a = new int[n];
        for (; i < n; ++i) {
            a[i] = i * i;
        }

        for (i = n-1; i >= 0; --i) {
            System.out.println(a[i]);
        }
    }

    public static void main(String[] args) {

    }
}
