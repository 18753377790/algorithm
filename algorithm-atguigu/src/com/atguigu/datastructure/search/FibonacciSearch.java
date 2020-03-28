package com.atguigu.datastructure.search;

import java.util.Arrays;

/**
 * @Author 李非凡
 * @Description: 斐波那契（黄金分割法）查找
 * 充分必要条件：有序数组
 * 黄金分割点：是指把一条线段分割为两部分，使其中一部分与全长之比等于另一部分与这部分之比，取其前三位数字的近似值是0.618
 * 斐波那契数列：{1,1,2,3,5,8,13,21}相邻两个实数的比例无限接近黄金分割比0.618
 *
 * middle = low + F(k - 1) - 1 (F为Fibonacci的缩写，即斐波那契数列)
 *
 * F(k-1)-1
 * 由：F(k)=F(k-1)+F(k-2)
 * 得：F(k)-1=(F(k-1)-1) + (F(k-2)-1) + 1
 * 即：只要顺序表的长度为F(k)-1，则可以将该表分成长度为F(k-1)-1和F(k-2)-1的两段
 * @Date 2020/3/7 2:18
 * @Version 1.0
 */
public class FibonacciSearch {

    /**
     * 数组的最大值
     */
    private static final int MAX_SIZE = 20;

    public static void main(String[] args) {
        int[] array = {1, 8, 10, 89, 1000, 1234};

        System.out.println("index=" + fibonacciSearch(array, 1234));
    }


    /**
     * 因为计算middle=low+F(k-1)-1需要使用到斐波那契数列，因此需要先获取到一个斐波那契数列
     * 使用非递归方法得到一个斐波那契数列
      * @return 斐波那契数列
     */
    private static int[] fibonacci() {
        int[] array = new int[MAX_SIZE];
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i < array.length; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array;
    }

    /**
     * 斐波那契查找
     * 非递归方式实现
     * @param array 待查找的数组，必须是有序的
     * @param findValue 要查找的值
     * @return 如果找到就返回对应的数组下标，如果没有找到就返回-1
     */
    private static int fibonacciSearch(int[] array, int findValue) {
        int low = 0;
        int high = array.length - 1;
        // k表示斐波那契分割数值对应的下标
        int k = 0;
        // 存放数组的middle
        int middle = 0;
        // 获取到斐波那契数列
        int[] f = fibonacci();
        // 获取k（斐波那契分割数值对应的下标）
        while (high > f[k] - 1) {
            k++;
        }
        /*
         因为f[k]的值可能大于数组的长度，需要使用Arrays类的方法构造新的数组，并指向temp
         Arrays.copyOf(array, f[k])不足的部分会使用0填充
         */
        int[] temp = Arrays.copyOf(array, f[k]);
        // 使用array数组的最后一个数填充temp
        for (int i = high; i < temp.length; i++) {
            temp[i] = array[high];
        }
        /*
         使用while循环来循环处理，找到要查找的值
         只要low <= high条件满足，就可以一直找
         */
        while (low <= high) {
            middle = low + f[k - 1] - 1;
            // 应该继续向数组的前面（左边）查找
            if (findValue < temp[middle]) {
                high = middle - 1;
                /*
                说明：为什么要k--
                1.全部元素=前面的元素+后面的元素
                2.f[k]=f[k-1]+f[k-2]
                3.因为前面有f[k-1]个元素，所以可以继续拆分f[k-1]=f[k-2]+f[k-3]
                即在f[k-1]的前面继续查找要k--，
                即下次循环middle=f[k-1-1]-1
                 */
                k--;
            }else if (findValue > temp[middle]) {
                // 应该继续向数组的后面（右边）查找
                low = middle + 1;
                /*
                说明：为什么是k -= 2
                1.全部元素=前面的元素+后面的元素
                2.f[k]=f[k-1]+f[k-2]
                3.因为后面有f[k-2]个元素，所以可以继续拆分f[k-1]=f[k-3]+f[k-4]
                即在f[k-2]的前面继续查找要k -= 2
                即下次循环middle=f[k-1-2]-1
                 */
                k -= 2;
            }else {
                // 找到后需要确定是返回的是哪个下标，返回小一点的
                return Math.min(middle, high);
            }
        }
        // while循环没有找到，返回-1
        return -1;
    }
}
