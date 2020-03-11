package com.datastructure.tree.heap;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * @Author 李非凡
 * @Description: 堆排序（选择排序的一种）
 * 堆排序的最好，最坏，平均时间复杂度都是O(N*logN)，是不稳定排序
 *
 * 堆的定义：
 * 堆是一颗完全二叉树，具有以下性质：
 * 1.大顶堆：每个结点的值都大于或等于其左右孩子结点的值
 *   大顶堆特点：array[i]>=array[2*i+1]&&array[i]>=array[2*i+2]，i对应第几个结点，i从0开始编号
 * 2.小顶堆：每个结点的值都小于或等于其左右孩子结点的值
 *   小顶堆特点：array[i]<=array[2*i+1]&&array[i]<=array[2*i+2]，i对应第几个结点，i从0开始编号
 * 注意：没有要求结点的左孩子和右孩子的值的大小关系
 * 一般升序采用大顶堆，降序采用小顶堆
 *
 * 堆排序的基本思想：
 * 1.将待排序序列构造成一个大顶堆
 * 2.整个序列的最大值就是堆顶的根结点
 * 3.将其与末尾元素进行交换，此时末尾就为最大值
 * 4.然后将剩余n-1个元素重新构造成一个堆，这样会得到n个元素的次小值。如此反复执行，便能得到一个有序序列了
 * 在构建大顶堆的过程中，元素的个数逐渐减少，最后就得到一个有序序列了
 * @Date 2020/3/7 23:28
 * @Version 1.0
 */
public class HeapSort {

    public static void main(String[] args) {
        // 要求将数组进行升序排序
//        int[] array = {4, 6, 8, 5, 9};
//        System.out.println("堆排序：");
//        heapSort(array);
//        System.out.println("数组=" + Arrays.toString(array));

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
        heapSort(array);

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是：" + date2Str);
    }

    /**
     *
     * @param array
     */
    private static void heapSortDemo(int[] array) {
        // 分步完成
        buildHeap(array, 1, array.length);
        System.out.println("第一次调整：" + Arrays.toString(array));

        buildHeap(array, 0, array.length);
        System.out.println("第二次调整：" + Arrays.toString(array));
    }

    /**
     * 堆排序
     * @param array 待排序的数组
     */
    private static void heapSort(int[] array) {
        // 将无序序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            buildHeap(array, i, array.length);
        }

        /*
        将堆顶元素与末尾元素交换，将最大元素“沉”到数组末端
        重新调整结构，使其满足
         */
        for (int j = array.length - 1; j > 0; j--) {
            // 交换
            int temp = array[j];
            array[j] = array[0];
            array[0] = temp;
            buildHeap(array, 0, j);
        }
    }

    /**
     * 建堆（大顶堆）
     * 将一个数组（顺序存储二叉树），调整成一个大顶堆
     * 功能：将以index对应的非叶子结点的树调整成大顶堆
     * 例：数组{4, 6, 8, 6, 9}，index为1，经过调用buildHeap得到{4, 9, 8, 5, 9}
     *     数组{4, 9, 8, 5, 9}，index为0，再次调用buildHeap得到{9, 6, 8, 5, 4}
     * @param array 待调整的数组
     * @param index 非叶子结点在数组中的索引
     * @param length 表示对数组中多少个元素进行调整，length在逐渐减少
     */
    private static void buildHeap(int[] array, int index, int length) {
        // 先取出当前元素的值，保存在一个临时变量
        int temp = array[index];
        /*
         开始调整
         说明：
         k = index * 2 + 1，k是index结点的左子结点下标
         */
        for (int k = index * 2 + 1; k < length; k = k * 2 + 1) {
            /*
             k + 1 < length防止没有右子结点时数组下标越界，
             说明index左子结点的值小于index右子结点的值
             */
            if (k + 1 < length && array[k] < array[k + 1]) {
                // k就指向index的右子结点
                k++;
            }
            // 如果某一个子结点大于index下标的父结点
            if (array[k] > temp) {
                // 将较大的子结点付给当前index下标的结点
                array[index] = array[k];
                // 让index指向k，继续循环比较
                index = k;
            }else {
                break;
            }
        }
        /*
         当for循环结束后，已经将以index父结点的子树的最大值放在了index下标的位置
         将temp放在调整后的位置
         */
        array[index] = temp;
    }
}
