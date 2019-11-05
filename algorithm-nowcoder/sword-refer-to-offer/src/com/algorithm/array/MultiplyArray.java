package com.algorithm.array;

import java.util.Arrays;

/**
 * @Author 李非凡
 * @Description:
 * 构建乘积数组
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 * @Date 2019/11/1 17:11
 * @Version 1.0
 */
public class MultiplyArray {

    /**
     * 构建乘积数组
     * B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]
     * B[i]=A[0]*...*A[n-1] / A[i]
     *       {
     * B[0]    A[i] A[1] A[2] A[3] A[4]
     * B[1]    A[0] A[i] A[2] A[3] A[4]
     * B[2]    A[0] A[1] A[i] A[3] A[4]
     * B[3]    A[0] A[1] A[2] A[i] A[4]
     * B[4]    A[0] A[1] A[2] A[3] A[i]
     *       }
     * 以对角线为分界线，先算上半部分，再算下半部分，最后相乘
     * @param A 原数组
     * @return 构建的乘积数组
     */
    private int[] multiply(int[] A) {
        int length = A.length;
        if (length == 0)
            return null;

        // 构建的乘积数组B
        int[] B = new int[length];

        int number = 1;
        // 下半部分，从左往右，B[i]=A[0]*A[1]*...*A[i-1]
        for (int i = 0; i < length; i++) {
            B[i] = number;
            number *= A[i];
        }

        number = 1;
        // 上半部分，从右往左，B[i]*=A[i+1]*...*A[n-1]
        for (int i = length - 1; i >= 0; i--) {
            B[i] *= number;
            number *= A[i];
        }

        return B;
    }

    public static void main(String[] args) {
        // B = {120, 60, 40, 30, 24}
        int[] A = {1, 2 ,3 ,4 ,5};
        MultiplyArray multiplyArray = new MultiplyArray();
        System.out.println(Arrays.toString(multiplyArray.multiply(A)));
    }
}
