package com.practice.algorithm.exam;

/**
 * @Author 李非凡
 * @Description:TODE
 * @Date 2020/3/31 8:57
 * @Version 1.0
 */
public class ContiguousSubArray {

    public static void main(String[] args) {
        int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        ContiguousSubArray contiguousSubArray = new ContiguousSubArray();
        System.out.println("Maximum subarray is  " + contiguousSubArray.solve(array));
    }

    /**
     * bottom up approach
     * @param array
     * @return
     */
    public int solve(int[] array){
        int [] solution = new int[array.length + 1];
        solution[0] = 0;

        for (int j = 1; j < solution.length ; j++) {
            solution[j] = Math.max(solution[j - 1] + array[j - 1], array[j - 1]);
        }
        /*
        this will print the solution matrix
        System.out.println(Arrays.toString(solution))
        NOw return the maximum in the solution array
        */
        int result = solution[0];
        for (int j = 1; j < solution.length; j++) {
            if(result < solution[j]) {
                result = solution[j];
            }
        }

        return result;
    }
}



