package com.atguigu.datastructure.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * @Author 李非凡
 * @Description: 基数排序
 * 基数排序属于“分配式排序”，又称“桶子法”
 * 基数排序是效率高的稳定性排序算法
 * 基数排序是桶排序的扩展
 *
 * 基数排序时间复杂度为O(nxk)，空间复杂度为O(n+k)，k为桶的个数，一般是10
 *
 * 基数排序是空间换时间的经典算法，占用内存很大，当对海量数据时，容易造成OOM
 *
 * 有负数的数组，不要用基数排序
 *
 * 当希尔排序，快速排序，归并排序和堆排序的logN > 10时，速度会比基数排序慢，因为O(nxk)中的k=10
 * @Date 2020/3/5 23:12
 * @Version 1.0
 */
public class RadixSort {

    public static void main(String[] args) {
//        int[] array = {53, 3, 542, 748, 14, 214};
//        radixSortDemo(array);

        // 创建一个8000000个数的随机数组（80000000数据，需要大约3.3G内存，有可能OOM）
        int[] array = new int[8000000];
        for (int i = 0; i < array.length; i++) {
            // 生成一个[0,8000000)数
            array[i] = new Random().nextInt(8000000);
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date1 = new Date();
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是：" + date1Str);

        // 测试基数排序
        radixSort(array);

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是：" + date2Str);
    }

    /**
     * 基数排序
     * @param array 待排序的数组
     */
    private static void radixSort(int[] array) {

        // 得到数组中最大数，假设第一个数就是最大数
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        // 得到数组中最大数的位数
        int maxLength = String.valueOf(max).length();

        int[][] bucket = new int[10][array.length];

        int[] bucketElementCounts = new int[10];

        // 使用循环基数排序
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            // 针对每个元素对应的位进行排序处理，第一次是个位，第二次是十位
            for (int j = 0; j < array.length; j++) {
                // 取出每个元素对应位的值
                int digitOfElement = array[j] / n % 10;
                // 放入到对应的桶中，初始时因为bucketElementCounts数组中每个元素都为0，所以bucketElementCounts[digitOfElement]为0
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = array[j];
                // 记录+1
                bucketElementCounts[digitOfElement]++;
            }

            // 按照桶的顺序（一维数组的下标）依次取出数据，放回到原数组
            int index = 0;

            // 遍历每一个桶，并将桶中的数据放入到原数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
                // 如果桶中有数据，放入到原数组
                if (bucketElementCounts[k] != 0) {
                    // 循环该桶即k个桶（第k个一维数组），放入数组即可
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        // 取出元素放入到array
                        array[index++] = bucket[k][l];
                    }
                }
                // 第i+1轮处理后需要将每个bucketElementCounts[k] = 0
                bucketElementCounts[k] = 0;
            }

//            System.out.println("第" + (i + 1) + "轮，对个位的排序处理：");
//            System.out.println(Arrays.toString(array));
        }
    }

    /**
     * 基数排序演示
     * 第一轮排序：
     * 1.将每个元素的个位数取出，然后看这个数应该放在哪个对应的桶（一个桶一个一维数组）
     * 2.按照桶的顺序（一维数组的下标）依次取出数据，放回到原数组
     *
     * 第二轮排序：
     * 1.将每个元素的十位数取出，然后看这个数应该放在哪个对应的桶（一个桶一个一维数组）
     * 2.按照桶的顺序（一维数组的下标）依次取出数据，放回到原数组
     *
     * 第三轮排序：
     * 1.将每个元素的百位数取出，然后看这个数应该放在哪个对应的桶（一个桶一个一维数组）
     * 2.按照桶的顺序（一维数组的下标）依次取出数据，放回到原数组
     * @param array 待排序的数组
     */
    private static void radixSortDemo(int[] array) {
        /*
         定义一个二维数组表示十个桶
         说明：
         1.每个桶就是一个一维数组
         2.为了防止在放入数的时候数据溢出，则每个桶（一维数组）大小为数组的length
         3.以空间换时间
         */
        int[][] bucket = new int[10][array.length];

        /*
         为了记录每个桶中实际存放了多少个数据，定义一个一维数组来记录各个桶每次放入的数据的个数
         例：bucketElementCounts[0]记录的就是bucket[0]这个桶的每次放入的数据的个数
         */
        int[] bucketElementCounts = new int[10];

        // 第一轮排序：针对每个元素的个位进行排序处理
        for (int j = 0; j < array.length; j++) {
            // 取出每个元素的个位的值，相当于array[j] / 1 % 10
            int digitOfElement = array[j] % 10;
            // 放入到对应的桶中，初始时因为bucketElementCounts数组中每个元素都为0，所以bucketElementCounts[digitOfElement]为0
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = array[j];
            // 记录+1
            bucketElementCounts[digitOfElement]++;
        }

        // 按照桶的顺序（一维数组的下标）依次取出数据，放回到原数组
        int index = 0;

        // 遍历每一个桶，并将桶中的数据放入到原数组
        for (int k = 0; k < bucketElementCounts.length; k++) {
            // 如果桶中有数据，放入到原数组
            if (bucketElementCounts[k] != 0) {
                // 循环该桶即k个桶（第k个一维数组），放入数组即可
                for (int l = 0; l < bucketElementCounts[k]; l++) {
                    // 取出元素放入到array
                    array[index++] = bucket[k][l];
                }
            }
            // 第一轮处理后需要将每个bucketElementCounts[k] = 0
            bucketElementCounts[k] = 0;
        }

        System.out.println("第一轮，对个位的排序处理：");
        System.out.println(Arrays.toString(array));


        // 第二轮排序：针对每个元素的十位进行排序处理
        for (int j = 0; j < array.length; j++) {
            // 取出每个元素的百位的值
            int digitOfElement = array[j] / 10 % 10;
            // 放入到对应的桶中，初始时因为bucketElementCounts数组中每个元素都为0，所以bucketElementCounts[digitOfElement]为0
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = array[j];
            // 记录+1
            bucketElementCounts[digitOfElement]++;
        }

        // 按照桶的顺序（一维数组的下标）依次取出数据，放回到原数组
        index = 0;

        // 遍历每一个桶，并将桶中的数据放入到原数组
        for (int k = 0; k < bucketElementCounts.length; k++) {
            // 如果桶中有数据，放入到原数组
            if (bucketElementCounts[k] != 0) {
                // 循环该桶即k个桶（第k个一维数组），放入数组即可
                for (int l = 0; l < bucketElementCounts[k]; l++) {
                    // 取出元素放入到array
                    array[index++] = bucket[k][l];
                }
            }
            // 第二轮处理后需要将每个bucketElementCounts[k] = 0
            bucketElementCounts[k] = 0;
        }

        System.out.println("第二轮，对十位的排序处理：");
        System.out.println(Arrays.toString(array));

        // 第三轮排序：针对每个元素的百位进行排序处理
        for (int j = 0; j < array.length; j++) {
            // 取出每个元素的百位的值
            int digitOfElement = array[j] / 100 % 10;
            // 放入到对应的桶中，初始时因为bucketElementCounts数组中每个元素都为0，所以bucketElementCounts[digitOfElement]为0
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = array[j];
            // 记录+1
            bucketElementCounts[digitOfElement]++;
        }

        // 按照桶的顺序（一维数组的下标）依次取出数据，放回到原数组
        index = 0;

        // 遍历每一个桶，并将桶中的数据放入到原数组
        for (int k = 0; k < bucketElementCounts.length; k++) {
            // 如果桶中有数据，放入到原数组
            if (bucketElementCounts[k] != 0) {
                // 循环该桶即k个桶（第k个一维数组），放入数组即可
                for (int l = 0; l < bucketElementCounts[k]; l++) {
                    // 取出元素放入到array
                    array[index++] = bucket[k][l];
                }
            }
            // 第三轮处理后需要将每个bucketElementCounts[k] = 0
            bucketElementCounts[k] = 0;
        }

        System.out.println("第三轮，对百位的排序处理：");
        System.out.println(Arrays.toString(array));
    }
}


