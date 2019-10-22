package com.algorithm.lb.hash;

/**
 * @Author 李非凡
 * @Description:
 * 自定义HashMap
 * 什么是Hash算法：以空间换时间
 *
 * 给你n个自然数（1<n<10），每个数的范围是1~100。判断一个数是否在这n个数呢，不准使用现成的HashMap，如何实现
 * 1.排序+二分：可以解决，快排+二分，时间复杂度最好是nlogn最坏是n^2
 * 2.全部遍历比较，时间复杂度为O(n)
 * 3.自定义实现Hash
 * 4.数组实现，时间复杂度为O(1)
 * array[100]：用对应的下标表示数字，有就是array[n]为1，没有就为0，简单的Hash
 * 取模：n个数，那么最多就是n个空间，对n取模，其实就是Hash函数
 * array[10]初始化每个元素值为-1
 * 10,50，63，1，5
 * 10%10=0 array[0]=10->50 0是HashCode，对应的数据有重复的，就是Hash冲突，把数组的元素变成链表
 * 50%10=0
 * 63%10=3 array[3]=63
 * ....
 * nn%n
 * Hash的效率取决于Hash冲突的数量，Hash冲突的数量取决于Hash算法
 *
 * jdk1.7之前，数组加链表，Hash表是数组，每个数组的元素是链表
 * HashCode:point->value->value->value->value
 * HashCode:point->value->value->value->value
 * HashCode:point->value->value->value->value
 * jdk1.8之后，链表的数据长度大于8时变为红黑树（因为经过测试，大于8转红黑树是效率最高的），其实里面就是Hash冲突的数据
 *
 * HashMap和Hashtable的区别
 * 1.线程同步，安全性问题：HashMap是线程非安全的，Hashtable是线程安全的（synchronized方法）
 *   并发（多线程）环境下，HashMap不可使用put和remove方法，只能用get方法，因为扩容（缩容）会重新计算Hash值
 *   经典例子：缓存（不会更新），全局过滤
 * 2.效率问题：HashMap效率高，Hashtable因为有synchronized关键字
 * 3.Null值问题：Hashtable的key值不可以为空，HashMap可以
 *
 * LinkedHashMap的原理
 * 组成结构LinkedList + HashMap
 * HashMap存储是无序的
 * LinkedHashMap存储是有序的
 * key和value都可以为空
 * 单线程，线程不安全
 * key值有序
 * @Date 2019/9/14 20:04
 * @Version 1.0
 *
 * @param <K>
 * @param <V>
 */
public class MyHashMap<K, V> {

    /**
     * 默认的空间大小，存多少个数据，1左移4位是16
     */
    private static final int DEFAULT_SIZE = 1 << 4;

    /**
     * 存数据的Hash表
     */
    private Entry<K, V>[] data;

    /**
     * 空间大小，会扩容，Hash表的数组长度
     */
    private int capacity;

    /**
     * 大小
     */
    private int size;

    public MyHashMap(){
        this(DEFAULT_SIZE);
    }

    public MyHashMap(int capacity) {
        if (capacity <= 0)
            capacity = DEFAULT_SIZE;
        this.capacity = capacity;
        data = new Entry[capacity];
    }

    /**
     * HashMap的put方法
     * @param key
     * @param value
     */
    public void put(K key, V value){
        // HashMap key和value都可以为null
        if (key == null)
            return;
        // 少了一个扩容
//        if (size >= 0.75 * capacity)
//        resize()会把所有的数据（Hash值）重新计算一次
        // 计算hash值
        int hash = hash(key);
        // 新进来一个数据
        Entry<K, V> newE = new Entry<K, V>(key,value,null);
        // 判断有没有Hash冲突
        Entry<K, V> hashM = data[hash];
        // 有Hash冲突
        while (hashM != null){
            // 表示是一样的key，会覆盖，HashMap的key值不允许重复，1->2，1—>3，那就变成3了
            if (hashM.key.equals(key)){
                hashM.value = value;
                return;
            }
            // 链表后移
            hashM = hashM.next;
        }
        // 少了一个红黑树 就是这个hashM空间大于等于8，用TreeMap（底层就是红黑树）
        // 表示加入链表，这样就加在了链表的头
        newE.next = data[hash];
        data[hash] = newE;
        size++;
    }

    /**
     * HashMap的get方法
     * @param key
     * @return
     */
    public V get(K key){
        // 计算hash值
        int hash = hash(key);
        // 取出对应的链表
        Entry<K, V> entry = data[hash];
        // 链表遍历取数据
        while (entry != null){
            // key的HashCode和value比较的时候，即找value的时候，用equals()方法，并不是HashCode一样，因为此时key的HashCode一样
            if (entry.key.equals(key)){
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    /**
     * Hash函数
     * jdk测试出来的最优Hash算法
     * @param key
     * @return
     */
    private int hash(K key){
        int h = 0;
        if (key == null)
            h = 0;
        else {
            h = key.hashCode() ^ (h >>> 16); // 无符号右移16位
        }
        return h % capacity;
    }

    public static void main(String[] args) {
        MyHashMap<String ,String> map = new MyHashMap<>();
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        System.out.println(map.get("1"));
        System.out.println(map.get("4"));
        // HashCode相等，值不一定相等，即equals()不一定相等，但是equals相等，HashCode一定相等
        // Redis+lua，高并发情况下，lua可以把几条命令变成一条命令
        // ThreadPoolExecutor线程池框架，不要用Executor executor！
        // Java编程内功：数据结构和算法，Java基础，设计模式
    }
}

/**
 * jdk1.7的HashMap的数据结构key-value，无红黑树
 * @param <K>
 * @param <V>
 */
class Entry<K, V>{
    // 键
    K key;
    // 值
    V value;

    // 指针，链表的指针
    Entry<K, V> next;
    // Hash冲突的个数
    int cap;

    public Entry(K key, V value, Entry<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
}
