package com.algorithm.practice.hard;

/**
 * @Author 李非凡
 * @Description:TODE
 * @Date 2020/3/10 11:42
 * @Version 1.0
 */
public class FindMedianInTwoArrays {

    /**
     * 求两个有序数组的中间值
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 数组1与数组2的中间值
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 总长度 = 数组1的长度 + 数组2的长度
        int total = nums1.length + nums2.length;
        // k = (total+1) / 2
        int k = (total + 1) >> 1;
        // 如果总长度为奇数（odd）
        if(total % 2 == 1) {
            return kthSmallestOfTwoArrays(k, nums1, 0, nums2, 0);
        } else {
            // 如果总长度为偶数（even）
            return (kthSmallestOfTwoArrays(k, nums1, 0, nums2, 0)
                    + kthSmallestOfTwoArrays(k+1, nums1, 0, nums2, 0)) / 2.0;
        }
    }
    // return the k-th smallest item in two sorted arrays, each from index Lo to length-1
    // e.g., given [1, 3] and [4, 6, 6], the 2nd smallest item is 3, the 3rd smallest is 4

    /**
     *
     * @param k (total+1) / 2
     * @param a num1数组
     * @param aLo
     * @param b num2数组
     * @param bLo
     * @return
     */
    private double kthSmallestOfTwoArrays(int k, int[] a, int aLo, int[] b, int bLo) {
        /*
         if remaining a from index alo to length-1 is empty
         如果a数组为空数组，
         由aLo>a.length-1，即0>a.length-1，得a.length=0
         */
        if (aLo > a.length - 1) {
            return b[bLo + k - 1];
        }
        /*
         如果b数组为空数组，
         由bLo>b.length-1，即0>b.length-1，得b.length=0
         */
        if (bLo > b.length - 1) {
            return a[aLo+ k - 1];
        }
        /*
         当每个数组只有一个元素时，选它们两个中最小的那个
         由k=1，即(total+1) / 2 = 1，
         又a.length>=1，b.length>=1，
         得total=2
         */
        if(k == 1) {
            return Math.min(a[aLo], b[bLo]);
        }
        // 0+k/2-1
        int aMid = aLo + k / 2 - 1;
        // 0+k/2-1
        int bMid = bLo + k / 2 - 1;
        // 整型的最大值
        int aMidItem = Integer.MAX_VALUE;
        // 整型的最大值
        int bMidItem = Integer.MAX_VALUE;
        // expect k/2 items in a's range
        if(aMid < a.length) {
            // make sure the index is valid! Otherwise, assign MAX_VALUE
            aMidItem = a[aMid];
        }
        // expect k/2 items in b's range
        if(bMid < b.length) {
            // make sure the index is valid! Otherwise, assign MAX_VALUE
            bMidItem = b[bMid];
        }
        // a[aLo,..., aLo + k/2 -1], need to find the rest k-k/2 smaller
        if(aMidItem < bMidItem) {
            return kthSmallestOfTwoArrays(k - k/2, a, aMid + 1, b, bLo);
        } else {
            // b[bLo, bLo + k/2 -1], having k/2 elements smaller already
            return kthSmallestOfTwoArrays(k - k/2, a, aLo, b, bMid + 1);
        }
    }
}
