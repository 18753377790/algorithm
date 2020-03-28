package com.geekbang.algorithm.basic.hash;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author 李非凡
 * @Description:
 * 散列表和链表的组合使用
 * 1.LRU 缓存淘汰算法
 * 使用双向链表存储数据，链表中的每个结点处理存储数据（data）、前驱指针（prev）、后继指针（next）之外，还新增了一个特殊的字段 hnext。
 * 2.Redis 有序集合
 *
 * 3.Java LinkedHashMap
 * LinkedHashMap 是通过双向链表和散列表这两种数据结构组合实现的。
 * LinkedHashMap 中的“Linked”实际上是指的是双向链表，并非指用链表法解决散列冲突。
 * @Date 2019/12/2 16:45
 * @Version 1.0
 */
public class LinkedHashTable {

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new LinkedHashMap<>();
        map.put(3, 11);
        map.put(1, 12);
        map.put(5, 23);
        map.put(2, 22);

        for (Map.Entry e : map.entrySet()) {
            System.out.println(e.getKey());
        }

        // 10 是初始大小，0.75 是装载因子，true 是表示按照访问时间排序
        HashMap<Integer, Integer> m = new LinkedHashMap<>(10, 0.75f, true);
        m.put(3, 11);
        m.put(1, 12);
        m.put(5, 23);
        m.put(2, 22);

        m.put(3, 26);
        m.get(5);

        for (Map.Entry e : m.entrySet()) {
            System.out.println(e.getKey());
        }
    }
}
