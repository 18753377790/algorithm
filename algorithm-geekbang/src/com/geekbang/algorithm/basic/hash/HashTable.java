package com.geekbang.algorithm.basic.hash;

/**
 * @Author 李非凡
 * @Description:
 * 散列表（hash表）
 * 散列表用的就是数组支持按照下标随机访问的时候，时间复杂度是 O(1) 的特性。
 * 我们通过散列函数把元素的键值映射为下标，然后将数据存储在数组中对应下标的位置。
 * 当我们按照键值查询元素时，我们用同样的散列函数，将键值转化数组下标，从对应的数组下标的位置取数据。
 *
 * 散列表两个核心问题是散列函数设计和散列冲突解决。
 *
 * 装载因子——表示空位的多少
 * 散列表的装载因子 = 填入表中的元素个数 / 散列表的长度
 * 装载因子越大，说明空闲位置越少，冲突越多，散列表的性能会下降。
 * 装载因子阈值需要选择得当。如果太大，会导致冲突过多；如果太小，会导致内存浪费严重。
 *
 * 时间复杂度
 * 插入元素
 * 最好：O(1)
 * 最坏：O(n)——触发扩容操作
 * 平均：O(1)
 * 查找元素
 * 最好：O(1)
 * 最坏：
 * @Date 2019/12/2 15:14
 * @Version 1.0
 */
public class HashTable {

    /**
     * 散列表的容量
     */
    private static final int CAPACITY = 1 << 4;

    /**
     *
     */
    private final char[] value = {1,2,3};

    /**
     *
     */
    private int hash;

    /**
     * 散列（hash）函数：
     * 散列函数是一个函数。可以把它定义成hash(key)，其中 key 表示元
     * 素的键值，hash(key) 的值表示经过散列函数计算得到的散列值。
     *
     * 散列函数设计的基本要求：
     * 1. 散列函数计算得到的散列值是一个非负整数；
     * 2. 如果 key1 = key2，那 hash(key1) == hash(key2)；
     * 3. 如果 key1 ≠ key2，那 hash(key1) ≠ hash(key2)。——散列（hash）冲突
     *
     * 散列（hash）冲突：
     * 1.开放寻址法（ThreadLocalMap——线性探测）
     * 线性探测：
     * 二次探测：
     * 双重散列：用多个散列函数
     * 当数据量比较小、装载因子小的时候，适合采用开放寻址法。这也是Java 中的ThreadLocalMap使用开放寻址法解决散列冲突的原因。
     * 2.链表地址法（HashMap，LinkedHashMap）
     * 在散列表中，每个“桶（bucket）”或者“槽（slot）”会对应一条链表，所有散列值相同的元素我们都放到相同槽位对应的链表中。
     * 基于链表的散列冲突处理方法比较适合存储大对象、大数据量的散列表，而且，比起开放寻址法，它更加灵活，支持更多的优化策略，比如用红黑树代替链表。
     * @param key key值
     * @return hash值
     */
    private int hash(String key) {
        String lastTwoChars = key.substring(key.length() - 2);
        return Integer.parseInt(lastTwoChars);
    }

    /**
     * 散列函数的设计不能太复杂。
     * 散列函数生成的值要尽可能随机并且均匀分布
     * @param key key值
     * @return hash值
     */
    private int hash(Object key) {
        int h = key.hashCode();
        // CAPACITY 表示散列表的大小
        return (h ^ (h >>> 16)) & (CAPACITY -1);
    }

    /**
     * hashCode方法
     * @return hash值
     */
    @Override
    public int hashCode() {
        int var1 = this.hash;
        if(var1 == 0 && this.value.length > 0) {
            char[] var2 = this.value;
            for(int var3 = 0; var3 < this.value.length; ++var3) {
                var1 = 31 * var1 + var2[var3];
            }
            this.hash = var1;
        }
        return var1;
    }

    public static void main(String[] args) {

    }
}
