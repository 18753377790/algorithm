package com.algorithm.data_structure;

/**
 * @Author 李非凡
 * @Description:
 * 顺序表
 * @Date 2019/11/4 22:32
 * @Version 1.0
 */
public class SequentialList {

    /**
     * 定义顺序表的最大长度
     */
    private static final int MAX_LENGTH = 100;

    /**
     *
     */
    private Data[] data = new Data[MAX_LENGTH + 1];

    /**
     *
     */
    private int length;

    /**
     *
     */
    private static class Data{
        private String key;
        private String name;
        private int age;
    }

    /**
     * 初始化顺序表
     * @param list
     */
    public void init(SequentialList list) {
        list.length = 0;
    }

    /**
     * 计算顺序表长度
     * @param list
     * @return
     */
    public int length(SequentialList list) {
        return list.length;
    }

    /**
     * 插入结点
     * @param list
     * @param n
     * @param data
     * @return
     */
    public int insert(SequentialList list, int n, Data data) {
        int i;

        if (list.length > MAX_LENGTH) {
            System.out.println();
            return 0;
        }

        if (n < 1 || n > list.length - 1)
            return 0;
        return 1;
    }

    /**
     *
     * @param list
     * @param data
     * @return
     */
    public int add(SequentialList list, Data data) {
        return 0;
    }

    /**
     *
     * @param list
     * @param n
     * @return
     */
    public int delete(SequentialList list, int n) {
        return 0;
    }

    /**
     *
     * @param list
     * @param n
     * @return
     */
    public Data findByNumber(SequentialList list, int n) {
        return null;
    }

    /**
     *
     * @param list
     * @param key
     * @return
     */
    public int findByContent(SequentialList list, String key) {
        return 0;
    }

    /**
     * 显示所有结点
     * @param list
     * @return
     */
    public int all(SequentialList list) {
        int i;
        for (int j = 0; j < list.length; j++) {

        }
        return 0;
    }
}
