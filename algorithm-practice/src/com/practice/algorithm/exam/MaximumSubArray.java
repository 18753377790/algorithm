package com.practice.algorithm.exam;

import java.util.Arrays;

/**
 * @Author 李非凡
 * @Description:TODE
 * @Date 2020/3/31 7:22
 * @Version 1.0
 */
public class MaximumSubArray {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(Arrays.toString(nums));
        MaximumSubArray maximumSubArray = new MaximumSubArray();
        int maxSubArray = maximumSubArray.maxSubArray(nums);
        System.out.println("sum="+maxSubArray);
    }

    /**
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }
        // 最后这一步，是求一个全局的最优值
        int res = dp[0];
        for (int i = 1; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
