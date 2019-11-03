package com.algorithm.array;

import java.util.Arrays;

/**
 * @Author 李非凡
 * @Description:
 * 构建乘积数组
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 * @Date 2019/10/23 15:09
 * @Version 1.0
 */
public class MultiplyArray {

    /**
     * 构建乘积数组
     * @param A 传入的数组
     * @return 构建的乘积数组
     */
    private int[] multiply(int[] A) {
        if (A.length == 0)
            return null;


        return null;
    }


    public static void main(String[] args) {
        int[] array = {};
        MultiplyArray multiply = new MultiplyArray();
        System.out.println(Arrays.toString(multiply.multiply(array)));
    }
}
