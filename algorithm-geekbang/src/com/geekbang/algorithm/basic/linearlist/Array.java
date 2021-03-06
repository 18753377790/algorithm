package com.geekbang.algorithm.basic.linearlist;

import java.util.ArrayList;

/**
 * @Author 李非凡
 * @Description:
 * 数组（Array）是一种线性表数据结构。它用一组连续的内存空间，来存储一组具有相同类型的数据。
 * 1.线性表：线性表就是数据排成像一条线一样的结构。每个线性表上的数据最多只有前和后两个方向。
 * 数组，链表、队列、栈等都是线性表结构。
 * 非线性表，比如二叉树、堆、图等。
 * 2.连续的内存空间和相同类型的数据。正是因为这两个限制，它才有了一个堪称“杀手锏”的特性：“随机访问”。
 *
 * 长度为 10 的 int 类型的数组 int[] a = new int[10]，内存块的首地址为 base_address = 1000。
 * 寻址公式：a[i]_address = base_address + i * data_type_size
 * a[k]_address = base_address + k * type_size
 *
 * 查找时间复杂度
 * 数组适合查找操作，查找的时间复杂度为 O(n)。
 * 排好序的数组用二分查找时间复杂度为 O(logn)。
 * 数组支持随机访问，根据下标随机访问的时间复杂度为 O(1)。
 *
 * 插入时间复杂度
 * 在数组的末尾插入元素，最好时间复杂度为 O(1)
 * 在数组的开头插入元素，最坏时间复杂度是 O(n)。
 * 因为在每个位置插入元素的概率是一样的，所以平均情况时间复杂度为 (1+2+…n)/n=O(n)。
 * 插入优化：，如果要将某个数组插入到第 k 个位置，直接将第 k 位的数据搬移到数组元素的最后，把新的元素直接放入第 k 个位置。
 *
 * 删除时间复杂度
 * 如果删除数组末尾的数据，则最好情况时间复杂度为 O(1)；
 * 如果删除开头的数据，则最坏情况时间复杂度为 O(n)；
 * 平均情况时间复杂度也为 O(n)。
 * 删除优化：先记录下已经删除的数据。次的删除操作并不是真正地搬移数据，只是记录数据已经被删除。
 * 当数组没有更多空间存储数据时，我们再触发执行一次真正的删除操作，这样就大大减少了删除操作导致的数据搬移。
 *
 *
 * ArrayList 最大的优势就是可以将很多数组操作的细节封装起来。
 * 比如前面提到的数组插入、删除数据时需要搬移其他数据等。另
 * 外，它还有一个优势，就是支持动态扩容。每次存储空间不够的时候，它都会将空间自动扩容为 1.5 倍大小。
 * 最好在创建 ArrayList 的时候事先指定数据大小。
 * @Date 2019/10/25 22:32
 * @Version 1.0
 */
public class Array {

    private int[] data;

//    private

    public static void main(String[] args) {
        int capacity = 10000;
        ArrayList<Object> objects = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; ++i) {
            objects.add("xxx");
        }
        System.out.println(objects);
    }
}
